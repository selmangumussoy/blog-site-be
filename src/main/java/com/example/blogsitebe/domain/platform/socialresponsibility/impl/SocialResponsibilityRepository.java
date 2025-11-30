package com.example.blogsitebe.domain.platform.socialresponsibility.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;

import java.util.Optional;

public interface SocialResponsibilityRepository extends AbstractRepository<SocialResponsibility> {
    Optional<SocialResponsibility> findFirstByIsActiveTrue();
}