package com.example.blogsitebe.domain.platform.socialresponsibility.api;

import com.example.blogsitebe.domain.platform.socialresponsibility.impl.SocialResponsibility;
import com.example.blogsitebe.domain.platform.socialresponsibility.web.SocialResponsibilityRequest;
import com.example.blogsitebe.domain.platform.socialresponsibility.web.SocialResponsibilityResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
    public class SocialResponsibilityMapper implements
        AbstractEntityMapper<SocialResponsibility, SocialResponsibilityDto>,
        AbstractWebMapper<SocialResponsibilityDto, SocialResponsibilityRequest, SocialResponsibilityResponse> {

    @Override
    public SocialResponsibility toEntity(SocialResponsibilityDto dto) {
        SocialResponsibility e = new SocialResponsibility();
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setWeekLabel(dto.getWeekLabel());
        e.setStartDate(dto.getStartDate());
        e.setEndDate(dto.getEndDate());
        e.setActive(dto.isActive());
        return e;
    }

    @Override
    public SocialResponsibilityDto entityToDto(SocialResponsibility e) {
        return SocialResponsibilityDto.builder()
                .id(e.getId())
                .created(e.getCreated())
                .modified(e.getModified())
                .title(e.getTitle())
                .description(e.getDescription())
                .weekLabel(e.getWeekLabel())
                .startDate(e.getStartDate())
                .endDate(e.getEndDate())
                .isActive(e.isActive())
                .tags(Collections.emptyList())
                .build();
    }

    @Override
    public SocialResponsibilityDto requestToDto(SocialResponsibilityRequest req) {
        return SocialResponsibilityDto.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .weekLabel(req.getWeekLabel())
                .startDate(req.getStartDate())
                .endDate(req.getEndDate())
                .isActive(req.isActive())
                .build();
    }

    @Override
    public SocialResponsibilityResponse toResponse(SocialResponsibilityDto dto) {
        return SocialResponsibilityResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .weekLabel(dto.getWeekLabel())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .isActive(dto.isActive())
                .tags(dto.getTags())
                .blogCount(dto.getBlogCount())
                .quoteCount(dto.getQuoteCount())
                .suggestionCount(dto.getSuggestionCount())
                .latestActivities(dto.getLatestActivities())
                .build();
    }
}

