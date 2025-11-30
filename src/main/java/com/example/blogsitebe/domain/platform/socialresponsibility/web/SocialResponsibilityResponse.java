package com.example.blogsitebe.domain.platform.socialresponsibility.web;

import com.example.blogsitebe.library.abstraction.AbstractResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
public class SocialResponsibilityResponse extends AbstractResponse {
    // Tema Verileri
    private String title;
    private String description;
    private String weekLabel;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isActive;
    private List<String> tags;
    private int blogCount;
    private int quoteCount;
    private int thoughtPostCount;
}