package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExcerptDto {
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
    private String image;
    private List<TagDto> tagDtoList;
}
