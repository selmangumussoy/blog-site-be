package com.example.blogsitebe.domain.platform.like.impl;

import com.example.blogsitebe.domain.platform.like.api.LikeDto;
import com.example.blogsitebe.domain.platform.like.api.LikeMapper;
import com.example.blogsitebe.domain.platform.like.api.LikeService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LikeServiceImpl extends AbstractServiceImpl<Like, LikeDto> implements LikeService {
    private final LikeRepository likeRepository;
    private final LikeMapper mapper;

    public LikeServiceImpl(LikeRepository repository, LikeMapper mapper) {
        super(repository, mapper);
        this.likeRepository = repository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return "Like";
    }

    @Override
    protected void updateEntityFields(Like entity, LikeDto dto) {
        entity.setUserId(dto.getUserId());
        entity.setPostId(dto.getPostId());
    }
}
