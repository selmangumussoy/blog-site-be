package com.example.blogsitebe.domain.platform.blogpost.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostRequest {
    private String blogContent;
    private String postId;
    private String title;
}

