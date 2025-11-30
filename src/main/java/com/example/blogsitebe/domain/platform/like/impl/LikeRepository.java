package com.example.blogsitebe.domain.platform.like.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends AbstractRepository<Like> {
    // Toggle işlemi için kullanmıştık
    Optional<Like> findByUserIdAndPostId(String userId, String postId);

    // 🔥 YENİ: Bir post ID'sine ait tüm like kayıtlarını getir
    List<Like> findAllByPostId(String postId);
}