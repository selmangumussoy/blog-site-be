package com.example.blogsitebe.domain.platform.excerpt.web;

import lombok.Builder;

@Builder
public record ExcerptRequest (
        String tagId,
        String userId,
        String content,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber
){
}
