package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import lombok.Builder;
import java.util.List;

@Builder
public record ExcerptResponse(
        List<TagDto> tagId,
        String content,
        String sourceTitle,
        String bookLanguage,
        String bookPageNumber,
        byte[] photo
) {
}
