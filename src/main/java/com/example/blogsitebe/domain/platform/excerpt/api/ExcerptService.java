package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.excerpt.impl.Excerpt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExcerptService {
    ExcerptDto save(ExcerptDto excerptDto);

    List<ExcerptDto> findAll();

    //Page<ExcerptDto> getAll(Pageable pageable);
}
