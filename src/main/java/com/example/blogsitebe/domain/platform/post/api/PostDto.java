package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostDto extends AbstractDto {
    private PostType type;
    private Long parentId;
    private Long userId;
    private String content;
    private Long tagId;
    private Integer likeCount;
    private Integer commentCount;
}