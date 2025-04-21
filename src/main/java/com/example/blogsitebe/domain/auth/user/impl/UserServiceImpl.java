package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.user.api.Role;
import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.platform.profile.impl.ProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository repository;
    private final ProfileServiceImpl profileService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(User user) {
        persistUser(user);
        user.setPhoneNumber(formatPhoneNumber(user.getPhoneNumber()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserDto save(UserDto userDto) {
        return UserMapper.toDto(repository.save(UserMapper.toEntity(userDto)));
    }

    private void persistUser(User user) {
        var profile = profileService.save(user.getName(),user.getSurname(),user.getEmail());
        user.setProfileId(profile.getId());
    }
    private String formatPhoneNumber(String phoneNumber) {
        return "90" + phoneNumber;

    }

    public Optional<User> findByEmailAndRole(String email, Role role) {
        return repository.findByEmailAndRole(email,role);
    }
}
