package com.example.blogsitebe.domain.auth.user.impl;

import com.example.blogsitebe.domain.auth.user.api.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column()
    private boolean accountNonExpired;      //hesabının süresinin dolup dolmadığını

    @Column()
    private boolean enabled;                //hesabının etkin olup olmadığını

    @Column()
    private boolean accountNonLocked;       //hesabının kilitli olup olmadığını

    @Column()
    private boolean credentialsNonExpired;  //kimlik bilgilerinin süresinin dolup dolmadığını

    @Column()
    private String name;


    @Column()
    private String surname;

    @Column()
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; // Şifre (BCrypt ile saklanacak)

    @Enumerated(EnumType.STRING)  // Enum değerini String olarak saklar
    @Column(nullable = false)
    private Role role; // Kullanıcı rollerini saklar
}
