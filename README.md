# Spring Boot Authentication API

A simple Spring Boot authentication project implementing:

- User Registration
- User Login
- Validation
- Exception Handling
- Password Encryption using BCrypt
- MySQL Database Integration
- Layered Architecture

---

# Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL
- Lombok
- Maven

---

# Features

## User Registration
- Register new users
- Prevent duplicate emails
- Password hashing using BCrypt

## User Login
- Validate credentials
- Secure password verification

## Validation
- Email validation
- Required field validation
- Password length validation

## Exception Handling
- Global exception handling using `@RestControllerAdvice`
- Clean API responses

---

# Project Structure

```text
src/main/java/com/example/springauthdemo
│
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config
```

---

# API Endpoints

## Register User

### Request

`POST /api/auth/register`

```json
{
  "name": "John",
  "email": "john@gmail.com",
  "password": "123456"
}
```

### Response

```json
{
  "success": true,
  "message": "User registered successfully"
}
```

---

## Login User

### Request

`POST /api/auth/login`

```json
{
  "email": "john@gmail.com",
  "password": "123456"
}
```

### Response

```json
{
  "success": true,
  "message": "Login successful"
}
```

---

# Validation Example

```json
{
  "name": "",
  "email": "abc",
  "password": "12"
}
```

### Response

```json
{
  "name": "Name is required",
  "email": "Invalid email format",
  "password": "Password must be at least 6 characters"
}
```

---

# Database Configuration

Update `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/auth_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# How to Run

## 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/spring-auth-demo.git
```

## 2. Open Project

Open using IntelliJ IDEA or VS Code.

## 3. Create Database

```sql
CREATE DATABASE auth_db;
```

## 4. Configure MySQL Credentials

Update:

```properties
application.properties
```

## 5. Run Application

Run:

```text
SpringAuthDemoApplication.java
```

---

# Learning Concepts Covered

- Spring Boot REST APIs
- DTO Pattern
- Validation
- Global Exception Handling
- JPA & Hibernate
- Password Hashing
- Layered Architecture
- Clean Code Practices

---

# Future Improvements

- JWT Authentication
- Role-Based Authorization
- Refresh Tokens
- Swagger Documentation
- Unit Testing
- Email Verification

---

# Author

Built as a Spring Boot learning project.
