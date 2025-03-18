package com.example.blogsitebe.domain.platform.tag.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    TagDto save(TagDto dto);

    void delete(String id);

    TagDto getById(String id);

    Page<TagDto> getAll(Pageable pageable);
    List<TagDto> findAll();

    TagDto update(String id, TagDto dto);
}
