package com.example.blogsitebe.domain.platform.postimage.api;

import com.example.blogsitebe.domain.platform.postimage.impl.PostImage;
import com.example.blogsitebe.domain.platform.postimage.web.PostImageRequest;
import com.example.blogsitebe.domain.platform.postimage.web.PostImageResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostImageMapper implements
        AbstractEntityMapper<PostImage, PostImageDto>,
        AbstractWebMapper<PostImageDto, PostImageRequest, PostImageResponse> {

    @Override
    public PostImage toEntity(PostImageDto dto) {
        PostImage e = new PostImage();
        e.setPostId(dto.getPostId());
        e.setUrl(dto.getUrl());
        e.setOrderIndex(dto.getOrderIndex());
        return e;
    }

    @Override
    public PostImageDto entityToDto(PostImage entity) {
        return PostImageDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .postId(entity.getPostId())
                .url(entity.getUrl())
                .orderIndex(entity.getOrderIndex())
                .build();
    }

    @Override
    public PostImageDto requestToDto(PostImageRequest req) {
        return PostImageDto.builder()
                .postId(req.getPostId())
                .url(req.getUrl())
                .orderIndex(req.getOrderIndex())
                .build();
    }

    @Override
    public PostImageResponse toResponse(PostImageDto dto) {
        return PostImageResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .postId(dto.getPostId())
                .url(dto.getUrl())
                .orderIndex(dto.getOrderIndex())
                .build();
    }

    public List<PostImageDto> entityListToDtoList(List<PostImage> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
