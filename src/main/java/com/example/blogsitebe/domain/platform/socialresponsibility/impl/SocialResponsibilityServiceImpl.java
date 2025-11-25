package com.example.blogsitebe.domain.platform.socialresponsibility.impl;

import com.example.blogsitebe.domain.platform.socialresponsibility.api.SocialResponsibilityDto;
import com.example.blogsitebe.domain.platform.socialresponsibility.api.SocialResponsibilityMapper;
import com.example.blogsitebe.domain.platform.socialresponsibility.api.SocialResponsibilityService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialResponsibilityServiceImpl extends AbstractServiceImpl<SocialResponsibility, SocialResponsibilityDto> implements SocialResponsibilityService {

    private final SocialResponsibilityRepository repository;

    public SocialResponsibilityServiceImpl(SocialResponsibilityRepository repository, SocialResponsibilityMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

    @Override
    protected String getEntityName() {
        return SocialResponsibility.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(SocialResponsibility e, SocialResponsibilityDto d) {
        e.setTitle(d.getTitle());
        e.setDescription(d.getDescription());
        e.setWeekLabel(d.getWeekLabel());
        e.setStartDate(d.getStartDate());
        e.setEndDate(d.getEndDate());
        e.setActive(d.isActive());
    }

    @Override
    public SocialResponsibilityDto getDashboardData() {
        // 1. Sadece Aktif Temayı Bul ve Döndür
        return repository.findFirstByIsActiveTrue()
                .map(mapper::entityToDto)
                .orElse(SocialResponsibilityDto.builder().build());

    }
}