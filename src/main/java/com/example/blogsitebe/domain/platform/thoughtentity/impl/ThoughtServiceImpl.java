package com.example.blogsitebe.domain.platform.thoughtentity.impl;


import com.example.blogsitebe.domain.platform.thoughtentity.api.ThoughtDto;
import com.example.blogsitebe.domain.platform.thoughtentity.api.ThoughtMapper;
import com.example.blogsitebe.domain.platform.thoughtentity.api.ThoughtService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ThoughtServiceImpl extends AbstractServiceImpl<Thought, ThoughtDto> implements ThoughtService {

    public ThoughtServiceImpl(ThoughtRepository repository, ThoughtMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected String getEntityName() {
        return "Thought";
    }

    @Override
    protected void updateEntityFields(Thought entity, ThoughtDto dto) {

        entity.setPostId(dto.getPostId());
        entity.setContent(dto.getContent());
        entity.setFeeling(dto.getFeeling());
    }
}