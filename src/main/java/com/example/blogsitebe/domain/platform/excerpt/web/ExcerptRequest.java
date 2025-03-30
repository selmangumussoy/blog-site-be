package com.example.blogsitebe.domain.platform.excerpt.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExcerptRequest {
    private String content;
    private String userId;
    private String sourceTitle;
    private String publisher;
    private String publishDate;
    private String page;
    private String description;
    private String optional;
    private List<String> tagId;
    private String image;
}
