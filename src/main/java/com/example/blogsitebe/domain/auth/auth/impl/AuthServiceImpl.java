package com.example.blogsitebe.domain.auth.auth.impl;

import com.example.blogsitebe.domain.auth.auth.api.AuthService;
import com.example.blogsitebe.domain.auth.auth.api.LoginDto;
import com.example.blogsitebe.domain.auth.auth.api.SignUpDto;
import com.example.blogsitebe.domain.auth.auth.api.TokenDto;
import com.example.blogsitebe.domain.auth.user.impl.User;
import com.example.blogsitebe.domain.auth.user.impl.UserMapper;
import com.example.blogsitebe.domain.auth.user.impl.UserServiceImpl;
import com.example.blogsitebe.library.security.CustomUserDetails;
import com.example.blogsitebe.library.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserServiceImpl userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public TokenDto signUp(SignUpDto dto) {
        User savedUser = userService.save(UserMapper.toEntity(dto));
        UserDetails userDetails = new CustomUserDetails(savedUser);
        String token = jwtUtil.generateToken(userDetails);

        return new TokenDto(token, null, null);
    }

    @Override
    public TokenDto login(LoginDto dto) {
        Optional<User> user = userService.findByEmailAndRole(dto.username(), dto.role());

        if (user.isPresent() && passwordEncoder.matches(dto.password(), user.get().getPassword())) {
            return generateToken(user.get());
        }
        return null;
    }

    private TokenDto generateToken(User user) {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().toString()));

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();

        String token = jwtUtil.generateToken(userDetails);
        return new TokenDto(token, null, null);
    }
}