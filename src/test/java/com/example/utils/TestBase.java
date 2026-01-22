package com.example.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

/**
 * Base Test Class
 * Provides common setup and configuration for all test classes
 */
public class TestBase {

    protected static RequestSpecification requestSpec;

    /**
     * Setup method executed once before all tests
     * Configures RestAssured with base URI and default headers
     */
    @BeforeAll
    public static void setup() {
        // Build request specification with common settings
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Constants.BASE_URL)
                .setContentType("application/json")
                .build();

        // Set as default specification for all requests
        RestAssured.requestSpecification = requestSpec;
    }
}
