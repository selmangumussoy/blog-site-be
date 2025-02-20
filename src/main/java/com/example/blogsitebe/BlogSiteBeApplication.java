package com.example.blogsitebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogSiteBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSiteBeApplication.class, args);
    }

}
