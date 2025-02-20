package com.example.blogsitebe.domain.platform.excerpt.web;

import lombok.Builder;

import java.util.List;

@Builder
public record ExcerptRequest (
        List<String> tagId,
        String userId,
        String content,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber
){
}
