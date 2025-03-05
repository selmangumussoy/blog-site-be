package com.example.blogsitebe.library.security;

import com.example.blogsitebe.domain.auth.user.impl.User;
import com.example.blogsitebe.domain.auth.user.impl.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
UserDetailsService arabirimini
implement ederek kullanıcı doğrulama işlemleri için kullanıcı detaylarını sağlamak.
* */
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new CustomUserDetails(user);
    }

//        return new CustomUserDetails(
//            user.getName(),
//            user.getPassword(),
//            //user.getUserRole()
//        );
//    }

}