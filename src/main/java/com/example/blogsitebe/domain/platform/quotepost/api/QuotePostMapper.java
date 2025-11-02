package com.example.blogsitebe.domain.platform.quotepost.api;

import com.example.blogsitebe.domain.platform.quotepost.impl.QuotePost;
import com.example.blogsitebe.domain.platform.quotepost.web.QuotePostRequest;
import com.example.blogsitebe.domain.platform.quotepost.web.QuotePostResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class QuotePostMapper implements
        AbstractEntityMapper<QuotePost, QuotePostDto>,
        AbstractWebMapper<QuotePostDto, QuotePostRequest, QuotePostResponse> {
    // Entity -> DTO
    @Override
    public QuotePostDto entityToDto(QuotePost entity) {
        return QuotePostDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .title(entity.getTitle())
                .bookName(entity.getBookName())
                .author(entity.getAuthor())
                .quotePage(entity.getQuotePage())
                .publisher(entity.getPublisher())
                .totalPages(entity.getTotalPages())
                .thought(entity.getThought())
                .postId(entity.getPostId())
                .build();
    }

    // DTO -> Entity
    @Override
    public QuotePost toEntity(QuotePostDto dto) {
        QuotePost e = new QuotePost();
        e.setTitle(dto.getTitle());
        e.setBookName(dto.getBookName());
        e.setAuthor(dto.getAuthor());
        e.setQuotePage(dto.getQuotePage());
        e.setPublisher(dto.getPublisher());
        e.setTotalPages(dto.getTotalPages());
        e.setThought(dto.getThought());
        e.setPostId(dto.getPostId());
        return e;
    }

    // Request -> DTO
    @Override
    public QuotePostDto requestToDto(QuotePostRequest req) {
        return QuotePostDto.builder()
                .title(req.getTitle())
                .bookName(req.getBookName())
                .author(req.getAuthor())
                .quotePage(req.getQuotePage())
                .publisher(req.getPublisher())
                .totalPages(req.getTotalPages())
                .thought(req.getThought())
                .postId(req.getPostId())
                .build();
    }

    // DTO -> Response
    @Override
    public QuotePostResponse toResponse(QuotePostDto dto) {
        return QuotePostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .title(dto.getTitle())
                .bookName(dto.getBookName())
                .author(dto.getAuthor())
                .quotePage(dto.getQuotePage())
                .publisher(dto.getPublisher())
                .totalPages(dto.getTotalPages())
                .thought(dto.getThought())
                .postId(dto.getPostId())
                .build();
    }
}
