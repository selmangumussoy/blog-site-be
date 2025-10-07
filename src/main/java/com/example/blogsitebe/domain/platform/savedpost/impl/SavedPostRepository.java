package com.example.blogsitebe.domain.platform.savedpost.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import org.springframework.data.repository.CrudRepository;

public interface SavedPostRepository extends AbstractRepository<SavedPost> {
    boolean existsByUserIdAndPostId(String userId, String postId);

}
