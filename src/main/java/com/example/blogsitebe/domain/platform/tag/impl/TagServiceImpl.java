package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractRepository;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends AbstractServiceImpl <Tag,TagDto> implements TagService {


    public TagServiceImpl(AbstractRepository<Tag> repository, AbstractEntityMapper<Tag, TagDto> mapper) {
        super(repository, mapper);
    }

    @Override
    protected String getEntityName() {
        return  Tag.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(Tag tag, TagDto tagDto) {
        tag.setName(tagDto.getName());
        tag.setDescription(tagDto.getDescription());
        tag.setCreated(tag.getCreated());
        tag.setModified(tagDto.getModified());
    }
}
