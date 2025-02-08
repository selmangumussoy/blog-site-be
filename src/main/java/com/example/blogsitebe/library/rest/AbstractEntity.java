package com.example.blogsitebe.library.rest;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.io.Serializable;
import java.util.Date;

/**
 * Base model for all entity classes that uses UUIDs as ID values and provides creation timestamp
 */

@Getter
@MappedSuperclass //bu sınıfın bir "temel sınıf" olduğunu belirtir.
@EqualsAndHashCode(of = "id")
public abstract class AbstractEntity implements Serializable {

    @Id
    @Column(nullable = false, unique = false)
    @GeneratedValue(generator = "system-uuid")
    private String id;


    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date modified;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + ", created=" + created + ", modified=" + modified + "]";
    }

}
