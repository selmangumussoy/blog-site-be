package com.example.blogsitebe.domain.platform.follow.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

public interface FollowRepository extends AbstractRepository<Follow> {

    boolean existsByFollowerIdAndFollowingId(String followerId, String followingId);
}
