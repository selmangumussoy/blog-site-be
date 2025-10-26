package com.example.blogsitebe.domain.platform.thoughtentity.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThoughtRequest {
    private String postId;
}