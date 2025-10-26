package com.example.blogsitebe.domain.platform.postimage.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostImageResponse extends AbstractResponse {
    private Long postId;
    private String url;
    private Integer orderIndex;
}
