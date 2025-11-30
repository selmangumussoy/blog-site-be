package com.example.blogsitebe.domain.platform.userstats.web;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class UserStatsResponse extends AbstractDto {
    private String userId;
    private Integer followerCount;
    private Integer followedCount;
    private Integer postCount;
}
