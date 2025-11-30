package com.example.blogsitebe.domain.platform.like.impl;

import com.example.blogsitebe.domain.platform.like.api.LikeDto;
import com.example.blogsitebe.domain.platform.like.api.LikeMapper;
import com.example.blogsitebe.domain.platform.like.api.LikeService;
import com.example.blogsitebe.domain.platform.post.impl.PostRepository; // Post Repo'yu import et
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl extends AbstractServiceImpl<Like, LikeDto> implements LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository; // Post sayacını güncellemek için
    private final LikeMapper mapper;

    public LikeServiceImpl(LikeRepository repository,
                           PostRepository postRepository,
                           LikeMapper mapper) {
        super(repository, mapper);
        this.likeRepository = repository;
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    protected String getEntityName() {
        return "Like";
    }

    @Override
    protected void updateEntityFields(Like entity, LikeDto dto) {
        entity.setUserId(dto.getUserId());
        entity.setPostId(dto.getPostId());
    }

    @Override
    @Transactional
    public boolean toggleLike(String userId, String postId) {
        Optional<Like> existingLike = likeRepository.findByUserIdAndPostId(userId, postId);

        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            postRepository.decrementLikeCount(postId); // Post tablosundaki sayacı düşür
            return false;
        } else {
            Like newLike = new Like();
            newLike.setUserId(userId);
            newLike.setPostId(postId);
            likeRepository.save(newLike);
            postRepository.incrementLikeCount(postId); // Post tablosundaki sayacı artır
            return true;
        }
    }
}