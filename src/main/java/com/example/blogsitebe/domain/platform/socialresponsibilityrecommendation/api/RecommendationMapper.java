package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api;

import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationDto;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.impl.Recommendation;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.web.RecommendationRequest;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.web.RecommendationResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class RecommendationMapper implements
        AbstractEntityMapper<Recommendation, RecommendationDto>,
        AbstractWebMapper<RecommendationDto, RecommendationRequest, RecommendationResponse> {

    @Override
    public Recommendation toEntity(RecommendationDto dto) {
        Recommendation r = new Recommendation();
        if (dto.getId() != null) {
            r.setId(dto.getId());
        }
        r.setTitle(dto.getTitle());
        r.setDescription(dto.getDescription());
        r.setLink(dto.getLink());
        r.setUserId(dto.getUserId());
        return r;
    }

    @Override
    public RecommendationDto entityToDto(Recommendation entity) {
        return RecommendationDto.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .link(entity.getLink())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .build();
    }

    // --- AbstractWebMapper Metotları ---

    @Override // Bu Override çok önemli, Controller bunu kullanıyor
    public RecommendationDto requestToDto(RecommendationRequest req) {
        return RecommendationDto.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .link(req.getLink())
                .build();
    }

    @Override // Bu Override çok önemli
    public RecommendationResponse toResponse(RecommendationDto dto) {
        return RecommendationResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .userId(dto.getUserId()) // Frontend'de buton kontrolü için gerekli
                .title(dto.getTitle())
                .description(dto.getDescription())
                .link(dto.getLink())
                .build();
    }
}