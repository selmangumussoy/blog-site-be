package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository repository;

    @Override
    public TagDto save(TagDto dto) {
        return TagMapper.toDto(repository.save(TagMapper.toEntity(new Tag(), dto)));
    }

    public Optional<Tag> findById(String tagId) {
        return repository.findById(tagId);
    }
}
