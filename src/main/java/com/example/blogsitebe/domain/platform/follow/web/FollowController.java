package com.example.blogsitebe.domain.platform.follow.web;

import com.example.blogsitebe.domain.platform.follow.api.FollowDto;
import com.example.blogsitebe.domain.platform.follow.api.FollowMapper;
import com.example.blogsitebe.domain.platform.follow.api.FollowService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractService;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/follows")
public class FollowController  extends AbstractController<FollowDto, FollowRequest, FollowResponse> {
    public FollowController(FollowService service, FollowMapper mapper) {
        super(service, mapper);
    }
}