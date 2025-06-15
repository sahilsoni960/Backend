# Rest Assured API Testing Project

## Project Overview

This project aims to demonstrate comprehensive API testing using Java, Maven, Rest Assured, and JUnit. It covers various HTTP methods (GET, POST, PUT, DELETE) and showcases the use of Rest Assured utilities and functionalities for validating API responses.

## Requirements

### Technology Stack:

*   **Java**: Programming language.
*   **Maven**: Dependency management and build automation.
*   **Rest Assured**: A Java DSL for simplifying REST API testing.
*   **JUnit 5**: For writing and executing test cases.
*   **Optional: Mockito**: For mocking dependencies (if needed in advanced scenarios).

### Public APIs for Testing:

*   **OpenWeatherMap API**: (https://openweathermap.org/api) - _Note: API key might be required for some endpoints._
*   **JSONPlaceholder**: (https://jsonplaceholder.typicode.com/) - _Used for initial examples due to simplicity and no API key requirement._

### Functional Requirements:

*   Implement tests for all common HTTP methods:
    *   `GET`: Fetch data from the API.
    *   `POST`: Create new resources.
    *   `PUT`/`PATCH`: Update existing resources.
    *   `DELETE`: Remove resources.
*   Validate response status codes, headers, and body content.
*   Implement error handling and logging within tests.
*   Use assertions to verify responses effectively.

### Non-Functional Requirements:

*   **Clean Code**: Ensure the code is modular, readable, and follows best practices.
*   **Documentation**: Include comments and Javadoc for clarity.
*   **Exception Handling**: Implement proper exception handling in tests.

## Design

### Project Structure:

The project will adhere to the standard Maven project structure:

```
. RestAssured/
├── src/
│   ├── main/
│   │   └── java/                 # Application code (e.g., configurations, utilities)
│   └── test/
│       └── java/                 # Test cases
├── pom.xml                     # Maven project object model file
└── README.md                   # Project documentation
└── config.properties           # Configuration file for API base URLs and keys
```

### Classes and Packages:

*   `src/main/java/`
    *   `com.restassured.config.ConfigurationManager`: Manages loading properties from `config.properties`.
    *   `com.restassured.utils.ResponseUtils`: Utility class for common response assertions and extractions.
*   `src/test/java/`
    *   `com.restassured.endpoints.ApiEndpoints`: Defines API endpoint paths.
    *   `com.restassured.tests.BaseTest`: Base class for common test setup (e.g., Rest Assured setup).
    *   `com.restassured.tests.JsonPlaceholderTests`: Implement test cases for JSONPlaceholder API.
    *   `com.restassured.tests.OpenWeatherMapTests`: Implement test cases for OpenWeatherMap API.

### Configuration:

*   A `config.properties` file will manage API base URLs, API keys, and other environment-specific settings.

## Step-by-Step Procedure

1.  **Set Up Project**: Create a new Maven project and add necessary dependencies in `pom.xml`.
2.  **Configuration Management**: Implement a `ConfigurationManager` to read `config.properties`.
3.  **Define API Endpoints**: Create `ApiEndpoints` class to centralize endpoint paths.
4.  **Implement Utility Class**: Develop `ResponseUtils` for common response handling.
5.  **Implement Test Cases**: Write test classes (`JsonPlaceholderTests`, `OpenWeatherMapTests`) extending `BaseTest` for each API, covering GET, POST, PUT, DELETE methods.
6.  **Run Tests**: Execute tests via Maven or IDE.
7.  **Reporting**: Integrate a reporting mechanism (e.g., Allure Report) for comprehensive test results.
8.  **Error Handling & Logging**: Incorporate robust error handling and logging.
9.  **Review and Refactor**: Ensure code quality and maintainability.

## Plan

- [x] Create `README.md` with initial project overview, requirements, design, and step-by-step procedure.
- [x] Create Maven project structure.
- [x] Update `pom.xml` with Rest Assured and JUnit 5 dependencies.
- [x] Create `src/main/resources/config.properties`.
- [x] Create `com.restassured.config.ConfigurationManager.java`.
- [x] Create `com.restassured.endpoints.ApiEndpoints.java`.
- [x] Create `com.restassured.utils.ResponseUtils.java`.
- [x] Create `com.restassured.tests.BaseTest.java`.
- [x] Create `com.restassured.tests.JsonPlaceholderTests.java` for GET, POST, PUT, DELETE examples, and `com.restassured.tests.OpenWeatherMapTests.java`.
- [x] Investigate and add reporting mechanism (e.g., Allure).
- [x] Error Handling & Logging: Incorporate robust error handling and logging.
- [x] Review and Refactor: Ensure code quality and maintainability. 