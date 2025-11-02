package com.example.blogsitebe.domain.auth.auth.api;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TokenDto {
    private String token;
    private String hash;
    private String otpCode;
}