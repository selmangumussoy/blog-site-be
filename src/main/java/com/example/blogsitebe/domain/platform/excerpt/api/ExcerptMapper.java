package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptRequest;
import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptResponse;

public class ExcerptMapper {
    public static ExcerptDto toDto(ExcerptRequest request) {
        return ExcerptDto.builder()
                .userId(request.userId())
                .sourceTitle(request.sourceTitle())
                .bookPageNumber(request.bookPageNumber())
                .bookLanguage(request.bookLanguage())
                .tagId(request.tagId())
                .content(request.content())
                .build();
    }

    public static ExcerptResponse toResponse(ExcerptDto excerpt) {
        return ExcerptResponse.builder()
                .bookLanguage(excerpt.bookLanguage())
                .bookPageNumber(excerpt.bookPageNumber())
                .content(excerpt.content())
                .sourceTitle(excerpt.sourceTitle())
                .build();
    }
}
