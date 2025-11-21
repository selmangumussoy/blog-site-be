package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.List;

public interface PostRepository extends AbstractRepository<Post> {
    List<Post> findAllByUserIdOrderByCreatedDesc(String userId);
}
