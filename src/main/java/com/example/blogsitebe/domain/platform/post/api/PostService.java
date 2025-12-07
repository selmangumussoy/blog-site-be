package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

import java.util.List;

public interface PostService extends AbstractService<PostDto> {
    List<PostDto> getAllByUserId(String userId);
    void increaseCommentCount(String postId);
    void decreaseCommentCount(String postId);
}
