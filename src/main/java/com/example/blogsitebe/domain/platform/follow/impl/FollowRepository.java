package com.example.blogsitebe.domain.platform.follow.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

public interface FollowRepository extends AbstractRepository<Follow> {

    boolean existsByFollowerIdAndFollowedId(String followerId, String followingId);
}
