package com.example.blogsitebe.domain.platform.comment.impl;

import com.example.blogsitebe.domain.platform.comment.api.CommentDto;
import com.example.blogsitebe.domain.platform.comment.api.CommentService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractRepository;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends AbstractServiceImpl<Comment, CommentDto> implements CommentService {

    public CommentServiceImpl(AbstractRepository<Comment> repository, AbstractEntityMapper<Comment, CommentDto> mapper) {
        super(repository, mapper);
    }

    @Override
    protected String getEntityName() {
        return Comment.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(Comment entity, CommentDto dto) {
        entity.setPostId(dto.getPostId());
        entity.setUserId(dto.getUserId());
        entity.setParentCommentId(dto.getParentCommentId());
        entity.setContent(dto.getContent());
    }
}
