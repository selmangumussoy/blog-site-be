package com.example.blogsitebe.domain.platform.tag.web;

import lombok.Builder;

@Builder
public record TagRequest(
        String name,
        String description
) {
}
