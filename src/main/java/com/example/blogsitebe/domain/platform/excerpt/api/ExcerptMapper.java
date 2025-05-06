package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptRequest;
import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptResponse;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import java.util.List;
import java.util.stream.Collectors;

public class ExcerptMapper {
    public static ExcerptDto toDto(ExcerptRequest request) {
        return ExcerptDto.builder()
                .userId(request.getUserId())
                .sourceTitle(request.getSourceTitle())
                .page(request.getPage())
                .publisher(request.getPublisher())
                .description(request.getDescription())
                .tagDtoList(request.getTagId().stream()
                        .map(tagId -> TagDto.builder().id(tagId).build())
                        .collect(Collectors.toList()))
                .content(request.getContent())
                .publishDate(request.getPublishDate())
                .optional(request.getOptional())
                .image(request.getImage())
                .userId(request.getUserId())
                .build();
    }

    public static ExcerptResponse toResponse(ExcerptDto excerpt) {
        return ExcerptResponse.builder()
                .id(excerpt.getUserId())
                .created(excerpt.getCreated())
                .modified(excerpt.getModified())
                .tagId(excerpt.getTagDtoList())
                .page(excerpt.getPage())
                .publishDate(excerpt.getPublishDate())
                .optional(excerpt.getOptional())
                .description(excerpt.getDescription())
                .content(excerpt.getContent())
                .sourceTitle(excerpt.getSourceTitle())
                .publisher(excerpt.getPublisher())
                .image(excerpt.getImage())
                .userId(excerpt.getUserId())
                .build();
    }


    public static List<ExcerptResponse> toResponses(List<ExcerptDto> excerptDtoList) {
        return excerptDtoList.stream()
                .map(ExcerptMapper::toResponse)
                .collect(Collectors.toList());
    }
}
