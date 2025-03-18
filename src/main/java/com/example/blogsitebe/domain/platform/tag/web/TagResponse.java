package com.example.blogsitebe.domain.platform.tag.web;

import lombok.Builder;

@Builder
public record TagResponse(
        String id,
        String name,
        String description
) {
}
