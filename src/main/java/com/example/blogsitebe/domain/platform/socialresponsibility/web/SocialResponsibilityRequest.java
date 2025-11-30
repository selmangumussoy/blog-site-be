package com.example.blogsitebe.domain.platform.socialresponsibility.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialResponsibilityRequest {
    private String title;
    private String description;
    private String weekLabel;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
}