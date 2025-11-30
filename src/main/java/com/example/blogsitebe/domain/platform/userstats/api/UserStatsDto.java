package com.example.blogsitebe.domain.platform.userstats.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class UserStatsDto extends AbstractDto {
    private String userId;
    private Integer followerCount;
    private Integer followedCount;
    private Integer postCount;
}
