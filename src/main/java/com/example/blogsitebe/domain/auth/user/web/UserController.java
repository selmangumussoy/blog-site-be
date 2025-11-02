package com.example.blogsitebe.domain.auth.user.web;

import com.example.blogsitebe.domain.auth.user.api.UserMapper;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.profile.api.ProfileMapper;
import com.example.blogsitebe.domain.platform.profile.web.ProfileResponse;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
