package com.example.blogsitebe.domain.platform.tag.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class TagDto extends AbstractDto {
    private String name;
    private String description;
}
