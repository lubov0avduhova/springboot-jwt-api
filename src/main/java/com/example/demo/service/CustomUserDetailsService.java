package com.example.demo.service;


import org.springframework.security.core.userdetails.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.demo.entity.User user = repository.findByUsername(username).orElseThrow();
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRole().name()).build();
    }
}
