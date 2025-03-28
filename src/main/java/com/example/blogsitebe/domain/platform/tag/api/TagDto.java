package com.example.blogsitebe.domain.platform.tag.api;

import lombok.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TagDto{
    private String id;
    private Date created;
    private Date modified;
    private String name;
    private String description;
}
