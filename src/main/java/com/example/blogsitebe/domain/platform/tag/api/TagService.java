package com.example.blogsitebe.domain.platform.tag.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    TagDto save(TagDto dto);

    void delete(String id);

    TagDto getById(String id);

    Page<TagDto> getAll(Pageable pageable);

    TagDto update(String id, TagDto dto);
}
