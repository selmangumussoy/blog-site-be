package com.example.blogsitebe.domain.platform.postimage.api;

import com.example.blogsitebe.library.abstraction.AbstractService;
import java.util.List;

public interface PostImageService extends AbstractService<PostImageDto> {
    List<PostImageDto> findByPostId(Long postId);
}
