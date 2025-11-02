package com.example.blogsitebe.domain.platform.profile.web;

import com.example.blogsitebe.domain.platform.profile.api.ProfileMapper;
import com.example.blogsitebe.domain.platform.profile.api.ProfileService;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController extends BaseController {
    private final ProfileService service;


    @PutMapping("/{id}")
    public Response<ProfileResponse> update(@PathVariable(name = "id") String id, @RequestBody ProfileUpdateRequest updateRequest) {
        return respond(ProfileMapper.toResponse(service.update(ProfileMapper.toDto(updateRequest),id)));
    }

    @GetMapping
    public Response<DataResponse<ProfileResponse>> getAll() {
        return respond(ProfileMapper.toResponses(service.getAll()));
    }

    @GetMapping("/{id}")
    public Response<ProfileResponse> getById(@PathVariable(name = "id") String id) {
        return respond(ProfileMapper.toResponse(service.getById(id)));
    }
}
