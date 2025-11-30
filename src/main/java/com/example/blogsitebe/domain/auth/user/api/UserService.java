package com.example.blogsitebe.domain.auth.user.api;

import com.example.blogsitebe.domain.auth.user.impl.User;
import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    UserDto getById(String id);
    UserDto getMe();

    ProfileDto getMeProfile();

    List<UserDto> getAll();
    Page<UserDto> searchByUsername(String query, Pageable pageable);
    Optional<User> findByUserNameAndRole(String username, Role role);
}
