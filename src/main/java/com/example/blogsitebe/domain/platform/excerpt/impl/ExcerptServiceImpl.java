package com.example.blogsitebe.domain.platform.excerpt.impl;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptDto;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExcerptServiceImpl implements ExcerptService {
    private final ExcerptRepository repository;

    @Override
    public ExcerptDto save(ExcerptDto dto) {
        return ExcerptMapper.toDto(repository.save(ExcerptMapper.toEntity(new Excerpt(),  dto)));
    }
}
