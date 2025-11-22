package com.example.blogsitebe.domain.platform.blogpost.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

public interface BlogPostService extends AbstractService<BlogPostDto> {
    BlogPostDto getByPostId(String postId);
}
