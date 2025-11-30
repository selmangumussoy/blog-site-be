package com.example.blogsitebe.domain.platform.posttag.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PostTagRepository extends AbstractRepository<PostTag> {

    List<PostTag> findAllByPostId(String postId);

    boolean existsByPostIdAndTagId(String postId, String tagId);

    @Query("SELECT pt.tagId, COUNT(pt) as usageCount " +
            "FROM PostTag pt " +
            "WHERE pt.created > :createdAfter " +
            "GROUP BY pt.tagId " +
            "ORDER BY usageCount DESC")
    List<Object[]> findTrendingTags(@Param("createdAfter") Date createdAfter);
}