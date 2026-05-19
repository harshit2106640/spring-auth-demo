# Spring Boot Full-Stack Authentication System

A full-stack authentication system built using Spring Boot, Spring Security, JWT, MySQL, HTML, CSS, and JavaScript.

## Features

### Authentication
- User Registration
- User Login
- JWT Token Generation
- BCrypt Password Hashing
- Stateless Authentication

### Authorization
- USER and ADMIN roles
- Protected APIs
- Role-based access control

### Frontend
- Register page
- Login page
- Dashboard page
- Logout functionality
- JWT storage using localStorage

### Validation & Exception Handling
- DTO Validation
- Global Exception Handling
- Custom Exceptions

---

# Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT (JJWT)
- MySQL
- Maven
- Lombok

## Frontend
- HTML
- CSS
- JavaScript
- Fetch API

---

# API Endpoints

## Register
POST /api/auth/register

## Login
POST /api/auth/login

## User Profile
GET /api/user/profile

## Admin Dashboard
GET /api/admin/dashboard

---

# Frontend Pages

- /register.html
- /login.html
- /dashboard.html

---

# JWT Authentication Flow

User Login
→ JWT Generated
→ Token Stored in Browser
→ Token Sent with Requests
→ Backend Validates JWT
→ Access Granted

---

# How to Run

1. Clone Repository

git clone https://github.com/harshit2106640/spring-auth-demo.git

2. Create Database

CREATE DATABASE auth_db;

3. Configure MySQL credentials in application.properties

4. Run SpringAuthDemoApplication.java

5. Open:
   http://localhost:8080/register.html

---

# Future Improvements

- Swagger/OpenAPI
- Refresh Tokens
- Docker Deployment
- Unit Testing
- React Frontend

---

# Author

Built as a full-stack Spring Boot authentication learning project.
