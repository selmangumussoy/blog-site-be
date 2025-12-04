package com.example.blogsitebe.domain.platform.socialresponsibility.impl;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.post.api.PostType;
import com.example.blogsitebe.domain.platform.post.impl.Post;
import com.example.blogsitebe.domain.platform.post.impl.PostRepository;
import com.example.blogsitebe.domain.platform.socialresponsibility.api.*;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SocialResponsibilityServiceImpl extends AbstractServiceImpl<SocialResponsibility, SocialResponsibilityDto> implements SocialResponsibilityService {

    private final SocialResponsibilityRepository repository;
    private final PostRepository postRepository;
    private final UserService userService;

    public SocialResponsibilityServiceImpl(SocialResponsibilityRepository repository, SocialResponsibilityMapper mapper, PostRepository postRepository,UserService userService) {
        super(repository, mapper);
        this.repository = repository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    protected String getEntityName() {
        return SocialResponsibility.class.getSimpleName();
    }

    @Override
    protected void updateEntityFields(SocialResponsibility e, SocialResponsibilityDto d) {
        e.setTitle(d.getTitle());
        e.setDescription(d.getDescription());
        e.setWeekLabel(d.getWeekLabel());
        e.setStartDate(d.getStartDate());
        e.setEndDate(d.getEndDate());
        e.setActive(d.isActive());
    }

    @Override
    public SocialResponsibilityDto getDashboardData() {
        SocialResponsibility entity = repository.findFirstByIsActiveTrue()
                .orElse(new SocialResponsibility());
        SocialResponsibilityDto dto = mapper.entityToDto(entity);
        String targetTag = "sosyalsorumluluk";

        long blogCount = postRepository.countByTagNameAndType(targetTag, PostType.BLOG_POST);
        long quoteCount = postRepository.countByTagNameAndType(targetTag, PostType.QUOTE_POST);

        Pageable topFive = PageRequest.of(0, 5);
        List<Post> posts = postRepository.findLatestByTagName(targetTag, topFive);

        List<ActivityDto> activities = new ArrayList<>();
        for (Post post : posts) {
            String username = "Anonim";
            String avatar = null;

            try {
                if (post.getUserId() != null) {
                    UserDto user = userService.getById(post.getUserId());
                    username = user.getUserName();

                }
            } catch (Exception ignored) {}
            activities.add(ActivityDto.builder()
                    .id(post.getId())
                    .title(post.getTitle() != null ? post.getTitle() : "İsimsiz İçerik")
                    .type(post.getType().name()) // Enum -> String
                    .timeAgo(post.getCreated() != null ? post.getCreated().toString() : "")
                    .likeCount(post.getLikeCount() != null ? post.getLikeCount() : 0)
                    .commentCount(post.getCommentCount() != null ? post.getCommentCount() : 0)
                    .username(username)
                    .userAvatar(avatar)
                    .build());
        }
        dto.setBlogCount((int) blogCount);
        dto.setQuoteCount((int) quoteCount);
        dto.setSuggestionCount(0); // Şimdilik 0 (Öneri tablosu yapılınca eklenecek)
        dto.setLatestActivities(activities);

        return dto;
    }
    @Override
    public UserContributionDto getUserContributions() {
        String userId = com.example.blogsitebe.library.security.JwtUtil.extractUserIdAndIfAnonymousThrow();
        String targetTag = "sosyalsorumluluk";

        long blogCount = postRepository.countByUserIdAndTagNameAndType(userId, targetTag, PostType.BLOG_POST);
        long quoteCount = postRepository.countByUserIdAndTagNameAndType(userId, targetTag, PostType.QUOTE_POST);

        return UserContributionDto.builder()
                .myBlogCount((int) blogCount)
                .myQuoteCount((int) quoteCount)
                .mySuggestionCount(0)
                .build();
    }

    @Override
    public List<ActivityDto> getUserPostsByTagAndType(String typeStr) {
        String userId = com.example.blogsitebe.library.security.JwtUtil.extractUserIdAndIfAnonymousThrow();
        String targetTag = "sosyalsorumluluk";
        PostType type = PostType.valueOf(typeStr); // "BLOG_POST" -> Enum

        List<Post> posts = postRepository.findByUserIdAndTagNameAndType(userId, targetTag, type);

        // Post -> ActivityDto Dönüşümü
        return posts.stream().map(post -> ActivityDto.builder()
                .id(post.getId())
                .title(post.getTitle() != null ? post.getTitle() : "İsimsiz İçerik")
                .type(post.getType().name())
                .timeAgo(post.getCreated().toString())
                .likeCount(post.getLikeCount())
                .commentCount(post.getCommentCount())
                .username("Ben")
                .build()
        ).toList();
    }
}