package com.example.blogsitebe.domain.platform.tag.api;

import com.example.blogsitebe.domain.platform.tag.web.TagRequest;
import com.example.blogsitebe.domain.platform.tag.web.TagResponse;

public class TagMapper {
    public static TagDto toDto(TagRequest request) {
        return TagDto.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    public static TagResponse toResponse(TagDto dto) {
        return TagResponse.builder()
                .description(dto.description())
                .name(dto.name())
                .build();
    }
}
