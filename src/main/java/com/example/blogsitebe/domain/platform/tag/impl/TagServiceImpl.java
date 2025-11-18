package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TagServiceImpl extends AbstractServiceImpl<Tag, TagDto> implements TagService {
    private final  TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository, AbstractEntityMapper<Tag, TagDto> mapper) {
        super(tagRepository, mapper);
        this.tagRepository = tagRepository;
    }

    @Override
    protected String getEntityName() {
        return Tag.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(Tag tag, TagDto tagDto) {
        tag.setName(tagDto.getName());
        tag.setDescription(tagDto.getDescription());
    }

    @Override
    public List<TagDto> search(String query) {
        return tagRepository.findByNameContainingIgnoreCase(query)
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }
}
