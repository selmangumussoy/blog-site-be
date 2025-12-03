package com.example.blogsitebe.domain.platform.comment.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

import java.util.List;

public interface CommentService extends AbstractService<CommentDto> {
    List<CommentDto> getCommentsByPostId(String postId);
}
