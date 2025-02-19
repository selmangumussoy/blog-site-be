package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptMapper;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("excerpts")
@RequiredArgsConstructor
public class ExcerptController extends BaseController {
    private final ExcerptService service;

    @PostMapping
    public Response<ExcerptResponse> excerpt(@RequestBody ExcerptRequest request) {
        return respond(ExcerptMapper.toResponse(service.save(ExcerptMapper.toDto(request))));
    }

}
