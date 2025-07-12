package com.example.blogsitebe.domain.auth.user.api;

import com.example.blogsitebe.domain.auth.user.impl.User;

public interface UserService {
    User save(User user);
    UserDto getById(String id);
    UserDto getMe();
}
