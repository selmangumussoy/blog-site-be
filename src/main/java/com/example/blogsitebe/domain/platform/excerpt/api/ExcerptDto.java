package com.example.blogsitebe.domain.platform.excerpt.api;

import lombok.Builder;

import java.util.List;

@Builder
public record ExcerptDto(
        String id,
        String created,
        String modified,
        String content,
        String userId,
        List<String> tagId,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber
) {
}
