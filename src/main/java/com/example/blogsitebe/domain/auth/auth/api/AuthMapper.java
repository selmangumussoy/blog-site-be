package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.auth.web.LoginRequest;
import com.example.blogsitebe.domain.auth.auth.web.LoginResponse;
import com.example.blogsitebe.domain.auth.auth.web.SignUpRequest;
import com.example.blogsitebe.domain.auth.auth.web.SignUpResponse;
import com.example.blogsitebe.domain.auth.user.api.Role;

public class AuthMapper {
    public static SignUpDto toDto(SignUpRequest signUpRequest, Role role) {
        return new SignUpDto(
                signUpRequest.password(),
                signUpRequest.email(),
                signUpRequest.name(),
                signUpRequest.surname(),
                signUpRequest.phoneNumber(),
                role
        );
    }

    public static LoginDto toDto(LoginRequest request, Role role) {
        return new LoginDto(
                request.username(),
                request.password(),
                role
        );
    }

    public static SignUpResponse toResponseSignUp(TokenDto tokenDto) {
        return new SignUpResponse(tokenDto.token());
    }

    public static LoginResponse toResponseLoginDto(TokenDto tokenDto) {
        return new LoginResponse(tokenDto.token());
    }
}

