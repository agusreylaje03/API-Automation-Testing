package com.example.tests;

import com.example.utils.Constants;
import com.example.utils.TestBase;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

@DisplayName("Status Code Validation Tests")
public class StatusCodeTest extends TestBase {

    @Test
    @DisplayName("Verify GET /users returns 200 OK status code")
    public void verifyStatusCodeIs200() {
        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Constants.USERS_ENDPOINT)
                .then()
                .statusCode(Constants.HTTP_OK);
    }
}
