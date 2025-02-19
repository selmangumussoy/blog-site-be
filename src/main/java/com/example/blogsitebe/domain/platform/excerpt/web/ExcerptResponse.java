package com.example.blogsitebe.domain.platform.excerpt.web;

import lombok.Builder;

@Builder
public record ExcerptResponse(
        String content,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber
) {
}
