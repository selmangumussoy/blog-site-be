package com.example.blogsitebe.domain.platform.blogpost.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BlogPostDto extends AbstractDto {
    private String blogContent;
    private String postId;
    private String title;
}
