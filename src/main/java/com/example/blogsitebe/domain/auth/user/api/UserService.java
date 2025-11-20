package com.example.blogsitebe.domain.auth.user.api;

import com.example.blogsitebe.domain.auth.user.impl.User;
import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;

import java.util.List;

public interface UserService {
    User save(User user);
    UserDto getById(String id);
    UserDto getMe();

    ProfileDto getMeProfile();

    List<UserDto> getAll();
}
