package com.example.blogsitebe.domain.platform.userstats.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.Optional;


public interface UserStatsRepository extends AbstractRepository<UserStats> {

    Optional<UserStats> findByUserId(String followedId);
}
