package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.domain.platform.post.api.PostDto;
import com.example.blogsitebe.domain.platform.post.api.PostMapper;
import com.example.blogsitebe.domain.platform.post.api.PostService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl extends AbstractServiceImpl<Post, PostDto> implements PostService {

    public PostServiceImpl(PostRepository repository, PostMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected String getEntityName() {
        return "Post";
    }

    @Override
    protected void updateEntityFields(Post entity, PostDto dto) {
        entity.setType(dto.getType());
        entity.setParentId(dto.getParentId());
        entity.setUserId(dto.getUserId());
        entity.setContent(dto.getContent());
        entity.setTagId(dto.getTagId());
        entity.setLikeCount(dto.getLikeCount());
        entity.setCommentCount(dto.getCommentCount());
    }
    @Override
    public List<PostDto> getAllByUserId(String userId) {
        return ((PostRepository) repository).findAllByUserIdOrderByCreatedDesc(userId)
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }
}