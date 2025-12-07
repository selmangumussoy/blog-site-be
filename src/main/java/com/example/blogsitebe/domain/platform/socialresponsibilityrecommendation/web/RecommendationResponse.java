package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class RecommendationResponse extends AbstractResponse {
    private String userId;
    private String title;
    private String description;
    private String link;
}