package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.user.api.Role;
import com.example.blogsitebe.domain.auth.user.api.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
@Slf4j
@RequiredArgsConstructor
public class DefaultUserCreator {
    private final UserServiceImpl userService;

    @Value("${management.admin.email}")
    private String adminEmail;

    @Value("${management.admin.password}")
    private String adminPassword;

    private final String ADMIN_NAME = "Admin Asım";




    @EventListener(value = ApplicationReadyEvent.class)
    @Order(0)
    public void createDefaultUser() {
        AtomicReference<UserDto> userDto = new AtomicReference<>();
        userService.findByEmailAndRole(adminEmail, Role.ROLE_ADMIN).ifPresentOrElse(user ->
                            userDto.set(UserMapper.toDto(user))
                ,
                ()->
                        userDto.set(userService.save(UserDto.builder()
                                .name(ADMIN_NAME)
                                .email(adminEmail)
                                .password(adminPassword)
                                .role(Role.ROLE_ADMIN)
                                .phoneNumber("null")
                                .build()))
        );
        log.info("Created default user: {}", userDto.get());
    }

}