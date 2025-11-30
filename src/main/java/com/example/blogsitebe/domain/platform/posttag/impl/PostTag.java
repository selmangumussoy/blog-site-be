package com.example.blogsitebe.domain.platform.posttag.impl;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = PostTag.TABLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostTag extends AbstractEntity {

    public static final String TABLE = "post_tag";
    public static final String COL_POST_ID = "post_id";
    public static final String COL_TAG_ID = "tag_id";

    @Column(name = COL_POST_ID, nullable = false)
    private String postId;

    @Column(name = COL_TAG_ID, nullable = false)
    private String tagId;
}
