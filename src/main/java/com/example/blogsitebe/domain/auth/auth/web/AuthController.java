package com.example.blogsitebe.domain.auth.auth.web;

import com.example.blogsitebe.domain.auth.auth.api.AuthMapper;
import com.example.blogsitebe.domain.auth.auth.api.AuthService;
import com.example.blogsitebe.domain.auth.auth.api.LoginDto;
import com.example.blogsitebe.domain.auth.user.api.Role;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public Response<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return respond(AuthMapper.toResponseSignUp(authService.signUp(AuthMapper.toDto(signUpRequest, Role.ROLE_USER))));
    }

    @PostMapping("/login")
    public Response<LoginResponse> login (@RequestBody LoginRequest request){
        return respond(AuthMapper.toResponseLoginDto(authService.login(AuthMapper.toDto(request, Role.ROLE_USER))));
    }

}