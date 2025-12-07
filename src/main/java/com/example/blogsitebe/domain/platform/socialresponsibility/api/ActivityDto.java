package com.example.blogsitebe.domain.platform.socialresponsibility.api;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ActivityDto {
    private String id;
    private String title;
    private String type; // "BLOG_POST", "QUOTE_POST" vb.
    private String timeAgo; // Frontend'de "2 saat önce" hesabı için tarih stringi
    private int likeCount;
    private int commentCount;
    private String username;
    private String userAvatar;
    private Date createdDate;
    private String description;
}
