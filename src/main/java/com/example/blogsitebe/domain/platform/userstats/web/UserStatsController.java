package com.example.blogsitebe.domain.platform.userstats.web;

import com.example.blogsitebe.domain.platform.userstats.api.UserStatsDto;
import com.example.blogsitebe.domain.platform.userstats.api.UserStatsMapper;
import com.example.blogsitebe.domain.platform.userstats.api.UserStatsService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractService;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-stats")
public class UserStatsController
        extends AbstractController<UserStatsDto, UserStatsRequest, UserStatsResponse> {

    private final UserStatsService userStatsService;
    private final UserStatsMapper mapper;


    public UserStatsController(AbstractService<UserStatsDto> service, AbstractWebMapper<UserStatsDto,
            UserStatsRequest, UserStatsResponse> mapper, UserStatsService userStatsService) {
        super(service, mapper);
        this.userStatsService = userStatsService;
        this.mapper = (UserStatsMapper) mapper;
    }

    @GetMapping("/user/{userId}")
    public Response<UserStatsResponse> getStatsByUserId(@PathVariable String userId) {

        // 1) Servisten istatistikleri al
        UserStatsDto statsDto = userStatsService.getByUserId(userId);

        UserStatsResponse response = mapper.toResponse(statsDto);

        return respond(response);
    }

}
