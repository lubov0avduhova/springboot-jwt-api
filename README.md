# Spring Boot JWT API

Полноценный REST API с регистрацией, авторизацией через JWT, обновлением токенов (refresh token), logout (blacklist) и документацией Swagger UI.

---

## 📚 Стек технологий:

- Java 17+
- Spring Boot 3
- Spring Security
- Spring Data JPA
- JWT (jjwt)
- H2 Database
- Swagger (springdoc-openapi)

---

## 🚀 Функциональность:

- Регистрация юзеров /auth/register
- Логин /auth/login (accessToken + refreshToken)
- Обновление accessToken /auth/refresh
- Выход из системы /auth/logout (blacklist)
- CRUD-операции для задач /tasks
- Ролевая защита (USER/ADMIN)
- Swagger UI + Bearer-token авторизация

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
│   └── CustomUserDetailsService.java
├── entity
│   ├── User.java
│   ├── Task.java
│   └── Role.java
├── repository
│   ├── UserRepository.java
│   └── TaskRepository.java
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

- JWT-авторизация (accessToken + refreshToken)
- Logout через Blacklist
- BCrypt-хэширование паролей
- Глобальная обработка ошибок
- Валидация входящих DTO

---

## 📚 Как запустить:

1. Склонируйте проект
2. Откройте в IntelliJ IDEA / VS Code
3. Убедитесь, что Java 17+ и Maven подключены
4. `mvn clean install`
5. Запустите `DemoApplication`
6. Swagger UI доступен по [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🌟 Статус:

Проект завершён. Готов для демонстрации или реального использования!
