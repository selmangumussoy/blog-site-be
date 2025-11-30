package com.example.blogsitebe.domain.platform.savedpost.api;

import com.example.blogsitebe.library.abstraction.AbstractService;

import java.util.List;

public interface SavedPostService extends AbstractService <SavedPostDto> {

    List<SavedPostDto> getListByUserId(String userId);
}
