package com.example.blogsitebe.domain.platform.userstats.web;

import lombok.Data;

@Data
public class UserStatsRequest {
    private String userId;
    private Integer followerCount;
    private Integer followedCount;
    private Integer postCount;
}
