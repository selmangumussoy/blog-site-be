package com.example.blogsitebe.domain.platform.tag.web;

import lombok.Builder;

@Builder
public record TagResponse(
        String name,
        String description
) {
}
