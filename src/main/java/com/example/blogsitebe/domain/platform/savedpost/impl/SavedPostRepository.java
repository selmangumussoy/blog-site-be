package com.example.blogsitebe.domain.platform.savedpost.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.List;

public interface SavedPostRepository extends AbstractRepository<SavedPost> {
    boolean existsByUserIdAndPostId(String userId, String postId);

    List<SavedPost> findAllByUserId(String userId);

}
