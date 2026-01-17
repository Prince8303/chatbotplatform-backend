# Architecture & Design Overview

## Overview
This backend system manages AI chatbot agents with secure authentication,
project-based prompt management, and a chat interface.

---

## Architecture
The application follows a layered architecture:

Controller → Service → Repository → Database

Security is enforced using JWT and Spring Security.

---

## Authentication Flow
1. User registers with email and password
2. Password is stored using BCrypt hashing
3. User logs in and receives a JWT token
4. JWT is validated by a filter on each request
5. Authenticated user context is set for protected APIs

---

## Core Entities
- User: Represents an authenticated user
- Project: Represents a chatbot agent owned by a user
- Prompt: Represents system prompts associated with a project
- ChatMessage: Represents chat interactions (optional persistence)

Relationships:
- One User → Many Projects
- One Project → Many Prompts

---

## Chat Flow
1. User sends a message to a project chat endpoint
2. Prompts are loaded as system context
3. Message is processed via an LLM service abstraction
4. Response is returned to the client

---

## Security Considerations
- Stateless JWT authentication
- Protected endpoints
- No sensitive data exposed in API responses
