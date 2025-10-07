package com.example.blogsitebe.domain.platform.follow.impl;

import com.example.blogsitebe.domain.platform.follow.api.FollowDto;
import com.example.blogsitebe.domain.platform.follow.api.FollowMapper;
import com.example.blogsitebe.domain.platform.follow.api.FollowService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FollowServiceImpl extends AbstractServiceImpl<Follow, FollowDto> implements FollowService {
    private final FollowRepository followRepository;
    private final FollowMapper mapper;

    public FollowServiceImpl(FollowRepository repository, FollowMapper mapper) {
        super(repository, mapper);
        this.followRepository = repository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() { return "Follow"; }

    @Override
    protected void updateEntityFields(Follow e, FollowDto d) {
        e.setFollowerId(d.getFollowerId());
        e.setFollowingId(d.getFollowingId());
    }

    @Override
    public FollowDto create(FollowDto d) {
        if (d.getFollowerId() != null && d.getFollowerId().equals(d.getFollowingId())) {
            throw new CoreException(MessageCodes.FAIL, "User cannot follow himself/herself");
        }
        if (followRepository.existsByFollowerIdAndFollowingId(d.getFollowerId(), d.getFollowingId())) {
            throw new CoreException(
                    MessageCodes.ENTITY_ALREADY_EXISTS,
                    getEntityName(),
                    "followerId=" + d.getFollowerId() + ", followingId=" + d.getFollowingId()
            );
        }
        return mapper.entityToDto(followRepository.save(mapper.toEntity(d)));
    }
}
