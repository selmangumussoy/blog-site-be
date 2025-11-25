package com.example.blogsitebe.domain.platform.socialresponsibility.api;


import com.example.blogsitebe.library.abstraction.AbstractDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder

    public class SocialResponsibilityDto extends AbstractDto {

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
        private int suggestionCount;
    }

