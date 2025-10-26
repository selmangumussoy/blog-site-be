package com.example.blogsitebe.domain.platform.postimage.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostImageDto extends AbstractDto {
    private String postId;
    private String url;
    private Integer orderIndex;
}
