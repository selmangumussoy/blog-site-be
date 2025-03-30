package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptMapper;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/excerpts")
@RequiredArgsConstructor
public class ExcerptController extends BaseController {
    private final ExcerptService service;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public Response<ExcerptResponse> save(@RequestBody ExcerptRequest request) {
        return respond(ExcerptMapper.toResponse(service.save(ExcerptMapper.toDto(request))));
    }

    @GetMapping
    public List<ExcerptResponse> getAll() {
        return ExcerptMapper.toResponses(service.getAll());
    }
}
