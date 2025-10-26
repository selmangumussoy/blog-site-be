package com.example.blogsitebe.domain.platform.thoughtentity.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ThoughtDto extends AbstractDto {
    private String postId;
}