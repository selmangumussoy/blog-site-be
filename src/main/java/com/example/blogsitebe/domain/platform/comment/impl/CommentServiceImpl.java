package com.example.blogsitebe.domain.platform.comment.impl;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.comment.api.CommentDto;
import com.example.blogsitebe.domain.platform.comment.api.CommentService;
import com.example.blogsitebe.domain.platform.post.api.PostService;
import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;
import com.example.blogsitebe.domain.platform.profile.api.ProfileService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractRepository;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import com.example.blogsitebe.library.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Comment, CommentDto> implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final ProfileService profileService;
    private final PostService postService;

    public CommentServiceImpl(CommentRepository repository, AbstractEntityMapper<Comment, CommentDto> mapper, UserService userService,
                              ProfileService profileService, PostService postService) {
        super(repository, mapper);
        this.commentRepository = repository;
        this.userService = userService;
        this.profileService = profileService;
        this.postService = postService;
    }

    @Override
    protected String getEntityName() {
        return Comment.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(Comment entity, CommentDto dto) {
        entity.setContent(dto.getContent());
    }

    @Override
    @Transactional // İşlemlerin bütünlüğü için Transactional eklemek iyi olur
    public CommentDto create(CommentDto dto) {
        // 1. Kullanıcı ID'sini al
        String currentUserId = JwtUtil.extractUserIdAndIfAnonymousThrow();
        dto.setUserId(currentUserId);

        // 2. Yorumu kaydet (AbstractServiceImpl içindeki create metodu çalışır)
        CommentDto createdComment = super.create(dto);

        // 3. Post üzerindeki yorum sayısını artır (YENİ EKLENEN KISIM)
        if (dto.getPostId() != null) {
            postService.increaseCommentCount(dto.getPostId());
        }

        return createdComment;
    }

    @Override
    public List<CommentDto> getCommentsByPostId(String postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);

        return comments.stream()
                .map(comment -> {
                    CommentDto dto = mapper.entityToDto(comment);

                    try {
                        UserDto user = userService.getById(comment.getUserId());
                        dto.setUsername(user.getUserName());
                        dto.setUserFullName(user.getFullName());
                        if (user.getProfileId() != null) {
                            ProfileDto profile = profileService.getById(user.getProfileId());
                            dto.setUserPicture(profile.getPicture());
                        }
                    } catch (Exception e) {
                        dto.setUsername("Unknown User");
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String id) {
        // 1. Silinecek yorumu bul (Post ID'sini almak için gerekli)
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        String postId = comment.getPostId();

        // 2. Yorumu sil (Standart silme işlemi)
        super.delete(id);

        // 3. Post servisinden sayacı düşür
        if (postId != null) {
            postService.decreaseCommentCount(postId);
        }
    }
}
