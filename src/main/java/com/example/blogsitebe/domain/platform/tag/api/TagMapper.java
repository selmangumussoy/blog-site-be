package com.example.blogsitebe.domain.platform.tag.api;

import com.example.blogsitebe.domain.platform.tag.impl.Tag;
import com.example.blogsitebe.domain.platform.tag.web.TagRequest;
import com.example.blogsitebe.domain.platform.tag.web.TagResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;

public class TagMapper implements AbstractEntityMapper<Tag,TagDto>, AbstractWebMapper<TagDto,TagRequest,TagResponse> {


    @Override
    public Tag toEntity(TagDto dto) {
        return null;
    }

    @Override
    public TagDto entityToDto(Tag entity) {
        return null;
    }

    @Override
    public TagDto requestToDto(TagRequest request) {
        return null;
    }

    @Override
    public TagResponse toResponse(TagDto dto) {
        return null;
    }
}
