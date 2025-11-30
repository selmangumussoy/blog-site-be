package com.example.blogsitebe.domain.platform.userstats.impl;

import com.example.blogsitebe.domain.platform.userstats.api.UserStatsDto;
import com.example.blogsitebe.domain.platform.userstats.api.UserStatsService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserStatsServiceImpl extends AbstractServiceImpl<UserStats, UserStatsDto> implements UserStatsService {
    private final UserStatsRepository repository;

    public UserStatsServiceImpl(UserStatsRepository repository, AbstractEntityMapper<UserStats, UserStatsDto> mapper) {
        super(repository, mapper);
        this.repository= repository;
    }

    @Override
    protected String getEntityName() {
        return UserStats.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(UserStats entity, UserStatsDto dto) {
        entity.setFollowerCount(dto.getFollowerCount());
        entity.setFollowedCount(dto.getFollowedCount());
        entity.setPostCount(dto.getPostCount());
        entity.setUserId(dto.getUserId());
    }
}
