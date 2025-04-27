# Spring Boot Secure REST API (JWT + OAuth2 + Управление ролями)

### Полноценный боевой REST API на Spring Boot 3 с :

* Авторизацией через JWT токены (access / refresh)

* Аутентификацией через Google (OAuth2 / OpenID Connect)

* Ограничением количества сессий

* Управлением ролями пользователей через базу данных

* Кастомной обработкой ошибок безопасности

* Документацией через Swagger UI
---

## 📚 Стек технологий:

* Java 17+
* Spring Boot 3
* Spring Security 6
* Spring Data JPA
* JWT (jjwt)
* OAuth2 / OpenID Connect (Google login)
* H2 Database
* Swagger (springdoc-openapi)
---

## 🚀 Функциональность:

* Регистрация пользователей (/auth/register)

* Логин через форму (/auth/login) — получение accessToken и refreshToken

* Обновление accessToken через /auth/refresh

* Выход из системы через /auth/logout (Blacklist токенов)

* Авторизация через Google (OAuth2 + OpenID Connect)

* CRUD-операции для задач (/tasks)

* Ограничение доступа по ролям (USER / ADMIN)

* Ограничение количества активных сессий пользователя

* Динамическое управление ролями через базу данных

* Кастомная глобальная обработка ошибок: 401, 403, превышение лимита сессий

* Документация Swagger UI c авторизацией Bearer-token
---

## 📚 Структура проекта:
```
com.example.demo
├── config
│   ├── SecurityConfig.java
│   └── OpenApiConfig.java
├── controller
│   ├── AuthController.java
│   └── TaskController.java
├── service
│   ├── JwtService.java
│   ├── TaskService.java
│   ├── CustomUserDetailsService.java
│   └── CustomOAuth2UserService.java
├── entity
│   ├── User.java
│   ├── Task.java
│   └── Role.java
├── repository
│   ├── UserRepository.java
│   ├── RoleRepository.java
│   └── TaskRepository.java
├── security
│   ├── JwtAuthFilter.java
├── dto
│   ├── AuthResponse.java
│   ├── LoginRequest.java
│   ├── RefreshRequest.java
│   ├── RegisterRequest.java
│   ├── TaskDto.java
│   └── PagedResponse.java
├── exception
│   ├── GlobalExceptionHandler.java
│   └── TaskNotFoundException.java
└── DemoApplication.java
```
---

## 🔒 Безопасность:

* JWT-авторизация (AccessToken + RefreshToken)

* OAuth2 / OpenID Connect (вход через Google)

* Ограничение количества сессий на пользователя

* Blacklist токенов при logout

* BCrypt-хэширование паролей

* Динамическое управление ролями через базу данных

* Ограничение доступа через @Secured, @PreAuthorize, @PostAuthorize

* Глобальная обработка ошибок (отдельно 401, 403, Session Overflow)

* Полная защита REST API через Spring Security
---

📚 Как запустить:

* Склонируйте проект

* Откройте в IntelliJ IDEA или VS Code

* Убедитесь, что Java 17+ и Maven установлены

* `mvn clean install`

* Запустите `DemoApplication`

* Swagger UI доступен по [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

🌟 Статус:

Проект завершён.