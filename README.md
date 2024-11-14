
# Ubudehe Project Backend

This repository hosts the backend of the Ubudehe Project, a system built to manage and monitor various categories and user actions. It includes functionality for logging, auditing, category management, user management, and role assignment, and is built using Java and the Spring Framework.

## Project Overview

The Ubudehe Project Backend is a Spring Boot application designed to support administrative tasks and provide a structured, organized approach to managing categories, users, and their roles. This backend service includes auditing functionalities to log actions for tracking and security purposes.

## Features

### Core Modules

- Audit Logging: Tracks and records actions within the system.
- Category Management: Supports adding, viewing, and managing various categories.
- User Management: Allows for creating, viewing, and modifying user profiles.
- Role Management: Assigns roles to users to control access and permissions.
- Exception Handling: Handles specific exceptions for a robust and error-tolerant system.

### Audit Module

- List Audit Logs: Retrieve all recorded audit logs.
- Add Audit Log: Manually add a log entry.
- Find Audit Log by ID: Retrieve a specific audit log entry by its ID.

## Technology Stack

- Java: Programming language used for application development.
- Spring Boot: Framework for creating the backend REST API.
- JPA / Hibernate: For object-relational mapping and database management.
- H2/MySQL/PostgreSQL (optional): Supported databases.
- Maven: Project management and build tool.

## System Requirements

- Java 11 or later
- Maven
- Database (H2 for testing, or MySQL/PostgreSQL for production)

## Installation Steps

1. Clone the repository:

   bash
   git clone https://github.com/Katumbigeorges/Ubudehe-Project-Backend.git
   cd Ubudehe-Project-Backend
   

2. Set up your database configuration in `application.yml` or `application.properties`.

3. Build and run the application:

   bash
   mvn spring-boot:run
   

4. The backend server should start on `http://localhost:8080`.

## Usage

- API Endpoints: Use API endpoints for managing categories, users, roles, and audit logs.

-Admin Interface: Access the API via a client like Postman to manage entities (e.g., add categories, assign roles, view audit logs).

## Directory Structure

- `controller/`: Contains REST controllers for each entity (e.g., AuditLogController, CategoryController).
- `service/`: Business logic for handling audit logs, categories, and user roles.
- `repository/`: Interfaces extending JPA repositories for data persistence.
- `model/`: Domain models such as `AuditLog`, `Category`, `User`, and `Role`.
- `exception/`: Custom exceptions for error handling.

## License

This project is licensed under the MIT License.

⭐ If you find this project helpful, please consider giving it a star on [GitHub](https://github.com/Katumbigeorges/Ubudehe-Project-Backend)!


