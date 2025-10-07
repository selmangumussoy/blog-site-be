package com.example.blogsitebe.domain.platform.savedpost.impl;

import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostDto;
import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostMapper;
import com.example.blogsitebe.domain.platform.savedpost.api.SavedPostService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SavedPostServiceImpl extends AbstractServiceImpl<SavedPost, SavedPostDto> implements SavedPostService {
    private final SavedPostRepository savedPostRepository;
    private final SavedPostMapper mapper;

    public SavedPostServiceImpl(SavedPostRepository repository, SavedPostMapper mapper) {
        super(repository, mapper);
        this.savedPostRepository = repository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return "SavedPost";
    }

    @Override
    protected void updateEntityFields(SavedPost entity, SavedPostDto dto) {
        // saved-post için güncellenecek alan yoksa bile güvenli tarafta kalalım:
        entity.setPostId(dto.getPostId());
        entity.setUserId(dto.getUserId());
    }

    // UNIQUE: aynı user aynı post'u ikinci kez kaydetmesin
    @Override
    public SavedPostDto create(SavedPostDto dto) {
        if (savedPostRepository.existsByUserIdAndPostId(dto.getUserId(), dto.getPostId())) {
            throw new CoreException(MessageCodes.ENTITY_ALREADY_EXISTS, getEntityName(),
                    "userId=" + dto.getUserId() + ", postId=" + dto.getPostId());
        }
        SavedPost entity = mapper.toEntity(dto);
        return mapper.entityToDto(savedPostRepository.save(entity));
    }

}
