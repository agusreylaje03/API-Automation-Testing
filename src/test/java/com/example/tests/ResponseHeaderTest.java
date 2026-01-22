package com.example.tests;

import com.example.utils.Constants;
import com.example.utils.TestBase;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Response Header Validation Test Suite
 * Tests for validating HTTP response headers
 */
@DisplayName("Response Header Validation Tests")
public class ResponseHeaderTest extends TestBase {

    @Test
    @DisplayName("Verify Content-Type header exists and has correct value")
    public void verifyContentTypeHeader() {
        // Verify Content-Type header is present and matches expected value
        RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get(Constants.USERS_ENDPOINT)
                .then()
                .header(Constants.CONTENT_TYPE_HEADER, notNullValue())
                .header(Constants.CONTENT_TYPE_HEADER, equalTo(Constants.EXPECTED_CONTENT_TYPE));
    }
}
