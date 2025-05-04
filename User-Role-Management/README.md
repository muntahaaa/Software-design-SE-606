# User Management System

A clean architecture-based user management system built with Spring Boot and JPA.

## Technologies

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- JUnit 5
- Mockito
- Maven

## Project Structure
src/ ├── main/ │ ├── java/ │ │ └── com/example/usermanagement/ │ │ ├── domain/ # Domain entities │ │ ├── application/ # Service layer │ │ └── infrastructure/ # Adapters (JPA, Controllers) │ └── resources/ └── test/ └── java/
## Prerequisites

- JDK 17 or higher
- Maven 3.6+

## Setup

1. Clone the repository:

```git clone https://github.com/muntahaaa/Software-design-SE-606/tree/main/User-Role-Management```
```cd usermanagement```
## 1.Build the project:
```mvn clean install```
## 2. Running the Application
Start the application using Maven:
```mvn spring-boot:run```

The application will start on http://localhost:8080
## 3. Running Tests
Execute the test suite:
```mvn test```
## Project Features
- Role management with CRUD operations
- Clean Architecture implementation
- Unit tests with JUnit and Mockito
- H2 in-memory database for development
## API Endpoints
- Create Role: POST /roles
- Get Role: GET /roles/{id}
## Database
The project uses H2 in-memory database by default.
The console is available at: 
http://localhost:8080/h2-console 
## Connection details:

- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (empty)
