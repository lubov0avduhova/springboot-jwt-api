package com.example.demo.dto;

import com.example.demo.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String username;
    private Role role;
    private Instant accessExpiresAt;
    private Instant refreshExpiresAt;
}

