package com.example.blogsitebe.domain.platform.tag.web;

import com.example.blogsitebe.domain.platform.tag.api.TagMapper;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController extends BaseController {
    private final TagService service;

    @PostMapping
    public Response<TagResponse> save(@RequestBody TagRequest request) {
        return respond(TagMapper.toResponse(service.save(TagMapper.toDto(request))));
    }
}
