# Spring MVC to Spring Boot – CRUD Application Migration

## Project Overview

This project demonstrates the migration of a traditional **Spring MVC CRUD (Create, Read, Update, Delete) application** to **Spring Boot**.

The main objective is to simplify application configuration, reduce boilerplate code, and modernize database operations using Spring Boot and Spring Data JPA.

The original Spring MVC application used a traditional DAO layer to handle database operations. During migration, the DAO implementation is replaced with a Spring Data JPA Repository, allowing database interactions to be handled with minimal code.

## Objectives

- Migrate a traditional Spring MVC application to Spring Boot.
- Replace XML-based configuration with Spring Boot auto-configuration.
- Replace the DAO implementation with Spring Data JPA Repository.
- Implement CRUD operations using Spring Data JPA.
- Integrate Hibernate and MySQL for database management.
- Simplify dependency management using Maven.
- Improve application maintainability and scalability.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Application framework |
| Spring MVC | Web layer and request handling |
| Spring Data JPA | Database operations |
| Hibernate | ORM framework |
| MySQL | Relational database |
| Maven | Dependency management |
| Jakarta Persistence | Entity mapping |
| Thymeleaf / JSP | View layer (depending on implementation) |

## Migration: Spring MVC vs Spring Boot

| Spring MVC (Traditional) | Spring Boot |
|---|---|
| XML-based configuration | Auto-configuration |
| Manually configured DispatcherServlet | Embedded Tomcat |
| Traditional DAO implementation | Spring Data JPA Repository |
| Manual Hibernate configuration | Spring Boot JPA configuration |
| Manually managed dependencies | Spring Boot Starter dependencies |
| WAR deployment commonly used | Executable JAR deployment |

## Project Structure

```text
SpringBootCRUD/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/SpringBootCRUD/
│   │   │       │
│   │   │       ├── SpringBootCrudApplication.java
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── UserController.java
│   │   │       │
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java
│   │   │       │
│   │   │       └── service/
│   │   │           └── UserService.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │
│   └── test/
│
└── pom.xml
```

## Key Migration Changes

### 1. DAO Layer to Repository Layer

In traditional Spring MVC, a DAO interface was created to define database operations.

Example:

```java
public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
```

In Spring Boot, this can be replaced with a Spring Data JPA Repository.

**UserRepository.java**

```java
package com.example.SpringBootCRUD.repository;

import com.example.SpringBootCRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

By extending `JpaRepository`, Spring Boot automatically provides commonly used database operations.

| Method | Function |
|---|---|
| findAll() | Retrieve all users |
| findById(id) | Retrieve a user by ID |
| save(user) | Insert or update a user |
| deleteById(id) | Delete a user by ID |
| existsById(id) | Check whether a user exists |

This eliminates the need to manually implement basic CRUD operations.

### 2. Entity Layer

The User model is converted into a JPA Entity using annotations.

**User.java**

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    // Getters and Setters
}
```

### 3. Database Configuration

Instead of manually configuring Hibernate and database connections, Spring Boot uses `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springbootcrud
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

**Note:** Replace the database name, username, and password with your local MySQL configuration.

### 4. CRUD Operations

Spring Data JPA simplifies CRUD operations.

| CRUD Operation | Repository Method |
|---|---|
| Create User | save(user) |
| Read All Users | findAll() |
| Read User by ID | findById(id) |
| Update User | save(user) |
| Delete User | deleteById(id) |

Example:

```java
@Autowired
private UserRepository userRepository;

// Get all users
public List<User> getAllUsers() {
    return userRepository.findAll();
}

// Get user by ID
public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("User not found"));
}

// Save user
public User saveUser(User user) {
    return userRepository.save(user);
}

// Delete user
public void deleteUser(Long id) {
    userRepository.deleteById(id);
}
```

## Maven Dependencies

The following dependencies are required in `pom.xml`:

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector/J
- Spring Boot Starter Validation
- Spring Boot Starter Test

## How to Run the Project

### Prerequisites

- Java 17 or later (depending on Spring Boot version)
- Maven
- MySQL Server
- IntelliJ IDEA / Eclipse / Spring Tool Suite

### Steps

1. Clone the repository.

```bash
git clone <your-github-repository-url>
```

2. Open the project in your preferred IDE.

3. Configure MySQL credentials in `application.properties`.

4. Create the database.

```sql
CREATE DATABASE springbootcrud;
```

5. Build the project.

```bash
mvn clean install
```

6. Run the Spring Boot application.

```bash
mvn spring-boot:run
```

7. Access the application:

```text
http://localhost:8080
```

## Benefits of Migration

- Reduced boilerplate code.
- Simplified database connectivity.
- Automatic CRUD implementation through JpaRepository.
- Reduced dependency on XML configuration.
- Embedded server support.
- Easier application maintenance.
- Faster development and deployment.

## Conclusion

This migration demonstrates how a traditional Spring MVC CRUD application can be modernized using Spring Boot and Spring Data JPA.

The most significant improvement is replacing the manually implemented DAO layer with Spring Data JPA Repository, which reduces repetitive database code and makes the application easier to maintain.

The project provides a foundation for building modern Java web applications using the Spring Boot ecosystem.

---

**Project:** Spring MVC to Spring Boot Migration  
**Category:** Java | Spring Framework | Spring Boot | CRUD | Hibernate | MySQL