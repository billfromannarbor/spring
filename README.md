# Spring Boot Mini Exercises

This repository contains a series of small, focused Spring Boot exercises designed to reinforce core concepts and help you quickly gain confidence building REST APIs and working with Spring Boot's ecosystem.

Each exercise can be done independently and should take 5–30 minutes, depending on your familiarity with the topic.

---

## 📦 1. File Upload Endpoint

**Description:**  
Create an endpoint that accepts a file upload (multipart/form-data) and stores the file on disk.

**Skills Covered:**
- `@PostMapping`
- `MultipartFile`
- `application.properties` file storage config

---

## 🧑‍🤝‍🧑 2. Return Hard-Coded Users

**Description:**  
Create a `GET /users` endpoint that returns a list of hard-coded users in JSON format.

**Skills Covered:**
- `@RestController`
- `@GetMapping`
- Returning JSON

---

## 🔁 3. Echo POST Request

**Description:**  
Create an endpoint that accepts a JSON payload and returns it directly in the response.

**Skills Covered:**
- `@PostMapping`
- `@RequestBody`
- JSON serialization/deserialization

---

## 🗃️ 4. In-Memory CRUD with a Map

**Description:**  
Use a `Map<Long, Object>` to simulate a basic in-memory database with full CRUD operations.

**Skills Covered:**
- Basic service layer
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- Path variables and request bodies

---

## ⏱️ 5. Return Server Time

**Description:**  
Return the current server time in a readable format via a `GET /time` endpoint.

**Skills Covered:**
- Java Time API
- Response formatting

---

## 🔐 6. API Key Auth Filter

**Description:**  
Implement a filter that requires a static API key in the `Authorization` header.

**Skills Covered:**
- Custom filters
- Spring Security basics
- Working with headers

---

## 📧 7. Send an Email

**Description:**  
Create an endpoint that sends a test email (use Mailtrap or similar for dev/testing).

**Skills Covered:**
- Spring Boot Mail Starter
- External service integration

---

## ❤️ 8. Health Check Endpoint

**Description:**  
Create a `GET /health` endpoint that returns a simple JSON response like `{ "status": "UP" }`.

**Skills Covered:**
- Custom endpoints
- Optional: Spring Boot Actuator

---

## 👋 9. Greeting by Name

**Description:**  
Create a simple endpoint like `GET /hello/{name}` that returns `"Hello, Alice!"`.

**Skills Covered:**
- `@PathVariable`
- Quick testing and debugging

---

## 📄 10. CSV File Downloader

**Description:**  
Generate a CSV file in memory and return it as a downloadable response.

**Skills Covered:**
- Writing to `HttpServletResponse`
- Setting headers
- File download behavior

---

## ⏲️ 11. Scheduled Logging Task

**Description:**  
Log a message to the console every 10 seconds using a scheduled task.

**Skills Covered:**
- `@Scheduled`
- Spring Boot timing and background tasks

---

## 🚀 How to Get Started

1. Create a new Spring Boot project using [Spring Initializr](https://start.spring.io/)
2. Add only the necessary dependencies (e.g., Spring Web, Spring Security, Mail)
3. Pick an exercise above and implement it in isolation
4. Test using Postman or `curl`
5. Commit your solution to track your progress!

---

Happy coding! 🧑‍💻🐾