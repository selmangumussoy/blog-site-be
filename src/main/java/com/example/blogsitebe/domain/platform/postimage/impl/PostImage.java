package com.example.blogsitebe.domain.platform.postimage.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = PostImage.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostImage extends AbstractEntity {

    public static final String TABLE = "post_image";
    public static final String COL_POST_ID = "post_id";
    public static final String COL_URL = "url";
    public static final String COL_ORDER_INDEX = "order_index";

    @Column(name = COL_POST_ID, nullable = false)
    private String postId; // hangi post’a ait

    @Column(name = COL_URL, nullable = false)
    private String url; // dosya erişim URL’si (S3, CDN vs.)

    @Column(name = COL_ORDER_INDEX)
    private Integer orderIndex; // sıralama (1, 2, 3...)
}
