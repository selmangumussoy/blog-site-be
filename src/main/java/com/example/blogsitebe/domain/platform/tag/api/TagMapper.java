package com.example.blogsitebe.domain.platform.tag.api;

import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.web.TagRequest;
import com.example.blogsitebe.domain.platform.tag.web.TagResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class TagMapper implements AbstractEntityMapper<Tag, TagDto>, AbstractWebMapper<TagDto, TagRequest, TagResponse> {

    @Override
    public Tag toEntity(TagDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        tag.setDescription(dto.getDescription());
        return tag;
    }

    @Override
    public TagDto entityToDto(Tag entity) {
        return TagDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .build();
    }

    @Override
    public TagDto requestToDto(TagRequest request) {
        return TagDto.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    @Override
    public TagResponse toResponse(TagDto dto) {
        return TagResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }
}
