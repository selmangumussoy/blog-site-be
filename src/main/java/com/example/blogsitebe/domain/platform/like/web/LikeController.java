package com.example.blogsitebe.domain.platform.like.web;

import com.example.blogsitebe.domain.platform.like.api.LikeDto;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractService;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;

public class LikeController  extends AbstractController<LikeDto, LikeRequest, LikeResponse> {
    public LikeController(AbstractService<LikeDto> service, AbstractWebMapper<LikeDto, LikeRequest, LikeResponse> mapper) {
        super(service, mapper);
    }
}
