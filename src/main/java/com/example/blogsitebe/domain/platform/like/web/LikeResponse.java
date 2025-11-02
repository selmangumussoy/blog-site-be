package com.example.blogsitebe.domain.platform.like.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class LikeResponse extends AbstractResponse {
    private String userId;
    private String postId;
}
