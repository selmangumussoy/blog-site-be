package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import lombok.*;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExcerptDto{
    private  String id;
    private Date created;
    private Date modified;
    private String content;
    private String userId;
    private List<TagDto> tagDtoList;
    private String sourceTitle;
    private String bookLanguage;
    private String bookPageNumber;
    private byte[] photo;
}
