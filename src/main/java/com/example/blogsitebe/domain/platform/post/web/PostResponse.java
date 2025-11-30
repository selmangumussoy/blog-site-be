package com.example.blogsitebe.domain.platform.post.web;

import com.example.blogsitebe.domain.platform.post.api.PostType;
import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class PostResponse extends AbstractResponse {
    private PostType type;
    private String parentId;
    private String userId;
    private String content;
    private Integer likeCount;
    private Integer commentCount;
    private String username;
    private String fullName;
    private String title;
    private List<String> tags;
    private List<String> likes;
}