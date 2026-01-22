package com.example.tests;

import com.example.models.User;
import com.example.utils.Constants;
import com.example.utils.TestBase;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Response Body Validation Test Suite
 * Tests for validating response body structure and content
 */
@DisplayName("Response Body Validation Tests")
public class ResponseBodyTest extends TestBase {

    @Test
    @DisplayName("Verify response body contains array of 10 users")
    public void verifyResponseBodyContains10Users() {
        // Verify the response contains the expected number of users
        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Constants.USERS_ENDPOINT)
                .then()
                .body("size()", equalTo(Constants.EXPECTED_USERS_COUNT));
    }

    @Test
    @DisplayName("Verify response body can be deserialized to User array")
    public void verifyResponseBodyDeserializesToUserArray() {
        // Extract response as User array
        User[] users = RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Constants.USERS_ENDPOINT)
                .then()
                .extract()
                .as(User[].class);

        // Verify deserialization was successful
        assert users.length == Constants.EXPECTED_USERS_COUNT;
    }
}
