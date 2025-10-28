package com.example.blogsitebe.domain.platform.thoughtentity.api;


import com.example.blogsitebe.domain.platform.thoughtentity.impl.Thought;
import com.example.blogsitebe.domain.platform.thoughtentity.web.ThoughtRequest;
import com.example.blogsitebe.domain.platform.thoughtentity.web.ThoughtResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class ThoughtMapper implements
        AbstractEntityMapper<Thought, ThoughtDto>,
        AbstractWebMapper<ThoughtDto, ThoughtRequest, ThoughtResponse> {

    // Entity <-> DTO
    @Override
    public Thought toEntity(ThoughtDto dto) {
        Thought e = new Thought();
        e.setPostId(dto.getPostId());
        e.setContent(dto.getContent());
        e.setFeeling(dto.getFeeling());
        return e;
    }

    @Override
    public ThoughtDto entityToDto(Thought entity) {
        return ThoughtDto.builder()
                .id(entity.getId())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .postId(entity.getPostId())
                .content(entity.getContent())
                .feeling(entity.getFeeling())
                .build();
    }

    // Web katmanı dönüşümleri
    @Override
    public ThoughtDto requestToDto(ThoughtRequest req) {
        return ThoughtDto.builder()
                .postId(req.getPostId())
                .content(req.getContent())   // NEW
                .feeling(req.getFeeling())
                .build();
    }

    @Override
    public ThoughtResponse toResponse(ThoughtDto dto) {
        return ThoughtResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .postId(dto.getPostId())
                .content(dto.getContent())   // NEW
                .feeling(dto.getFeeling())   // NEW
                .build();
    }
}