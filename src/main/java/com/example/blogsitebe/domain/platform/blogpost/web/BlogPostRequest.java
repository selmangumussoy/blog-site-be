package com.example.blogsitebe.domain.platform.blogpost.web;

import lombok.Builder;

@Builder
public record BlogPostRequest (
          String title,
           String postId
) {}

