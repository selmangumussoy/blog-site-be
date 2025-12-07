package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.api;

import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class RecommendationDto extends AbstractDto {
    private String userId;
    private String title;
    private String description;
    private String link;
}