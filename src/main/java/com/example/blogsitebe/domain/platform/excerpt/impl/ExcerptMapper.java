package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;
import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTag;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.impl.TagMapper;
import java.util.List;
import java.util.stream.Collectors;

public class ExcerptMapper {
    public static Excerpt toEntity(Excerpt excerpt, ExcerptDto dto) {
        excerpt.setUserId(dto.getUserId());
        excerpt.setPage(dto.getPage());
        excerpt.setContent(dto.getContent());
        excerpt.setSourceTitle(dto.getSourceTitle());
        excerpt.setOptional(dto.getOptional());
        excerpt.setPublisher(dto.getPublisher());
        excerpt.setPublishDate(dto.getPublishDate());
        excerpt.setDescription(dto.getDescription());
        excerpt.setImage(dto.getImage());
        return excerpt;
    }

    public static ExcerptDto toDto(Excerpt excerpt, List<Tag> tags) {
        List<TagDto> tagDtoList = tags.stream()
                .map(TagMapper::toDto)
                .collect(Collectors.toList());

        return ExcerptDto.builder()
                .id(excerpt.getId())
                .created(excerpt.getCreated())
                .modified(excerpt.getModified())
                .content(excerpt.getContent())
                .userId(excerpt.getUserId())
                .sourceTitle(excerpt.getSourceTitle())
                .description(excerpt.getDescription())
                .publisher(excerpt.getPublisher())
                .page(excerpt.getPage())
                .optional(excerpt.getOptional())
                .publishDate(excerpt.getPublishDate())
                .tagDtoList(tagDtoList)
                .image(excerpt.getImage())
                .build();
    }

    public static ExcerptDto toDto(Excerpt excerpt) {
        return ExcerptDto.builder()
                .id(excerpt.getId())
                .created(excerpt.getCreated())
                .modified(excerpt.getModified())
                .content(excerpt.getContent())
                .userId(excerpt.getUserId())
                .sourceTitle(excerpt.getSourceTitle())
                .page(excerpt.getPage())
                .publishDate(excerpt.getPublishDate())
                .optional(excerpt.getOptional())
                .description(excerpt.getDescription())
                .publisher(excerpt.getPublisher())
                .image(excerpt.getImage())
                .build();
    }
}