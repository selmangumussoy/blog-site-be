package com.example.blogsitebe.domain.platform.tag.web;

import com.example.blogsitebe.domain.platform.tag.api.TagDto;
import com.example.blogsitebe.domain.platform.tag.api.TagService;
import com.example.blogsitebe.library.abstraction.AbstractController;
import com.example.blogsitebe.library.abstraction.AbstractService;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import com.example.blogsitebe.library.rest.DataResponse;
import com.example.blogsitebe.library.rest.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController extends AbstractController<TagDto, TagRequest, TagResponse> {

    private final TagService tagService;

    public TagController(AbstractService<TagDto> service,
                         AbstractWebMapper<TagDto, TagRequest, TagResponse> mapper,
                         TagService tagService) {
        super(service, mapper);
        this.tagService = tagService;
    }

    @GetMapping("/search")
    public Response<DataResponse<TagResponse>> search(@RequestParam String query) {
        List<TagDto> results = tagService.search(query);
        return respond(results.stream().map(mapper::toResponse).toList());
    }

    @GetMapping("/trending/daily")
    public Response<DataResponse<TagResponse>> trendingDaily() {
        List<TagDto> dtos = tagService.getTrendingDaily();
        return respond(dtos.stream().map(mapper::toResponse).toList());
    }

    @GetMapping("/trending/weekly")
    public Response<DataResponse<TagResponse>> trendingWeekly() {
        List<TagDto> dtos = tagService.getTrendingWeekly();
        return respond(dtos.stream().map(mapper::toResponse).toList());
    }
}