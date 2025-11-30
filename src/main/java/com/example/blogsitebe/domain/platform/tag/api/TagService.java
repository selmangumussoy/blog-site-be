package com.example.blogsitebe.domain.platform.tag.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

import java.util.List;

public interface TagService extends AbstractService<TagDto> {

    List<TagDto> search(String query);

    List<TagDto> getTrendingDaily();

    List<TagDto> getTrendingWeekly();
}
