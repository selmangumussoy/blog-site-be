package com.example.blogsitebe.library.abstraction;


import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public abstract class AbstractDto {
    private final String id;
    private final Date created;
    private final Date modified;
}
