package com.example.blogsitebe.domain.platform.socialresponsibilityrecommendation.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Recommendation.TABLE)
public class Recommendation extends AbstractEntity {

    public static final String TABLE = "recommendations";

    @Column(nullable = false)
    private String userId; // Öneriyi yapan kullanıcı ID'si

    @Column(nullable = false)
    private String title;  // Öneri Başlığı

    @Column(columnDefinition = "TEXT")
    private String description; // Detaylı açıklama

    @Column
    private String link; // Varsa link (video, makale vb.)
}
