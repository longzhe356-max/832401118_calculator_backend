# Code Style

This project follows the Google Java Style Guide.

Source: https://google.github.io/styleguide/javaguide.html

## Key Rules

1. Class names use UpperCamelCase (e.g. `CalculationHistory`).
2. Method and variable names use lowerCamelCase (e.g. `getHistory`, `expression`).
3. Constants use UPPER_SNAKE_CASE (e.g. `MAX_SIZE`).
4. Every class should have a clear Javadoc comment.
5. Use 4 spaces for indentation.
6. Package names are all lowercase (e.g. `com.llz.ccc`).
7. Layered architecture: Controller / Service / Repository / Entity / DTO.
8. The controller layer handles requests and responses; the service layer contains business logic.
9. Do not use `eval`, `exec`, or any arbitrary code execution method.