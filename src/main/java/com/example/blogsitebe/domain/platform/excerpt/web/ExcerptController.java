package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.excerpt.impl.Excerpt;
import com.example.blogsitebe.domain.platform.excerpt.impl.ExcerptServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("excerpts")
@RequiredArgsConstructor
public class ExcerptController {
    private final ExcerptServiceImpl service;

    @PostMapping
    public Excerpt excerpt(@RequestBody Excerpt excerpt) {
        return service.save(excerpt);
    }

}
