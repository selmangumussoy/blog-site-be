package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.domain.platform.post.api.PostType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private PostType type;
    private String parentId;
    private String userId;
    private String content;
    private Integer likeCount;
    private Integer commentCount;
    private String title;
    private List<String> tagIds;
}