package com.example.blogsitebe.domain.auth.auth.impl;

import com.example.blogsitebe.domain.auth.auth.api.AuthService;
import com.example.blogsitebe.domain.auth.auth.api.SignUpDto;
import com.example.blogsitebe.domain.auth.auth.api.TokenDto;
import com.example.blogsitebe.domain.auth.user.impl.User;
import com.example.blogsitebe.domain.auth.user.impl.UserMapper;
import com.example.blogsitebe.domain.auth.user.impl.UserServiceImpl;
import com.example.blogsitebe.library.security.CustomUserDetails;
import com.example.blogsitebe.library.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;

    @Override
    public TokenDto signUp(SignUpDto dto) {

        User savedUser = userService.save(UserMapper.toEntity(dto));
        UserDetails userDetails = new CustomUserDetails(savedUser);
        String token = jwtUtil.generateToken(userDetails);

        return new TokenDto(token, null, null);
    }
}