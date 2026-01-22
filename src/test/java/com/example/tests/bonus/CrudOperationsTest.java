package com.example.tests;

import com.example.models.User;
import com.example.utils.Constants;
import com.example.utils.TestBase;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

/**
 * CRUD Operations Test Suite
 * Tests for Create, Read, Update and Delete operations on users endpoint
 */
@DisplayName("CRUD Operations Tests")
public class CrudOperationsTest extends TestBase {

    @Test
    @DisplayName("Create a new user - POST")
    public void createUser() {
        // Prepare new user data
        User newUser = new User();
        newUser.setName("John Doe");
        newUser.setUsername("johndoe");
        newUser.setEmail("john@example.com");

        // Send POST request and verify response
        RestAssured
                .given()
                .spec(requestSpec)
                .body(newUser)
                .when()
                .post(Constants.USERS_ENDPOINT)
                .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("username", equalTo("johndoe"))
                .body("email", equalTo("john@example.com"))
                .body("id", notNullValue());
    }

    @Test
    @DisplayName("Read a user - GET by ID")
    public void readUser() {
        // Get user by ID and verify response
        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Constants.USERS_ENDPOINT + "/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", notNullValue())
                .body("email", notNullValue());
    }

    @Test
    @DisplayName("Update a user - PUT")
    public void updateUser() {
        // Prepare updated user data
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setName("Jane Doe Updated");
        updatedUser.setUsername("janedoe");
        updatedUser.setEmail("jane.updated@example.com");

        // Send PUT request and verify updated data
        RestAssured
                .given()
                .spec(requestSpec)
                .body(updatedUser)
                .when()
                .put(Constants.USERS_ENDPOINT + "/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Jane Doe Updated"))
                .body("email", equalTo("jane.updated@example.com"));
    }

    @Test
    @DisplayName("Delete a user - DELETE")
    public void deleteUser() {
        // Delete user and verify successful response
        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .delete(Constants.USERS_ENDPOINT + "/1")
                .then()
                .statusCode(200);
    }
}
