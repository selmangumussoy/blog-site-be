package com.example.blogsitebe.domain.platform.tag.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, String> {
    @Query("SELECT t FROM Tag t JOIN ExcerptTag et ON t.id = et.tagId WHERE et.excerptId = :excerptId")
    List<Tag> findTagsByExcerptId(@Param("excerptId") String excerptId);
}
