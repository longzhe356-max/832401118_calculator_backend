# Calculator Backend

Back-end service for a front-end/back-end separated calculator system, built with Spring Boot 3.

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 database
- exp4j (safe math expression evaluation)

## Requirements

- JDK 17 or higher
- Maven 3.6 or higher

## Run

mvn spring-boot:run

Or run CccApplication.java directly in your IDE.

The service starts on http://localhost:8080.

## Database

The project uses an H2 file database. The database file is created automatically at:

./data/calculator.mv.db

No manual initialization is required. Tables are created automatically by JPA on startup.

## API

Method | URL                | Description
-------|--------------------|--------------------------------
POST   | /api/calculate     | Evaluate a math expression
GET    | /api/history       | Get all calculation history
DELETE | /api/history/{id}  | Delete one history record
DELETE | /api/history       | Clear all history

### Example: Calculate

Request:

POST /api/calculate
{ "expression": "(1+2)*3" }

Response:

{ "success": true, "expression": "(1+2)*3", "result": 9.0 }

### Example: Error Response

{ "success": false, "message": "Division by zero" }

## Project Structure

src/main/java/com/llz/ccc/
controller/    REST API layer
service/       Business logic and expression evaluation
repository/    Data access layer
entity/        JPA entities
dto/           Request and response objects
config/        CORS and other configuration

## Notes

- Core calculation is performed on the back-end.
- The eval / exec methods are not used. Expressions are parsed safely with the exp4j library.