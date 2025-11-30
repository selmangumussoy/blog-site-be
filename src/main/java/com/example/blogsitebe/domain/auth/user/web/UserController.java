package com.example.blogsitebe.domain.auth.user.web;

import com.example.blogsitebe.domain.auth.user.api.UserMapper;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.profile.api.ProfileMapper;
import com.example.blogsitebe.domain.platform.profile.web.ProfileResponse;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.PageResponse;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService service;

    @GetMapping("/{id}")
    public Response<UserResponse> getUserById(@PathVariable String id) {
        return respond(UserMapper.toResponse(service.getById(id)));
    }

    @GetMapping("/me")
    public Response<UserResponse> getMe() {
        return respond(UserMapper.toResponse(service.getMe()));
    }

    @GetMapping("/profile-me")
    public Response<ProfileResponse> getMeProfile() {
        return respond(ProfileMapper.toResponse(service.getMeProfile()));
    }


    @GetMapping
    public Response<DataResponse<UserResponse>> getAll() {
        List<UserResponse> responseList = service.getAll().stream()
                .map(UserMapper::toResponse)
                .toList();
        return respond(responseList);
    }


    @GetMapping("/search")
    public Response<PageResponse<UserResponse>> searchUsers(
            String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        var result = service.searchByUsername(q, pageable)
                .map(UserMapper::toResponse);

        return respond(result);
    }




}
