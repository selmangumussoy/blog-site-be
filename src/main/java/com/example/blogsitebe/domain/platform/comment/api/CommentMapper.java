package com.example.blogsitebe.domain.platform.comment.api;

import com.example.blogsitebe.domain.platform.comment.impl.Comment;
import com.example.blogsitebe.domain.platform.comment.web.CommentRequest;
import com.example.blogsitebe.domain.platform.comment.web.CommentResponse;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractWebMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper implements AbstractEntityMapper<Comment, CommentDto>, AbstractWebMapper<CommentDto, CommentRequest, CommentResponse> {

    @Override
    public Comment toEntity(CommentDto dto) {
        Comment comment = new Comment();
        if (dto.getId() != null) {
            comment.setId(dto.getId());
        }
        comment.setPostId(dto.getPostId());
        comment.setUserId(dto.getUserId());
        comment.setParentCommentId(dto.getParentCommentId());
        comment.setContent(dto.getContent());
        return comment;
    }

    @Override
    public CommentDto entityToDto(Comment entity) {
        return CommentDto.builder()
                .id(entity.getId())
                .postId(entity.getPostId())
                .userId(entity.getUserId())
                .parentCommentId(entity.getParentCommentId())
                .content(entity.getContent())
                .created(entity.getCreated())
                .modified(entity.getModified())
                .build();
    }

    @Override
    public CommentDto requestToDto(CommentRequest request) {
        return CommentDto.builder()
                .postId(request.getPostId())
                .parentCommentId(request.getParentCommentId())
                .content(request.getContent())
                .build();
    }

    @Override
    public CommentResponse toResponse(CommentDto dto) {
        return CommentResponse.builder()
                .id(dto.getId())
                .postId(dto.getPostId())
                .userId(dto.getUserId())
                .parentCommentId(dto.getParentCommentId())
                .content(dto.getContent())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .username(dto.getUsername())
                .userFullName(dto.getUserFullName())
                .userPicture(dto.getUserPicture())
                .build();
    }
}
