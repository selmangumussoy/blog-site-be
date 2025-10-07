package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostDto extends AbstractDto {
    private String title;
    private String content;
    private String author;
    private String coverImage;
    private Boolean published;
}
