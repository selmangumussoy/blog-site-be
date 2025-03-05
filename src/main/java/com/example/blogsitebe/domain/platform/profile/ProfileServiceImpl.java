package com.example.blogsitebe.domain.platform.profile;

import com.example.blogsitebe.domain.platform.profile.api.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl {
    private final ProfileRepository repository;
    public Profile save() {
        return null;
    }
}