package com.example.blogsitebe.domain.platform.comment.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommentResponse extends AbstractResponse {
    private String postId;
    private String userId;
    private String parentCommentId;
    private String content;
}
