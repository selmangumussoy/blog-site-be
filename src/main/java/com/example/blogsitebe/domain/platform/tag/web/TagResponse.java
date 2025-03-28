package com.example.blogsitebe.domain.platform.tag.web;

import lombok.Builder;
import java.util.Date;

@Builder
public record TagResponse(
        String id,
        String name,
        String description,
        Date modified,
        Date created
) {
}
