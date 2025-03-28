package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;

public class TagMapper {
    public static Tag toEntity(Tag tag, TagDto dto) {
        tag.setDescription(dto.getDescription());
        tag.setName(dto.getName());
        return tag;
    }

    public static TagDto toDto(Tag tag) {
        return TagDto.builder()
                .id(tag.getId())
                .modified(tag.getModified())
                .created(tag.getCreated())
                .name(tag.getName())
                .description(tag.getDescription())
                .build();
    }
}
