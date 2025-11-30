package com.example.blogsitebe.domain.platform.userstats.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

public interface UserStatsService extends AbstractService<UserStatsDto> {
    void createInitialStats(String id);

    UserStatsDto getByUserId(String userId);
}
