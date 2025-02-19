package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;

public class ExcerptMapper {
    public static Excerpt toEntity(Excerpt excerpt,ExcerptDto dto) {
        excerpt.setUserId(dto.userId());
        excerpt.setTagId(dto.tagId());
        excerpt.setBookLanguage(dto.bookLanguage());
        excerpt.setContent(dto.content());
        excerpt.setSourceTitle(dto.sourceTitle());
        excerpt.setBookPageNumber(dto.bookPageNumber());
        return excerpt;

    }

    public static ExcerptDto toDto(Excerpt excerpt) {
        return ExcerptDto.builder()
                .userId(excerpt.getUserId())
                .tagId(excerpt.getTagId())
                .bookLanguage(excerpt.getBookLanguage())
                .content(excerpt.getContent())
                .sourceTitle(excerpt.getSourceTitle())
                .bookPageNumber(excerpt.getBookPageNumber())
                .userId(excerpt.getUserId())
                .build();
    }
}
