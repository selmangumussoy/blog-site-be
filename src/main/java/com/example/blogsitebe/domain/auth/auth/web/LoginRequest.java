package com.example.blogsitebe.domain.auth.auth.web;

public record LoginRequest(
        String username,
        String password
) {
}
