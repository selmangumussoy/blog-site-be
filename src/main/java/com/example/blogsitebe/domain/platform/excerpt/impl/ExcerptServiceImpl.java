package com.example.blogsitebe.domain.platform.excerpt.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcerptServiceImpl {
    private final ExcerptRepository repository;

    public Excerpt save(Excerpt excerpt) {
        return repository.save(excerpt);
    }
}
