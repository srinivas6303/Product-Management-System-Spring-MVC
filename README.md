# Product Management System (PMS) - Spring MVC

A simple Product Management System built using Spring MVC framework. This application allows users to manage products by adding, retrieving, updating, and deleting product information.

## Introduction

This project is a basic implementation of a Product Management System using Spring MVC. It provides a user interface to perform CRUD (Create, Read, Update, Delete) operations on products. 
The product information is stored in a database, and the application uses Spring Data JPA to interact with the database.

## Features

*   **Add Product:** Allows users to add new products to the system.
*   **View All Products:** Displays a list of all products stored in the system.
*   **Get Product by Name:** Retrieves product(s) based on the provided name.
*   **Get Product by Place:** Retrieves product(s) located in a specific place.
*   **Find Products by Substring:** Searches for products whose name, type, or place contains the given substring.
*   **Out of Warranty Products:** Finds products whose warranty has expired based on the provided year.
*   **Update Product:** Updates the details of an existing product.
*   **Delete Product by Name:** Deletes a product based on its name.
*   **Delete All Products:** Deletes all products from the system.

*   
## Dependencies
The following dependencies are required to run this application.  This section reflects the dependencies as specified in your `pom.xml` file:

*   **Spring Boot Starter Web:** Provides essential web development dependencies, including Spring MVC.
*   **Spring Boot Starter Data JPA:** Provides the necessary dependencies to use Spring Data JPA for database interaction.
*   **MySQL Connector/J:**  MySQL JDBC driver.
*   **Tomcat Jasper:** For JSP view resolution.
*   **Spring Boot Starter Test:** For writing unit and integration tests.


## Classes and Interfaces
Here's a brief overview of the classes and interfaces in this project:

*   **`PmsSpringMvcApplication`**: The main Spring Boot application class.
*   **`Product`**: Represents the product entity with attributes like name, type, place, and warranty.
*   **`ProductDB`**: A Spring Data JPA repository interface for performing database operations on the `Product` entity.  Extends `JpaRepository<Product, Integer>`.
*   **`ProductServices`**: A service class that contains the business logic for managing products.  It uses the `ProductDB` repository to interact with the database.
*   **`ProductController`**: A Spring MVC controller class that handles HTTP requests and responses for product-related operations.

## Setup

1.  **Clone the repository:**

    ```
    git clone <repository-url>
    cd PMS_SPRING_MVC
    ```

2.  **Build the project using Maven:**

    ```
    mvn clean install
    ```

3.  **Run the application:**

    ```
    mvn spring-boot:run
    ```

    The application will be accessible at `http://localhost:8080`.

## Usage

1.  Open your web browser and navigate to `http://localhost:8080`.
2.  Use the provided forms to perform various product management operations such as adding, viewing, updating, and deleting products.


