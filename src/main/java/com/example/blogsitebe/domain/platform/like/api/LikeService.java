package com.example.blogsitebe.domain.platform.like.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

public interface LikeService extends AbstractService<LikeDto> {
    // True dönerse beğendi, False dönerse beğeniyi geri aldı
    boolean toggleLike(String userId, String postId);
}