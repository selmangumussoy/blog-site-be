package com.example.blogsitebe.library.abstracts;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public abstract class AbstractResponse {
    private final String id;
    private final Date created;
    private final Date modified;
}
