package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public TagDto getById(String id) {
        return TagMapper.toDto(repository.findById(id).get());
    }

    @Override
    public Page<TagDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(TagMapper::toDto);
    }

    @Override
    public TagDto update(String id, TagDto dto) {
        var tag = findById(id).orElseThrow(IllegalArgumentException::new);
        //TODO
        return null;
    }

    public Optional<Tag> findById(String tagId) {
        return repository.findById(tagId);
    }
}
