package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag.ExcerptTagRepository;
import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.utils.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        return PageUtil.pageToDto(repository.findAll(pageable),TagMapper::toDto);
    }

    public List<TagDto> findAll() {
        List<TagDto> tagDtos = new ArrayList<>();

        for(Tag basket: repository.findAll()){
            tagDtos.add(TagMapper.toDto(basket));
        }
        return tagDtos;
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

    public List<Tag> findTagsByExcerptId(String id) {
        return repository.findTagsByExcerptId(id);
    }
}
