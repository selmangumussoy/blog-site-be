package com.example.blogsitebe.domain.platform.post.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class PostDto extends AbstractDto {
    private PostType type;
    private String parentId;
    private String userId;
    private String content;
    private Integer likeCount;
    private Integer commentCount;
    private String title;
    private List<String> tags;
    private List<String> likes;
}