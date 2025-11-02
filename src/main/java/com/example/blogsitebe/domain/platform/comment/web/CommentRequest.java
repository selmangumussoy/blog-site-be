package com.example.blogsitebe.domain.platform.comment.web;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class CommentRequest  {
    private String postId;
    private String userId;
    private String parentCommentId;
    private String content;
}
