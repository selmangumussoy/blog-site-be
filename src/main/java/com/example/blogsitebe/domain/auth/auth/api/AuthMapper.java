package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.auth.web.SignUpRequest;
import com.example.blogsitebe.domain.auth.auth.web.SignUpResponse;
import com.example.blogsitebe.domain.auth.user.api.Role;

public class AuthMapper {
    public static SignUpDto toDto(SignUpRequest signUpRequest, Role role) {
        return new SignUpDto(
                signUpRequest.name(),
                signUpRequest.surname(),
                signUpRequest.email(),
                signUpRequest.password(),
                signUpRequest.phoneNumber(),
                role
        );
    }

    public static SignUpResponse toResponseSignUp(TokenDto tokenDto) {
        return new SignUpResponse(tokenDto.token());
    }
}