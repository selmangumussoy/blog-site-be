package com.example.blogsitebe.domain.platform.tag.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TagRepository extends AbstractRepository<Tag> {


}
