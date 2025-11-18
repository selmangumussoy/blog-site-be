package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import java.util.List;

public interface TagRepository extends AbstractRepository<Tag> {
    List<Tag> findByNameContainingIgnoreCase(String name);

}
