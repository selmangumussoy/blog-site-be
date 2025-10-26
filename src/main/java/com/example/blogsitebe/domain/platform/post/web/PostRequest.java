package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.domain.platform.post.api.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private PostType type;
    private String parentId;
    private String userId;
    private String content;
    private String tagId;
    private Integer likeCount;
    private Integer commentCount;
}