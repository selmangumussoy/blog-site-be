package com.example.blogsitebe.domain.platform.savedpost.web;

import com.example.blogsitebe.domain.platform.savedpost.impl.SavedPost;
import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class SavedPostResponse extends AbstractResponse {
    private String postId;
    private String userId;
}
