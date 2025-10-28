package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.user.api.Role;
import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.profile.api.ProfileDto;
import com.example.blogsitebe.domain.platform.profile.api.ProfileService;
import com.example.blogsitebe.domain.platform.profile.impl.ProfileServiceImpl;
import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import com.example.blogsitebe.library.security.JwtUtil;
import com.example.blogsitebe.library.utils.Functions;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ProfileService profileService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(User user) {
        persistUser(user);
        user.setPhoneNumber(formatPhoneNumber(user.getPhoneNumber()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public UserDto save(UserDto userDto) {
        var profile = profileService.save(userDto.getUserName(),userDto.getFullName(), userDto.getPhoneNumber());
        userDto.setProfileId(profile.getId());
        String password = StringUtils.hasLength(userDto.getPassword())
                ? userDto.getPassword()
                : Functions.generateRandomPassword();
        userDto.setPassword(passwordEncoder.encode(password));
        return UserMapper.toDto(repository.save(UserMapper.toEntity(userDto)));
    }


    private void persistUser(User user) {
        var profile = profileService.save(user.getUserName(),user.getFullName(), user.getPhoneNumber());
        user.setProfileId(profile.getId());
    }
    private String formatPhoneNumber(String phoneNumber) {
        return "90" + phoneNumber;

    }

    @Override
    public UserDto getById(String id) {
        return repository.findById(id).map(UserMapper::toDto)
                .orElseThrow();
    }

    @Override
    public UserDto getMe() {
        return getById(JwtUtil.extractUserIdAndIfAnonymousThrow());
    }

    @Override
    public ProfileDto getMeProfile() {
        UserDto userDto = getById(JwtUtil.extractUserIdAndIfAnonymousThrow());
        return profileService.getById(userDto.getProfileId());
    }

    public Optional<User> findByUserNameAndRole(String username, Role role) {
        return repository.findByUserNameAndRole(username,role);

    }
}
