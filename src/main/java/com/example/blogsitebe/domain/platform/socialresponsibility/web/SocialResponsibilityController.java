package com.example.blogsitebe.domain.platform.socialresponsibility.web;

import com.example.blogsitebe.domain.platform.socialresponsibility.api.SocialResponsibilityDto;
import com.example.blogsitebe.domain.platform.socialresponsibility.api.SocialResponsibilityMapper;
import com.example.blogsitebe.domain.platform.socialresponsibility.api.SocialResponsibilityService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/social-responsibility")
public class SocialResponsibilityController extends AbstractController<SocialResponsibilityDto, SocialResponsibilityRequest, SocialResponsibilityResponse> {

    private final SocialResponsibilityService service;

    public SocialResponsibilityController(SocialResponsibilityService service, SocialResponsibilityMapper mapper) {
        super(service, mapper);
        this.service = service;
    }

    @GetMapping("/dashboard")
    public Response<SocialResponsibilityResponse> getDashboard() {
        SocialResponsibilityDto dto = service.getDashboardData();
        return respond(mapper.toResponse(dto));
    }
}