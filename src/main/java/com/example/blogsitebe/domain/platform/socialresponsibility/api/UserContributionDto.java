package com.example.blogsitebe.domain.platform.socialresponsibility.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserContributionDto {
    private int myBlogCount;
    private int myQuoteCount;
    private int mySuggestionCount;
}
