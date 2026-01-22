package com.example.utils;

/**
 * Constants Utility Class
 * Contains all constant values used across the test suite
 */
public final class Constants {
    // Prevent instantiation
    private Constants() {
        throw new UnsupportedOperationException("Utility class");
    }

    // API Configuration
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String USERS_ENDPOINT = "/users";

    // HTTP Headers
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String EXPECTED_CONTENT_TYPE = "application/json; charset=utf-8";

    // Expected Values
    public static final int EXPECTED_USERS_COUNT = 10;
    public static final int HTTP_OK = 200;
}
