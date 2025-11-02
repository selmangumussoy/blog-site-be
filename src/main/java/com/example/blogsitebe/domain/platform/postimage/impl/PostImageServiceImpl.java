package com.example.blogsitebe.domain.platform.postimage.impl;

import com.example.blogsitebe.domain.platform.postimage.api.PostImageDto;
import com.example.blogsitebe.domain.platform.postimage.api.PostImageMapper;
import com.example.blogsitebe.domain.platform.postimage.api.PostImageService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageServiceImpl extends AbstractServiceImpl<PostImage, PostImageDto> implements PostImageService {

    private final PostImageRepository postImageRepository;
    private final PostImageMapper mapper;

    public PostImageServiceImpl(PostImageRepository repository, PostImageMapper mapper) {
        super(repository, mapper);
        this.postImageRepository = repository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return "PostImage";
    }

    @Override
    protected void updateEntityFields(PostImage entity, PostImageDto dto) {
        entity.setUrl(dto.getUrl());
        entity.setOrderIndex(dto.getOrderIndex());
        entity.setPostId(dto.getPostId());
    }

    @Override
    public List<PostImageDto> findByPostId(String postId) {
        return mapper.entityListToDtoList(postImageRepository.findAllByPostIdOrderByOrderIndexAsc(postId));
    }
}
