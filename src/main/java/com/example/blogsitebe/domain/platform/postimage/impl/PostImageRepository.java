package com.example.blogsitebe.domain.platform.postimage.impl;

import com.example.blogsitebe.library.abstraction.AbstractRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostImageRepository extends AbstractRepository<PostImage> {
    List<PostImage> findAllByPostIdOrderByOrderIndexAsc(Long postId);
}
