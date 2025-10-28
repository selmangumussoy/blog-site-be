package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.auth.web.LoginRequest;
import com.example.blogsitebe.domain.auth.auth.web.LoginResponse;
import com.example.blogsitebe.domain.auth.auth.web.SignUpRequest;
import com.example.blogsitebe.domain.auth.auth.web.SignUpResponse;
import com.example.blogsitebe.domain.auth.user.api.Role;

public class AuthMapper {
    public static SignUpDto toDto(SignUpRequest signUpRequest, Role role) {
        return SignUpDto.builder()
                .username(signUpRequest.getUsername())
                .password(signUpRequest.getPassword())
                .fullName(signUpRequest.getFullName())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .rol(role)
                .build();
    }

    public static LoginDto toDto(LoginRequest request, Role role) {
        return  LoginDto.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(role)
                .build(
        );
    }

    public static SignUpResponse toResponseSignUp(TokenDto tokenDto) {
        return SignUpResponse.builder().token(tokenDto.getToken()).build();
    }

    public static LoginResponse toResponseLoginDto(TokenDto tokenDto) {
        return LoginResponse.builder().token(tokenDto.getToken()).build();
    }
}

