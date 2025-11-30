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
        e.setBlogContent( dto.getBlogContent() );
        e.setPostId(dto.getPostId());
        e.setTitle( dto.getTitle() );
        return e;
    }

    @Override
    public BlogPostDto entityToDto(BlogPost e) {
        return BlogPostDto.builder()
                .id(e.getId())
                .created(e.getCreated())
                .modified(e.getModified())
                .blogContent(e.getBlogContent())
                .postId(e.getPostId())
                .title(e.getTitle())
                .build();
    }

    @Override
    public BlogPostDto requestToDto(BlogPostRequest req) {
        return BlogPostDto.builder()
                .blogContent(req.getBlogContent())
                .postId(req.getPostId())
                .title(req.getTitle())
                .build();
    }

    @Override
    public BlogPostResponse toResponse(BlogPostDto dto) {
        return BlogPostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .blogContent(dto.getBlogContent())
                .postId(dto.getPostId())
                .title(dto.getTitle())
                .build();
    }
}
