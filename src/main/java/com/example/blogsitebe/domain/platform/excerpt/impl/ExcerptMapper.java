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
        excerpt.setBookLanguage(dto.getBookLanguage());
        excerpt.setContent(dto.getContent());
        excerpt.setSourceTitle(dto.getSourceTitle());
        excerpt.setBookPageNumber(dto.getBookPageNumber());
        excerpt.setPhoto(dto.getPhoto());
        return excerpt;
    }

    public static ExcerptDto toDto(Excerpt excerpt, List<Tag> tags) {
        List<TagDto> tagDtoList = tags.stream()
                .map(TagMapper::toDto)  // Her Tag entity'sini TagDto'ya dönüştür
                .collect(Collectors.toList());

        return ExcerptDto.builder()
                .id(excerpt.getId())
                .created(excerpt.getCreated())
                .modified(excerpt.getModified())
                .content(excerpt.getContent())
                .userId(excerpt.getUserId())
                .sourceTitle(excerpt.getSourceTitle())
                .bookLanguage(excerpt.getBookLanguage())
                .bookPageNumber(excerpt.getBookPageNumber())
                .tagDtoList(tagDtoList)
                .photo(excerpt.getPhoto())
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
                .bookLanguage(excerpt.getBookLanguage())
                .bookPageNumber(excerpt.getBookPageNumber())
                .photo(excerpt.getPhoto())
                .build();
    }
}