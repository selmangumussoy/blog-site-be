package com.example.blogsitebe.domain.platform.like.api;

import com.example.blogsitebe.domain.platform.like.impl.Like;
import com.example.blogsitebe.domain.platform.like.web.LikeRequest;
import com.example.blogsitebe.domain.platform.like.web.LikeResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class LikeMapper implements AbstractEntityMapper<Like, LikeDto>, AbstractWebMapper<LikeDto, LikeRequest, LikeResponse> {
    @Override
    public Like toEntity(LikeDto dto) {
        Like like = new Like();
        like.setId(dto.getId());
        like.setUserId(dto.getUserId());
        like.setPostId(dto.getPostId());
        return like;
    }

    @Override
    public LikeDto entityToDto(Like entity) {
        return LikeDto.builder()
                .id(entity.getId())
                .postId(entity.getPostId())
                .userId(entity.getUserId()) // DÜZELTİLDİ: Eskiden getPostId() idi.
                .created(entity.getCreated())
                .modified(entity.getModified())
                .build();
    }

    @Override
    public LikeDto requestToDto(LikeRequest request) {
        return LikeDto.builder()
                .userId(request.getUserId())
                .postId(request.getPostId())
                .build();
    }

    @Override
    public LikeResponse toResponse(LikeDto dto) {
        return LikeResponse.builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .postId(dto.getPostId())
                .build();
    }
}