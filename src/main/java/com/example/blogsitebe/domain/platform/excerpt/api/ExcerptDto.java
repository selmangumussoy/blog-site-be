package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import lombok.Builder;

import java.util.List;

@Builder
public record ExcerptDto(
        String id,
        String created,
        String modified,
        String content,
        String userId,
        List<TagDto> tagId,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber,
        String photo
) {
}
