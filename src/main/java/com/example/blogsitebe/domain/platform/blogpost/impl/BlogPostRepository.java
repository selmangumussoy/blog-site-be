package com.example.blogsitebe.domain.platform.blogpost.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

public interface BlogPostRepository extends AbstractRepository<BlogPost> {
    // gerekirse: List<BlogPost> findAllByPostId(String postId);
}
