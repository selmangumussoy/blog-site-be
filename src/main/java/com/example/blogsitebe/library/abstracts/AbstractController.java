package com.example.blogsitebe.library.abstracts;


import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.MetaResponse;
import com.example.blogsitebe.library.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractController<D, Req, Res> extends BaseController {

    protected final AbstractService<D> service;
    protected final AbstractWebMapper<D, Req, Res> mapper;

    @GetMapping
    public Response<DataResponse<Res>> getAll() {
        List<Res> responseList = service.getAll().stream()
                .map(mapper::toResponse)
                .toList();
        return respond(responseList);
    }

    @GetMapping("/{id}")
    public Response<Res> getById(@PathVariable String id) {
        return respond(mapper.toResponse(service.getById(id)));
    }

    @PostMapping
    public Response<Res> create(@RequestBody @Valid Req request) {
        D dto = service.create(mapper.requestToDto(request));
        return respond(mapper.toResponse(dto));
    }

    @PutMapping("/{id}")
    public Response<Res> update(@PathVariable String id, @RequestBody @Valid Req request) {
        D dto = service.update(id, mapper.requestToDto(request));
        return respond(mapper.toResponse(dto));
    }

    @DeleteMapping("/{id}")
    public Response<Void> delete(@PathVariable String id) {
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}