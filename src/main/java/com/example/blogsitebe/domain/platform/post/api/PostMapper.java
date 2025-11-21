package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.post.impl.Post;
import com.example.blogsitebe.domain.platform.post.web.PostRequest;
import com.example.blogsitebe.domain.platform.post.web.PostResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PostMapper implements
        AbstractEntityMapper<Post, PostDto>,
        AbstractWebMapper<PostDto, PostRequest, PostResponse> {

    private final UserService userService; // 👈 Bu satır olmazsa isimler gelmez

    @Override
    public Post toEntity(PostDto dto) {
        Post e = new Post();
        e.setType(dto.getType());
        e.setParentId(dto.getParentId());
        e.setUserId(dto.getUserId());
        e.setContent(dto.getContent());
        e.setTagId(dto.getTagId());
        e.setLikeCount(dto.getLikeCount());
        e.setCommentCount(dto.getCommentCount());
        return e;
    }

    @Override
    public PostDto entityToDto(Post entity) {
        return PostDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .type(entity.getType())
                .parentId(entity.getParentId())
                .userId(entity.getUserId())
                .content(entity.getContent())
                .tagId(entity.getTagId())
                .likeCount(entity.getLikeCount())
                .commentCount(entity.getCommentCount())
                .build();
    }

    @Override
    public PostDto requestToDto(PostRequest req) {
        return PostDto.builder()
                .type(req.getType())
                .parentId(req.getParentId())
                .userId(req.getUserId())
                .content(req.getContent())
                .tagId(req.getTagId())
                .likeCount(req.getLikeCount())
                .commentCount(req.getCommentCount())
                .build();
    }

    @Override
    public PostResponse toResponse(PostDto dto) {
        // 👇 KULLANICI BİLGİLERİNİ DOLDURMA MANTIĞI
        String username = "Bilinmeyen";
        String fullName = "Anonim";

        try {
            if (dto.getUserId() != null) {
                UserDto user = userService.getById(dto.getUserId());
                username = user.getUserName();
                fullName = user.getFullName();
            }
        } catch (Exception e) {
            // Hata olursa varsayılan değerlerle devam et
        }

        return PostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .type(dto.getType())
                .parentId(dto.getParentId())
                .userId(dto.getUserId())
                .content(dto.getContent())
                .tagId(dto.getTagId())
                .likeCount(dto.getLikeCount())
                .commentCount(dto.getCommentCount())
                .username(username)
                .fullName(fullName)
                .build();
    }
}