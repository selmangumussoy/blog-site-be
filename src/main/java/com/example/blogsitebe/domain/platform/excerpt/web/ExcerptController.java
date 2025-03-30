package com.example.blogsitebe.domain.platform.excerpt.web;

import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptMapper;
import com.example.blogsitebe.domain.platform.excerpt.api.ExcerptService;
import com.example.blogsitebe.library.rest.BaseController;
import com.example.blogsitebe.library.rest.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/excerpts")
@RequiredArgsConstructor
public class ExcerptController extends BaseController {
    private final ExcerptService service;

    @PostMapping
    public Response<ExcerptResponse> save(@RequestParam("file") MultipartFile file,
                                          @RequestParam("data") String dataJson) throws IOException {
        ExcerptRequest request = new ObjectMapper().readValue(dataJson, ExcerptRequest.class);

        return respond(ExcerptMapper.toResponse(service.save(ExcerptMapper.toDto(request, file))));
    }

    @GetMapping
    public List<ExcerptResponse> getAll() {
        return ExcerptMapper.toResponses(service.getAll());
    }
}
