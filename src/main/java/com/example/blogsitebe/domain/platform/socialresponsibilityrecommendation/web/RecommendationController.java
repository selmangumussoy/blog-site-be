package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.web;

import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationDto;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationMapper;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.Response;
import com.example.blogsitebe.library.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController extends AbstractController<RecommendationDto, RecommendationRequest, RecommendationResponse> {

    public RecommendationController(RecommendationService service, RecommendationMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/my-recommendations")
    public Response<DataResponse<RecommendationResponse>> getMyRecommendations() {
        String currentUserId = JwtUtil.extractUserIdAndIfAnonymousThrow();
        RecommendationService myService = (RecommendationService) service;
        List<RecommendationDto> dtos = myService.findAllByUserId(currentUserId);
        RecommendationMapper myMapper = (RecommendationMapper) mapper;

        List<RecommendationResponse> responseList = dtos.stream()
                .map(myMapper::toResponse)
                .collect(Collectors.toList());

        return respond(responseList);
    }
}
