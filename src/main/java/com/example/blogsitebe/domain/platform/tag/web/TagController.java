package com.example.blogsitebe.domain.platform.tag.web;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagMapper;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.MetaResponse;
import com.example.blogsitebe.library.rest.PageResponse;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

//    @GetMapping
//    public Response<PageResponse<TagResponse>> filter(Pageable pageable) {
//        //TODO
//        return null;
//    }

    @GetMapping
    public Response<PageResponse<TagResponse>> getAll(Pageable pageable) {
        return respond(TagMapper.toPageResponse(service.getAll(pageable)));
    }

    @GetMapping("/{id}")
    public Response<TagResponse> getById(@PathVariable String id) {
        return respond(TagMapper.toResponse(service.getById(id)));
    }

    @PutMapping("/{id}")
    public Response<TagResponse> update(@PathVariable String id, @RequestBody TagDto dto) {
        return respond(TagMapper.toResponse(service.update(id,dto)));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}