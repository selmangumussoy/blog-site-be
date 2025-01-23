package com.example.blogsitebe.library.security;

import com.example.blogsitebe.domain.auth.user.api.UserRole;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Spring Security'nin kullanıcı bilgilerini (UserDetails) tanıyabilmesi için özel bir
kullanıcı detay sınıfı oluşturmak.
*/
public class CustomUserDetails implements UserDetails {
    private final String username;
    private final String password;

    public CustomUserDetails(String username, String password, Set<UserRole> roles) {
        this.username = username;
        this.password = password;
        Set<GrantedAuthority> authorities = roles.stream()
                .map(role -> (GrantedAuthority) role::name)
                .collect(Collectors.toSet());
    }
//    private final String name;
//    private final String surname;
//    private final String email;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
