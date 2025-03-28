package com.example.blogsitebe.domain.platform.excerpt.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ExcerptRepository extends JpaRepository<Excerpt, String> {
    @Query("SELECT e FROM Excerpt e")
    List<Excerpt> findAllCustom();
}
