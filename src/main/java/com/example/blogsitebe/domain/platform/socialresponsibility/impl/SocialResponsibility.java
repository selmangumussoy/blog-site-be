package com.example.blogsitebe.domain.platform.socialresponsibility.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = SocialResponsibility.TABLE)
public class SocialResponsibility extends AbstractEntity {
    public static final String TABLE = "social_responsibility";

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "week_label")
    private String weekLabel;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_active")
    private boolean isActive;
}