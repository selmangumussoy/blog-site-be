package com.example.blogsitebe.domain.platform.excerpt.api;

import java.util.List;

public interface ExcerptService {
    ExcerptDto save(ExcerptDto excerptDto);

    List<ExcerptDto> getAll();

    List<ExcerptDto> getExcerptsByUserId(String id);
}
