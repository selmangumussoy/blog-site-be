package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostDto extends AbstractDto {
    private PostType type;
    private String parentId;
    private String userId;
    private String content;
    private String tagId;
    private Integer likeCount;
    private Integer commentCount;
    private String title;
}