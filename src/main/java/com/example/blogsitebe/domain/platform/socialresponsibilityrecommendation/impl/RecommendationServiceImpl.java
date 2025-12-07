package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.impl;

import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationDto;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationMapper;
import com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api.RecommendationService;
import com.example.blogsitebe.library.abstraction.AbstractServiceImpl;
import com.example.blogsitebe.library.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl extends AbstractServiceImpl<Recommendation, RecommendationDto> implements RecommendationService {

    private final RecommendationRepository repository;

    public RecommendationServiceImpl(RecommendationRepository repository, RecommendationMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
    }

    @Override
    protected String getEntityName() {
        return "Recommendation"; // Class name yerine String dönebilirsin
    }

    @Override
    protected void updateEntityFields(Recommendation entity, RecommendationDto dto) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setLink(dto.getLink());
        // userId güncelleme sırasında değişmemeli, o yüzden set etmiyoruz.
    }

    @Override
    @Transactional
    public RecommendationDto create(RecommendationDto dto) {
        String currentUserId = JwtUtil.extractUserIdAndIfAnonymousThrow();

        long existingCount = repository.countByUserId(currentUserId);
        if (existingCount >= 5) {
            throw new RuntimeException("En fazla 5 öneri oluşturabilirsiniz!");
        }

        dto.setUserId(currentUserId);
        return super.create(dto);
    }
    @Override
    public List<RecommendationDto> findAllByUserId(String userId) {
        List<Recommendation> entities = repository.findAllByUserId(userId);

        return entities.stream()
                .map(mapper::entityToDto) // AbstractServiceImpl'den gelen mapper kullanılıyor
                .collect(Collectors.toList());
    }
}
