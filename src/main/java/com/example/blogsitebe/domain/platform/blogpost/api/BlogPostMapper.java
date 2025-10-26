package com.example.blogsitebe.domain.platform.blogpost.api;

import com.example.blogsitebe.domain.platform.blogpost.impl.BlogPost;
import com.example.blogsitebe.domain.platform.blogpost.web.BlogPostRequest;
import com.example.blogsitebe.domain.platform.blogpost.web.BlogPostResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;


@Component
public class BlogPostMapper implements
        AbstractEntityMapper<BlogPost, BlogPostDto>,
        AbstractWebMapper<BlogPostDto, BlogPostRequest, BlogPostResponse> {
    @Override
    public BlogPost toEntity(BlogPostDto dto) {
        BlogPost e = new BlogPost();
        e.setTitle(dto.getTitle());
        e.setPostId(dto.getPostId());
        return e;
    }

    @Override
    public BlogPostDto entityToDto(BlogPost e) {
        return BlogPostDto.builder()
                .id(e.getId())
                .created(e.getCreated())
                .modified(e.getModified())
                .title(e.getTitle())
                .postId(e.getPostId())
                .build();
    }

    @Override
    public BlogPostDto requestToDto(BlogPostRequest req) {
        return BlogPostDto.builder()
                .title(req.title())
                .postId(req.postId())
                .build();
    }

    @Override
    public BlogPostResponse toResponse(BlogPostDto dto) {
        return BlogPostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .title(dto.getTitle())
                .postId(dto.getPostId())
                .build();
    }
}
