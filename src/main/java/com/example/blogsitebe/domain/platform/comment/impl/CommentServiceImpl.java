package com.example.blogsitebe.domain.platform.comment.impl;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.comment.api.CommentDto;
import com.example.blogsitebe.domain.platform.comment.api.CommentService;
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

    public CommentServiceImpl(CommentRepository repository, AbstractEntityMapper<Comment, CommentDto> mapper,UserService userService,
                              ProfileService profileService) {
        super(repository, mapper);
        this.commentRepository = repository;
        this.userService = userService;
        this.profileService = profileService;
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
    public CommentDto create(CommentDto dto) {
        String currentUserId = JwtUtil.extractUserIdAndIfAnonymousThrow();
        dto.setUserId(currentUserId);
        return super.create(dto);
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

}
