package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.domain.platform.post.impl.Post;
import com.example.blogsitebe.domain.platform.post.web.PostRequest;
import com.example.blogsitebe.domain.platform.post.web.PostResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapper implements AbstractEntityMapper<Post,PostDto>, AbstractWebMapper<PostDto, PostRequest, PostResponse> {
    @Override
    public Post toEntity(PostDto dto) {
        Post e = new Post();
        e.setTitle(dto.getTitle());
        e.setContent(dto.getContent());
        e.setAuthor(dto.getAuthor());
        e.setCoverImage(dto.getCoverImage());
        e.setPublished(dto.getPublished());
        return e;
    }

    @Override
    public PostDto entityToDto(Post entity) {
        return PostDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .coverImage(entity.getCoverImage())
                .published(entity.getPublished())
                .build();
    }
    // Web katmanı
    @Override
    public PostDto requestToDto(PostRequest req) {
        return PostDto.builder()
                .title(req.getTitle())
                .content(req.getContent())
                .author(req.getAuthor())
                .coverImage(req.getCoverImage())
                .published(req.getPublished())
                .build();
    }

    @Override
    public PostResponse toResponse(PostDto dto) {
        return PostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .title(dto.getTitle())
                .content(dto.getContent())
                .author(dto.getAuthor())
                .coverImage(dto.getCoverImage())
                .published(dto.getPublished())
                .build();
    }
}
