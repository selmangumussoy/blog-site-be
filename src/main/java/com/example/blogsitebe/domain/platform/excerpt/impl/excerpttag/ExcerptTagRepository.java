package com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExcerptTagRepository extends JpaRepository<ExcerptTag, String> {
    List<ExcerptTag> findByExcerptId(String excerptId);
}