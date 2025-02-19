package com.example.blogsitebe.domain.platform.excerpt.api;

import lombok.Builder;

@Builder
public record ExcerptDto(
        String id,
        String created,
        String modified,
        String content,
        String userId,
        String tagId,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber
) {
}
