package com.example.blogsitebe.domain.platform.blogpost.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.Optional;

public interface BlogPostRepository extends AbstractRepository<BlogPost> {
    Optional<BlogPost> findByPostId(String postId);
}
