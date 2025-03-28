package com.example.blogsitebe.domain.platform.tag.api;

import com.example.blogsitebe.domain.platform.tag.web.TagRequest;
import com.example.blogsitebe.domain.platform.tag.web.TagResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class TagMapper {
    public static TagDto toDto(TagRequest request) {
        return TagDto.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    public static TagResponse toResponse(TagDto dto) {
        return TagResponse.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .name(dto.getName())
                .modified(dto.getModified())
                .created(dto.getCreated())
                .build();
    }

    public static Page<TagResponse> toPageResponse(Page<TagDto> dtos) {
        //TODO
        return null;
    }

    public static List<TagResponse> toResponses(List<TagDto> all) {
        return all.stream()
                .map(TagMapper::toResponse)
                .collect(Collectors.toList());
    }

}
