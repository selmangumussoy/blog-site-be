package com.example.blogsitebe.domain.platform.follow.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class FollowDto extends AbstractDto {
    private String followerId;
    private String followingId;
}
