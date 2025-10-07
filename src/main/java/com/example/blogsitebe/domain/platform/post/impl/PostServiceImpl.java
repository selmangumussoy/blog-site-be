package com.example.blogsitebe.domain.platform.post.impl;

import com.example.blogsitebe.domain.platform.post.api.PostDto;
import com.example.blogsitebe.domain.platform.post.api.PostMapper;
import com.example.blogsitebe.domain.platform.post.api.PostService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

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
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setAuthor(dto.getAuthor());
        entity.setCoverImage(dto.getCoverImage());
        entity.setPublished(dto.getPublished());
    }
}
