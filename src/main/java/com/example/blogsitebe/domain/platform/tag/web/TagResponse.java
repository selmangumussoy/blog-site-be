package com.example.blogsitebe.domain.platform.tag.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Data
public class TagResponse extends AbstractResponse {

    private String name;
    private String description;

}
