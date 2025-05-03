package com.example.blogsitebe.library.aop;


import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = LogEntry.TABLE)
public class LogEntry extends AbstractEntity {
    public static final String TABLE = "log_entry";

    @Column(nullable = false)
    private String httpMethod;

    @Column(nullable = false)
    private String uri;

    @Column(columnDefinition = "TEXT")
    private String arguments;

    @Column(nullable = false)
    private String userId;

    @Column(name = "ip_address")
    private String ipAddress;

}