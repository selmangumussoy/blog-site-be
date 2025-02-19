package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;

public class TagMapper {
    public static Tag toEntity(Tag tag, TagDto dto) {
        tag.setDescription(dto.description());
        tag.setName(dto.name());
        return tag;
    }

    public static TagDto toDto(Tag tag) {
        return TagDto.builder()
                .name(tag.getName())
                .description(tag.getDescription())
                .build();
    }
}
