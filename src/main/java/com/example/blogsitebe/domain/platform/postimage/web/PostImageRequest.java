package com.example.blogsitebe.domain.platform.postimage.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostImageRequest {
    private Long postId;
    private String url;
    private Integer orderIndex;
}
