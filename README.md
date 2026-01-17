# Chatbot Platform Backend

This project is a backend system for managing AI chatbot agents.  
It supports user authentication, project (agent) management, prompt storage, and a chat interface using an LLM abstraction.

---

## 🚀 Tech Stack
- Java 21
- Spring Boot 4
- Spring Security 7 (JWT Authentication)
- MySQL
- Hibernate / JPA
- Swagger (OpenAPI)

---

## 🔐 Authentication
- Users can register and login using email & password
- Passwords are stored using BCrypt hashing
- JWT is used for stateless authentication
- Protected APIs require the following header:

Authorization: Bearer <JWT_TOKEN>

---

## 📦 Features
- User registration and login
- JWT-based authentication & authorization
- Create chatbot projects (agents)
- Store prompts associated with projects
- Chat with a project using prompts as system context

---

## 🧪 API Documentation
Swagger UI is available at:

http://localhost:8080/swagger-ui.html

---

## ▶️ How to Run the Application

### 1️⃣ Prerequisites
- Java 21
- Maven
- MySQL

---

### 2️⃣ Database Setup
Create a database in MySQL:

CREATE DATABASE chatbot_platform;

Update `application.properties` with your credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/chatbot_platform  
spring.datasource.username=YOUR_USERNAME  
spring.datasource.password=YOUR_PASSWORD

---

### 3️⃣ Run the Application
From the project root directory, run:

mvn spring-boot:run

The application will start at:

http://localhost:8080

---

## 🔑 How to Use the APIs
1. Register a user using `/api/auth/register`
2. Login using `/api/auth/login` to get a JWT token
3. Open Swagger UI
4. Click **Authorize**
5. Enter: `Bearer <JWT_TOKEN>`
6. Access protected APIs (projects, prompts, chat)

---

## 🧠 Notes
- The LLM integration is implemented as a service abstraction and can be replaced with a real provider
- Passwords are never exposed in API responses
- The application follows a layered architecture (Controller → Service → Repository)

---

## ✅ Status
All core assignment requirements have been implemented successfully.
