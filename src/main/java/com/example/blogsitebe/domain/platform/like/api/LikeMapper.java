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
        like.setCreated(dto.getCreated());
        like.setModified(dto.getModified());
        return like;
    }

    @Override
    public LikeDto entityToDto(Like entity) {
       return LikeDto.builder()
               .postId(entity.getPostId())
               .userId(entity.getPostId())
               .created(entity.getCreated())
               .modified(entity.getModified())
               .id(entity.getId())
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
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }
}
