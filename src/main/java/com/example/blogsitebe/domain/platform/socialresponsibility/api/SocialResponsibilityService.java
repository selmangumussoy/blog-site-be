package com.example.blogsitebe.domain.platform.socialresponsibility.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

import java.util.List;

public interface SocialResponsibilityService extends AbstractService<SocialResponsibilityDto> {
    SocialResponsibilityDto getDashboardData();
    List<ActivityDto> getUserPostsByTagAndType(String type);
    UserContributionDto getUserContributions();
}