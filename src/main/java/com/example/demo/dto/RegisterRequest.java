package com.example.demo.dto;

import com.example.demo.entity.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class RegisterRequest {
    @NotNull(message = "Имя пользователя обязательно")
    private String username;
    @NotNull(message = "Пароль обязателен")
    private String password;
    @NotNull(message = "Роль обязательна")
    private Set<Role> role;
}