package com.example.blogsitebe.domain.platform.userstats.impl;

import com.example.blogsitebe.domain.platform.userstats.api.UserStatsDto;
import com.example.blogsitebe.domain.platform.userstats.api.UserStatsService;
import com.example.blogsitebe.library.abstraction.AbstractEntityMapper;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserStatsServiceImpl extends AbstractServiceImpl<UserStats, UserStatsDto> implements UserStatsService {
    private final UserStatsRepository repository;
    private final UserStatsRepository userStatsRepository;

    public UserStatsServiceImpl(UserStatsRepository repository, AbstractEntityMapper<UserStats, UserStatsDto> mapper, UserStatsRepository userStatsRepository) {
        super(repository, mapper);
        this.repository= repository;
        this.userStatsRepository = userStatsRepository;
    }

    @Override
    protected String getEntityName() {
        return UserStats.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(UserStats entity, UserStatsDto dto) {
        entity.setFollowerCount(dto.getFollowerCount());
        entity.setFollowedCount(dto.getFollowedCount());
        entity.setPostCount(dto.getPostCount());
        entity.setUserId(dto.getUserId());
    }



    public void createInitialStats(String userId) {
        UserStats stats = new UserStats();
        stats.setUserId(userId);
        stats.setFollowerCount(0);
        stats.setFollowedCount(0);
        stats.setPostCount(0);

        repository.save(stats);
    }

    @Override
    public UserStatsDto getByUserId(String userId) {
        return mapper.entityToDto(userStatsRepository.findByUserId(userId).orElseThrow());
    }

    @Transactional
    public void increaseFollow(String followedId, String followerId) {

        if (followedId == null || followerId == null)
            throw new IllegalArgumentException("User IDs cannot be null.");

        if (followedId.equals(followerId))
            throw new IllegalArgumentException("A user cannot follow himself.");

        UserStats followed = repository.findByUserId(followedId)
                .orElseThrow(() -> new RuntimeException("Followed user stats not found"));

        UserStats follower = repository.findByUserId(followerId)
                .orElseThrow(() -> new RuntimeException("Follower user stats not found"));

        followed.setFollowerCount(
                (followed.getFollowerCount() == null ? 0 : followed.getFollowerCount()) + 1
        );

        follower.setFollowedCount(
                (follower.getFollowedCount() == null ? 0 : follower.getFollowedCount()) + 1
        );

        repository.save(followed);
        repository.save(follower);
    }

    @Transactional
    public void decreaseFollow(String followedId, String followerId) {

        if (followedId == null || followerId == null)
            throw new IllegalArgumentException("User IDs cannot be null.");

        if (followedId.equals(followerId))
            throw new IllegalArgumentException("A user cannot unfollow himself.");

        UserStats followed = repository.findByUserId(followedId)
                .orElseThrow(() -> new RuntimeException("Followed user stats not found"));

        UserStats follower = repository.findByUserId(followerId)
                .orElseThrow(() -> new RuntimeException("Follower user stats not found"));

        // Takip edilen kişinin takipçi sayısı 1 azalır
        followed.setFollowerCount(
                Math.max(0, (followed.getFollowerCount() == null ? 0 : followed.getFollowerCount()) - 1)
        );

        // Takip eden kişinin takip ettiği kişi sayısı 1 azalır
        follower.setFollowedCount(
                Math.max(0, (follower.getFollowedCount() == null ? 0 : follower.getFollowedCount()) - 1)
        );

        repository.save(followed);
        repository.save(follower);
    }


}
