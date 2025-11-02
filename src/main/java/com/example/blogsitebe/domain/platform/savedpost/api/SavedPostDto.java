package com.example.blogsitebe.domain.platform.savedpost.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SavedPostDto extends AbstractDto {
    private String postId;
    private String userId;
    private String content;

}
