package com.example.blogsitebe.domain.platform.comment.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
public class CommentDto extends AbstractDto {
    private String postId;
    private String userId;
    private String parentCommentId;
    private String content;
}
