package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.domain.platform.post.api.PostType;
import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PostResponse extends AbstractResponse {
    private PostType type;
    private String parentId;
    private String userId;
    private String content;
    private String tagId;
    private Integer likeCount;
    private Integer commentCount;
    private String username;
    private String fullName;
}