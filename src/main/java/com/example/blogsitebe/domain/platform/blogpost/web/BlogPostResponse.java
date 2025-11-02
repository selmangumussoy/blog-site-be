package com.example.blogsitebe.domain.platform.blogpost.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BlogPostResponse extends AbstractResponse {
    private String title;
    private String postId;
}
