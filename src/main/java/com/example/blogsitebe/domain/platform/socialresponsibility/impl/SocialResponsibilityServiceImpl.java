package com.example.blogsitebe.domain.platform.socialresponsibility.impl;

import com.example.blogsitebe.domain.auth.user.api.UserDto;
import com.example.blogsitebe.domain.auth.user.api.UserService;
import com.example.blogsitebe.domain.platform.post.api.PostType;
import com.example.blogsitebe.domain.platform.post.impl.Post;
import com.example.blogsitebe.domain.platform.post.impl.PostRepository;
import com.example.blogsitebe.domain.platform.socialresponsibility.api.*;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.impl.Recommendation;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.impl.RecommendationRepository;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import com.example.blogsitebe.library.security.JwtUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialResponsibilityServiceImpl extends AbstractServiceImpl<SocialResponsibility, SocialResponsibilityDto> implements SocialResponsibilityService {

    private final SocialResponsibilityRepository repository;
    private final PostRepository postRepository;
    private final UserService userService;
    private final RecommendationRepository recommendationRepository;

    public SocialResponsibilityServiceImpl(
            SocialResponsibilityRepository repository,
            SocialResponsibilityMapper mapper,
            PostRepository postRepository,
            UserService userService,
            RecommendationRepository recommendationRepository) {
        super(repository, mapper);
        this.repository = repository;
        this.postRepository = postRepository;
        this.userService = userService;
        this.recommendationRepository = recommendationRepository;
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
        // 1. Aktif Temayı Bul
        SocialResponsibility entity = repository.findFirstByIsActiveTrue()
                .orElse(new SocialResponsibility());
        SocialResponsibilityDto dto = mapper.entityToDto(entity);
        String targetTag = "sosyalsorumluluk";

        // 2. İstatistikleri Hesapla
        long blogCount = postRepository.countByTagNameAndType(targetTag, PostType.BLOG_POST);
        long quoteCount = postRepository.countByTagNameAndType(targetTag, PostType.QUOTE_POST);

        // GÜNCELLEME: Gerçek öneri sayısını veritabanından çekiyoruz
        long suggestionCount = recommendationRepository.count();

        // 3. Aktivite Akışını Oluştur (Postlar + Öneriler)
        List<ActivityDto> allActivities = new ArrayList<>();

        // A) Son Postları Çek (Pageable ile sınırla)
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "created"));
        List<Post> posts = postRepository.findLatestByTagName(targetTag, pageable);

        for (Post post : posts) {
            allActivities.add(convertToActivity(post));
        }

        // B) Son Önerileri Çek
        // Not: RecommendationRepository AbstractRepository ise findAll(Pageable) destekler.
        List<Recommendation> recommendations = recommendationRepository.findAll(pageable).getContent();

        for (Recommendation rec : recommendations) {
            allActivities.add(convertToActivity(rec));
        }

        // C) Listeleri Birleştir, Tarihe Göre Sırala ve İlk 5'i Al
        List<ActivityDto> sortedActivities = allActivities.stream()
                // Null check yaparak en yeni tarih en üstte olacak şekilde sırala
                .sorted(Comparator.comparing(ActivityDto::getCreatedDate, Comparator.nullsLast(Comparator.reverseOrder())))
                .limit(5)
                .collect(Collectors.toList());

        // DTO'ya set et
        dto.setBlogCount((int) blogCount);
        dto.setQuoteCount((int) quoteCount);
        dto.setSuggestionCount((int) suggestionCount); // Artık 0 değil
        dto.setLatestActivities(sortedActivities);

        return dto;
    }

    @Override
    public UserContributionDto getUserContributions() {
        String userId = JwtUtil.extractUserIdAndIfAnonymousThrow();
        String targetTag = "sosyalsorumluluk";

        long blogCount = postRepository.countByUserIdAndTagNameAndType(userId, targetTag, PostType.BLOG_POST);
        long quoteCount = postRepository.countByUserIdAndTagNameAndType(userId, targetTag, PostType.QUOTE_POST);

        // GÜNCELLEME: Kullanıcının kendi öneri sayısını çekiyoruz
        long mySuggestionCount = recommendationRepository.countByUserId(userId);

        return UserContributionDto.builder()
                .myBlogCount((int) blogCount)
                .myQuoteCount((int) quoteCount)
                .mySuggestionCount((int) mySuggestionCount)
                .build();
    }

    @Override
    public List<ActivityDto> getUserPostsByTagAndType(String typeStr) {
        String userId = JwtUtil.extractUserIdAndIfAnonymousThrow();
        String targetTag = "sosyalsorumluluk";

        // 1. ÖNCE "RECOMMENDATION" KONTROLÜ YAP
        if ("RECOMMENDATION".equalsIgnoreCase(typeStr)) {
            List<Recommendation> recommendations = recommendationRepository.findAllByUserId(userId);
            return recommendations.stream()
                    .map(this::convertToActivity)
                    .collect(Collectors.toList());
        }

        // 2. EĞER DEĞİLSE POST TYPE KONTROLÜ YAP
        try {
            PostType type = PostType.valueOf(typeStr);
            List<Post> posts = postRepository.findByUserIdAndTagNameAndType(userId, targetTag, type);
            return posts.stream()
                    .map(this::convertToActivity) // Post alan versiyon çalışır
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            // Geçersiz bir type geldiyse boş liste dön
            return new ArrayList<>();
        }
    }

    // --- YARDIMCI METOTLAR (Kod tekrarını önlemek için) ---

    private ActivityDto convertToActivity(Post post) {
        String username = "Anonim";
        String avatar = null;
        try {
            if (post.getUserId() != null) {
                UserDto user = userService.getById(post.getUserId());
                username = user.getUserName();
                // avatar = user.getAvatar(); // Eğer varsa
            }
        } catch (Exception ignored) {}

        return ActivityDto.builder()
                .id(post.getId())
                .title(post.getTitle() != null ? post.getTitle() : "İsimsiz İçerik")
                .type(post.getType().name())
                .createdDate(post.getCreated()) // Sıralama için gerekli
                .timeAgo(post.getCreated() != null ? post.getCreated().toString() : "") // Frontend formatı
                .likeCount(post.getLikeCount() != null ? post.getLikeCount() : 0)
                .commentCount(post.getCommentCount() != null ? post.getCommentCount() : 0)
                .username(username)
                .userAvatar(avatar)
                .description(post.getContent())
                .build();
    }

    private ActivityDto convertToActivity(Recommendation rec) {
        String username = "Anonim";
        try {
            if (rec.getUserId() != null) {
                UserDto user = userService.getById(rec.getUserId());
                username = user.getUserName();
            }
        } catch (Exception ignored) {}

        return ActivityDto.builder()
                .id(rec.getId())
                .title(rec.getTitle())
                .type("RECOMMENDATION") // Frontend'de ikon ayrımı için
                .createdDate(rec.getCreated()) // Sıralama için gerekli
                .timeAgo(rec.getCreated() != null ? rec.getCreated().toString() : "")
                .likeCount(0) // Önerilerde beğeni yoksa 0
                .commentCount(0)
                .username(username)
                .description(rec.getDescription())
                .build();
    }
}