package com.example.blogsitebe.domain.platform.profile;

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