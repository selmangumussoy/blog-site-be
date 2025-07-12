package com.example.blogsitebe.library.security;

import com.example.blogsitebe.library.enums.MessageCodes;
import com.example.blogsitebe.library.exception.CoreException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {
    @Value("${jwt.secret.key}")
    private String SECRET_KEY = "secret";
    public static final String UNKNOWN_USER = "unknown";
    private static final String ROLE = "role";
    private static final long JWT_EXPIRATION =  1000 * 60 * 60;
    private static final long ALLOWED_CLOCK_SKEW_SECONDS = 30 * 24 * 60 * 60L;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(ROLE, userDetails.getAuthorities().iterator().next().getAuthority());
        return createToken(claims,userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date()) //token oluşturulma zamanı
                .setExpiration(new Date(System.currentTimeMillis()+ JWT_EXPIRATION))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public static String extractUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !authentication.getPrincipal().equals("anonymousUser")) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((CustomUserDetails) principal).getId();
            }
        }
        return UNKNOWN_USER;
    }

    public static String extractUserIdAndIfAnonymousThrow() {
        var userId = extractUserId();
        if (userId.equals(UNKNOWN_USER)) {
            throw new CoreException(MessageCodes.TOKEN_EXPIRED);
        }
        return userId;
    }
    ////////////////////////////////////////////////////////////////////////////////
    // Token bilgilerini çekerek valide etme işlemleri //

    public boolean validateToken(String token, UserDetails userDetails) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(userDetails.getUsername()) && ! isTokenExpired(token));
    }
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .setAllowedClockSkewSeconds(ALLOWED_CLOCK_SKEW_SECONDS)//Saat farkı toleransı
                .build()
                .parseClaimsJws(token) // Token’ı doğrula ve çözümle
                .getBody();//Token içindeki bilgileri al
    }
}
