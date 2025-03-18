package com.example.blogsitebe.domain.auth.auth.api;

import com.example.blogsitebe.domain.auth.user.api.Role;

public record LoginDto(
        String username,
        String password,
        Role role
) {
}
