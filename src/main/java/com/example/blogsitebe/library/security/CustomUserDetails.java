package com.example.blogsitebe.library.security;

import com.example.blogsitebe.domain.auth.user.impl.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/*
Spring Security'nin kullanıcı bilgilerini (UserDetails) tanıyabilmesi için özel bir
kullanıcı detay sınıfı oluşturmak.
*/
public class CustomUserDetails implements UserDetails {
    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
    }
//    user.getRole().name() ile "ROLE_USER" veya "ROLE_ADMIN" olarak
//    Spring Security'nin anlayacağı bir formatta döndürüyoruz.

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;// Hesap süresinin dolup dolmadığını belirtir
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Hesap kilitli mi
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Kimlik bilgileri süresi dolmuş mu
    }

    @Override
    public boolean isEnabled() {
        return true; // Kullanıcı aktif mi
    }
}
