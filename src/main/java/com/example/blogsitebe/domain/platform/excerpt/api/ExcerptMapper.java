package com.example.blogsitebe.domain.platform.excerpt.api;

import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptRequest;
import com.example.blogsitebe.domain.platform.excerpt.web.ExcerptResponse;
import com.example.blogsitebe.library.utils.PageUtil;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ExcerptMapper {
    public static ExcerptDto toDto(ExcerptRequest request) {
        return ExcerptDto.builder()
                .userId(request.userId())
                .sourceTitle(request.sourceTitle())
                .bookPageNumber(request.bookPageNumber())
                .bookLanguage(request.bookLanguage())
                .tagId(request.tagId())
                .content(request.content())
                .photo(request.photo())
                .build();
    }

    public static ExcerptResponse toResponse(ExcerptDto excerpt) {
        return ExcerptResponse.builder()
                .tagId(excerpt.tagId())
                .bookLanguage(excerpt.bookLanguage())
                .bookPageNumber(excerpt.bookPageNumber())
                .content(excerpt.content())
                .sourceTitle(excerpt.sourceTitle())
                .photo(excerpt.photo())
                .build();
    }

//    public static List<ExcerptResponse> toResponses(List<ExcerptDto> all) {
//        return all.stream()
//                .map(ExcerptMapper::toResponse)
//                .collect(Collectors.toList());
//    }


    public static Page<ExcerptResponse> toPageResponse(Page<ExcerptDto> excerptDtos) {
        return PageUtil.pageToDto(excerptDtos, ExcerptMapper::toResponse);
    }

    public static List<ExcerptResponse> toResponse(List<ExcerptDto> excerptDtos) {
        return excerptDtos.stream().map(ExcerptMapper::toResponse).toList();
    }
}
