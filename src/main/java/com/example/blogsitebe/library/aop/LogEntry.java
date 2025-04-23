package com.example.blogsitebe.library.aop;


import com.example.blogsitebe.library.rest.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogEntry extends AbstractEntity {

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