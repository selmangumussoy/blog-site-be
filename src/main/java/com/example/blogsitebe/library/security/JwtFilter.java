package com.example.blogsitebe.library.security;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
* Amaç: Gelen token'ı doğrulamak ve kimlik bilgilerini Spring Security'ye entegre etmek.
*/

@Service
public class JwtFilter extends OncePerRequestFilter {
    private final CustomUserDetailService customUserDetailService;

    public JwtFilter(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            String username = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody().getSubject();

            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
