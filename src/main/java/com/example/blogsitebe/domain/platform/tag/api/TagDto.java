package com.example.blogsitebe.domain.platform.tag.api;

import lombok.Builder;

@Builder
public record TagDto(
        String id,
        String created,
        String modified,
        String name,
        String description
) {
}
