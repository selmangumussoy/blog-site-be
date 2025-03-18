package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptMapper;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.domain.platform.tag.api.TagMapper;
import com.example.blogsitebe.domain.platform.tag.web.TagResponse;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.PageResponse;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("excerpts")
@RequiredArgsConstructor
public class ExcerptController extends BaseController {
    private final ExcerptService service;

    @PostMapping
    public Response<ExcerptResponse> save(@RequestBody ExcerptRequest request) {
        return respond(ExcerptMapper.toResponse(service.save(ExcerptMapper.toDto(request))));
    }

    @GetMapping
    public Response<DataResponse<ExcerptResponse>> findAll() {
        return respond(ExcerptMapper.toResponses(service.findAll()));
    }


//    @GetMapping
//    public Response<PageResponse<ExcerptResponse>> getAll(Pageable pageable) {
//        return respond(ExcerptMapper.toPageResponse(service.getAll(pageable)));
//    }
}
