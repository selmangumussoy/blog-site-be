package com.example.blogsitebe.domain.platform.savedpost.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SavedPostRequest {
    private String postId;
    private String userId;
}
