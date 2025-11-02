package com.example.blogsitebe.domain.platform.follow.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class FollowResponse extends AbstractResponse {
    private String followerId;
    private String followingId;

}
