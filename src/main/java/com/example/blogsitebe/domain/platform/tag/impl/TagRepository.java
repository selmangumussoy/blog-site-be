package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import java.util.List;
import java.util.Optional;

public interface TagRepository extends AbstractRepository<Tag> {
    List<Tag> findByNameContainingIgnoreCase(String name);

    Optional<Tag> findByNameIgnoreCase(String name);
}
