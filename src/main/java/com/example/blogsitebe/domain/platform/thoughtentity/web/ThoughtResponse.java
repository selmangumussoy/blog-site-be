package com.example.blogsitebe.domain.platform.thoughtentity.web;


import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ThoughtResponse extends AbstractResponse {
    private Long postId;
}