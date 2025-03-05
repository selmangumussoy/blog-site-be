package com.example.blogsitebe.domain.auth.auth.web;

public record SignUpRequest(
        String password,
        String email,
        String name,
        String surname,
        String phoneNumber
) {

}