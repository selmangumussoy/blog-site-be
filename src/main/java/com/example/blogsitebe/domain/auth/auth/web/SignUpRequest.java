package com.example.blogsitebe.domain.auth.auth.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest{
    String password;
    String phoneNumber;
    String fullName;
    String username;
}