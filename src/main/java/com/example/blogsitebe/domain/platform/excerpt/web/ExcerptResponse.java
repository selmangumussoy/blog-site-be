package com.example.blogsitebe.domain.platform.excerpt.web;

import lombok.Builder;

import java.util.List;

@Builder
public record ExcerptResponse(
        List<String> tagId,
        String content,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber
) {
}
