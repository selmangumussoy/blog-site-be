package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptRequest;
import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptResponse;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import java.util.List;
import java.util.stream.Collectors;

public class ExcerptMapper {
    public static ExcerptDto toDto(ExcerptRequest request) {
        return ExcerptDto.builder()
                .userId(request.userId())
                .sourceTitle(request.sourceTitle())
                .bookPageNumber(request.bookPageNumber())
                .bookLanguage(request.bookLanguage())
                .tagDtoList(request.tagId().stream()
                        .map(tagId -> TagDto.builder().id(tagId).build())
                        .collect(Collectors.toList()))
                .content(request.content())
                .build();
    }

    public static ExcerptResponse toResponse(ExcerptDto excerpt) {
        return ExcerptResponse.builder()
                .tagId(excerpt.getTagDtoList())
                .bookLanguage(excerpt.getBookLanguage())
                .bookPageNumber(excerpt.getBookPageNumber())
                .content(excerpt.getContent())
                .sourceTitle(excerpt.getSourceTitle())
                .build();
    }


    public static List<ExcerptResponse> toResponses(List<ExcerptDto> excerptDtoList) {
        return excerptDtoList.stream()
                .map(ExcerptMapper::toResponse)
                .collect(Collectors.toList());
    }
}
