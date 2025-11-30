package com.example.blogsitebe.domain.platform.userstats.web;

import com.example.blogsitebe.domain.platform.userstats.api.UserStatsDto;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractService;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-stats")
public class UserStatsController
        extends AbstractController<UserStatsDto, UserStatsRequest, UserStatsResponse> {

    public UserStatsController(AbstractService<UserStatsDto> service, AbstractWebMapper<UserStatsDto,
            UserStatsRequest, UserStatsResponse> mapper) {
        super(service, mapper);
    }
}
