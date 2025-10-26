package com.example.blogsitebe.domain.platform.like.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class LikeDto extends AbstractDto{
    private String userId;
    private String postId;
}
