package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExcerptResponse {
    private String id;
    private Date created;
    private Date modified;
    private String content;
    private String userId;
    private String sourceTitle;
    private String publisher;
    private String publishDate;
    private String page;
    private String description;
    private String optional;
    private List<TagDto> tagId;
    private String image;
}
