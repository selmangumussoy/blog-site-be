package com.example.blogsitebe.domain.platform.comment.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.List;

public interface CommentRepository extends AbstractRepository<Comment> {
    List<Comment> findAllByPostId(String postId);
}
