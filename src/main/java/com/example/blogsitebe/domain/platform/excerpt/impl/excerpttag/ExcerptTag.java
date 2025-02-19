package com.example.blogsitebe.domain.platform.excerpt.impl.excerpttag;

import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = ExcerptTag.TABLE)
public class ExcerptTag extends AbstractEntity {
    public static final String TABLE = "excerpt_tag";
    public static final String COL_EXCERPT_ID = "excerpt_id";
    public static final String COL_TAG_ID = "tag_id";

    @Column(name = COL_EXCERPT_ID)
    private String excerptId;

    @Column(name =  COL_TAG_ID)
    private String tagId;
}
