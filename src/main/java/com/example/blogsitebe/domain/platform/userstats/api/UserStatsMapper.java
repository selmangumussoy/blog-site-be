package com.example.blogsitebe.domain.platform.userstats.api;


import com.example.blogsitebe.domain.platform.userstats.impl.UserStats;
import com.example.blogsitebe.domain.platform.userstats.web.UserStatsRequest;
import com.example.blogsitebe.domain.platform.userstats.web.UserStatsResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class UserStatsMapper implements
        AbstractEntityMapper<UserStats, UserStatsDto>,
        AbstractWebMapper<UserStatsDto, UserStatsRequest, UserStatsResponse> {

    @Override
    public UserStats toEntity(UserStatsDto dto) {
        UserStats e = new UserStats();
        e.setUserId(dto.getUserId());
        e.setFollowerCount(dto.getFollowerCount());
        e.setFollowedCount(dto.getFollowedCount());
        e.setPostCount(dto.getPostCount());
        return e;
    }

    @Override
    public UserStatsDto entityToDto(UserStats entity) {
        return UserStatsDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .userId(entity.getUserId())
                .followerCount(entity.getFollowerCount())
                .followedCount(entity.getFollowedCount())
                .postCount(entity.getPostCount())
                .build();
    }

    @Override
    public UserStatsDto requestToDto(UserStatsRequest req) {
        return UserStatsDto.builder()
                .userId(req.getUserId())
                .followerCount(req.getFollowerCount())
                .followedCount(req.getFollowedCount())
                .postCount(req.getPostCount())
                .build();
    }

    @Override
    public UserStatsResponse toResponse(UserStatsDto dto) {
        return UserStatsResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .userId(dto.getUserId())
                .followerCount(dto.getFollowerCount())
                .followedCount(dto.getFollowedCount())
                .postCount(dto.getPostCount())
                .build();
    }
}
