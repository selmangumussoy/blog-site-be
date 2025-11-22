package com.example.blogsitebe.domain.platform.blogpost.impl;

import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostDto;
import com.example.blogsitebe.domain.platform.blogpost.api.BlogPostService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractRepository;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BlogPostServiceImpl extends AbstractServiceImpl<BlogPost, BlogPostDto> implements BlogPostService {
    public BlogPostServiceImpl(AbstractRepository<BlogPost> repository,
                               AbstractEntityMapper<BlogPost, BlogPostDto> mapper) {
        super(repository, mapper);
    }

    @Override
    protected String getEntityName() {
        return BlogPost.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(BlogPost e, BlogPostDto d) {
        e.setBlogContent(d.getBlogContent());
        e.setPostId(d.getPostId());
    }
    @Override
    public BlogPostDto getByPostId(String postId) {
        return ((BlogPostRepository) repository).findByPostId(postId)
                .map(mapper::entityToDto)
                .orElse(null);
    }
}
