# Blog Management System

A Spring Boot REST API application for managing blog users with full CRUD operations.

## Features

- **User Management**: Complete CRUD operations for users
- **In-Memory Database**: Uses H2 database for quick setup and testing
- **Data Validation**: Input validation using Jakarta Bean Validation
- **Search Functionality**: Search users by username, email, first name, or last name
- **Soft Delete**: Deactivate/activate users without permanent deletion
- **Exception Handling**: Global exception handler for consistent error responses
- **Sample Data**: Pre-populated with sample users for testing

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Maven**
- **Jakarta Bean Validation**

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone or download the project
2. Navigate to the project directory
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

### Database Access

- **H2 Console**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## API Endpoints

### User Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/active` | Get all active users |
| GET | `/api/users/{id}` | Get user by ID |
| GET | `/api/users/username/{username}` | Get user by username |
| GET | `/api/users/email/{email}` | Get user by email |
| POST | `/api/users` | Create a new user |
| PUT | `/api/users/{id}` | Update an existing user |
| DELETE | `/api/users/{id}` | Delete user by ID |
| PUT | `/api/users/{id}/deactivate` | Deactivate user (soft delete) |
| PUT | `/api/users/{id}/activate` | Activate user |
| GET | `/api/users/search?q={searchTerm}` | Search users |
| GET | `/api/users/stats` | Get user statistics |
| GET | `/api/users/check/username/{username}` | Check if username exists |
| GET | `/api/users/check/email/{email}` | Check if email exists |

### Sample User JSON

```json
{
  "username": "john_doe",
  "email": "john.doe@example.com",
  "password": "password123",
  "firstName": "John",
  "lastName": "Doe",
  "isActive": true
}
```

## Project Structure

```
src/main/java/com/example/blogmanagement/
├── BlogManagementApplication.java          # Main application class
├── controller/
│   └── UserController.java                 # REST controller for users
├── service/
│   └── UserService.java                    # Business logic for users
├── repository/
│   └── UserRepository.java                 # Data access layer
├── model/
│   └── User.java                          # User entity
├── dto/
│   └── UserDTO.java                       # Data transfer object
├── config/
│   └── DataInitializer.java              # Sample data initialization
└── exception/
    └── GlobalExceptionHandler.java        # Global exception handling
```

## Sample Data

The application comes pre-loaded with sample users:

1. **john_doe** - john.doe@example.com (Active)
2. **jane_smith** - jane.smith@example.com (Active)
3. **mike_wilson** - mike.wilson@example.com (Active)
4. **sarah_brown** - sarah.brown@example.com (Active)
5. **alex_johnson** - alex.johnson@example.com (Inactive)

## Testing the API

You can test the API using tools like:
- **Postman**
- **curl**
- **Thunder Client** (VS Code extension)
- **REST Client** (VS Code extension)

### Example curl commands:

```bash
# Get all users
curl -X GET http://localhost:8080/api/users

# Create a new user
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "new_user",
    "email": "new.user@example.com",
    "password": "password123",
    "firstName": "New",
    "lastName": "User"
  }'

# Get user by ID
curl -X GET http://localhost:8080/api/users/1

# Update user
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "username": "updated_user",
    "email": "updated.user@example.com",
    "firstName": "Updated",
    "lastName": "User",
    "isActive": true
  }'

# Search users
curl -X GET "http://localhost:8080/api/users/search?q=john"

# Delete user
curl -X DELETE http://localhost:8080/api/users/1
```

## Future Enhancements

- Add Blog entity and related CRUD operations
- Implement user authentication and authorization
- Add pagination and sorting
- Implement proper password encryption
- Add unit and integration tests
- Add API documentation with Swagger/OpenAPI
