package com.example.blogsitebe.domain.platform.follow.api;

import com.example.blogsitebe.domain.platform.follow.impl.Follow;
import com.example.blogsitebe.domain.platform.follow.web.FollowRequest;
import com.example.blogsitebe.domain.platform.follow.web.FollowResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class FollowMapper implements AbstractEntityMapper<Follow,FollowDto>, AbstractWebMapper<FollowDto, FollowRequest,FollowResponse> {
    @Override
    public Follow toEntity(FollowDto d) {
        Follow e = new Follow();
        e.setFollowerId(d.getFollowerId());
        e.setFollowedId(d.getFollowedId());
        return e;
    }

    @Override
    public FollowDto entityToDto(Follow e) {
        return FollowDto.builder()
                .id(e.getId())
                .created(e.getCreated())
                .modified(e.getModified())
                .followerId(e.getFollowerId())
                .followedId(e.getFollowedId())
                .build();
    }

    @Override
    public FollowDto requestToDto(FollowRequest r) {
        return FollowDto.builder()
                .followerId(r.getFollowerId())
                .followedId(r.getFollowedId())
                .build();
    }

    @Override
    public FollowResponse toResponse(FollowDto d) {
        return FollowResponse.builder()
                .id(d.getId())
                .created(d.getCreated())
                .modified(d.getModified())
                .followerId(d.getFollowerId())
                .followedId(d.getFollowedId())
                .build();
    }
}
