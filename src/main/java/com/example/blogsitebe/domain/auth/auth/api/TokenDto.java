package com.example.blogsitebe.domain.auth.auth.api;

public record TokenDto(
        String token,
        String hash,
        String otpCode
) {
}