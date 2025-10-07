package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostResponse extends AbstractResponse {
    private String title;
    private String content;
    private String author;
    private String coverImage;
    private Boolean published;
}
