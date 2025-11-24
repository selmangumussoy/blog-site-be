package com.example.blogsitebe.domain.platform.quotepost.impl;

import com.example.blogsitebe.domain.platform.post.impl.PostRepository;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostDto;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostMapper;
import com.example.blogsitebe.domain.platform.quotepost.api.QuotePostService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class QuotePostServiceImpl extends AbstractServiceImpl<QuotePost, QuotePostDto> implements QuotePostService {

    private final QuotePostRepository quotePostRepository;

    public QuotePostServiceImpl(QuotePostRepository repository, QuotePostMapper mapper, PostRepository postRepository) {
        super(repository, mapper);
        this.quotePostRepository = repository;
    }

    @Override
    protected String getEntityName() {
        return "QuotePost";
    }

    @Override
    protected void updateEntityFields(QuotePost entity, QuotePostDto dto) {
        entity.setTitle(dto.getTitle());
        entity.setBookName(dto.getBookName());
        entity.setAuthor(dto.getAuthor());
        entity.setQuotePage(dto.getQuotePage());
        entity.setPublisher(dto.getPublisher());
        entity.setTotalPages(dto.getTotalPages());
        entity.setThought(dto.getThought());
    }

    @Override
    public QuotePostDto getByPostId(String postId) {
        return quotePostRepository.findByPostId(postId)
                .map(mapper::entityToDto)
                .orElse(null);
    }


}
