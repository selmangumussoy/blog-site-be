package com.example.blogsitebe.domain.platform.savedpost.api;

import com.example.blogsitebe.domain.platform.savedpost.impl.SavedPost;
import com.example.blogsitebe.domain.platform.savedpost.web.SavedPostRequest;
import com.example.blogsitebe.domain.platform.savedpost.web.SavedPostResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class SavedPostMapper implements AbstractEntityMapper<SavedPost, SavedPostDto>, AbstractWebMapper<SavedPostDto, SavedPostRequest, SavedPostResponse> {
    @Override
    public SavedPost toEntity(SavedPostDto dto) {
        SavedPost e = new SavedPost();
        e.setPostId(dto.getPostId());
        e.setUserId(dto.getUserId());
        return e;
    }

    @Override
    public SavedPostDto entityToDto(SavedPost e) {
        return SavedPostDto.builder()
                .id(e.getId())
                .created(e.getCreated())
                .modified(e.getModified())
                .postId(e.getPostId())
                .userId(e.getUserId())
                .build();
    }

    // Web katmanı
    @Override
    public SavedPostDto requestToDto(SavedPostRequest request) {
        return SavedPostDto.builder()
                .postId(request.getPostId())
                .userId(request.getUserId())
                .build();
    }

    @Override
    public SavedPostResponse toResponse(SavedPostDto dto) {
        return SavedPostResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .postId(dto.getPostId())
                .userId(dto.getUserId())
                .build();
    }
}
