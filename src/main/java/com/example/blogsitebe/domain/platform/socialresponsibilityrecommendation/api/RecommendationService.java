package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

import java.util.List;

public interface RecommendationService extends AbstractService<RecommendationDto> {
    List<RecommendationDto> findAllByUserId(String userId);
}
