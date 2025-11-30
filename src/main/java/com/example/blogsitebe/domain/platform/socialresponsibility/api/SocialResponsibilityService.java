package com.example.blogsitebe.domain.platform.socialresponsibility.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

public interface SocialResponsibilityService extends AbstractService<SocialResponsibilityDto> {
    SocialResponsibilityDto getDashboardData();
}