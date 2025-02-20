package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTag;

import java.util.List;
import java.util.stream.Collectors;

public class ExcerptMapper {
    public static Excerpt toEntity(Excerpt excerpt,ExcerptDto dto) {
        excerpt.setUserId(dto.userId());
        excerpt.setBookLanguage(dto.bookLanguage());
        excerpt.setContent(dto.content());
        excerpt.setSourceTitle(dto.sourceTitle());
        excerpt.setBookPageNumber(dto.bookPageNumber());
        return excerpt;

    }

    public static ExcerptDto toDto(Excerpt excerpt, List<ExcerptTag> excerptTags) {
        return ExcerptDto.builder()
                .tagId(convertExcerptTagsToString(excerptTags))
                .userId(excerpt.getUserId())
                .bookLanguage(excerpt.getBookLanguage())
                .content(excerpt.getContent())
                .sourceTitle(excerpt.getSourceTitle())
                .bookPageNumber(excerpt.getBookPageNumber())
                .userId(excerpt.getUserId())
                .build();
    }

    public static List<String> convertExcerptTagsToString(List<ExcerptTag> excerptTags) {
        return excerptTags.stream()
                .map(ExcerptTag::getTagId)
                .distinct()
                .collect(Collectors.toList());
    }
}
