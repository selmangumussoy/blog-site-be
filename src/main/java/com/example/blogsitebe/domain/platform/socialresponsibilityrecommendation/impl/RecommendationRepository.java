package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.List;

public interface RecommendationRepository extends AbstractRepository<Recommendation> {
    long countByUserId(String userId);
    List<Recommendation> findAllByUserId(String userId);
}