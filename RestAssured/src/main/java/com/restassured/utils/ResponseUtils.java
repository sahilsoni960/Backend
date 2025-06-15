package com.restassured.utils;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseUtils {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    public static void verifyStatusCode(Response response, int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode(), "Status code mismatch");
        logger.info("Status code verified: Expected {} , Actual {}", expectedStatusCode, response.getStatusCode());
    }

    public static void verifyContentType(Response response, String expectedContentType) {
        assertTrue(response.contentType().contains(expectedContentType), "Content type mismatch");
        logger.info("Content type verified: Expected {} , Actual {}", expectedContentType, response.contentType());
    }

    public static void verifyBodyContains(Response response, String expectedText) {
        assertTrue(response.asString().contains(expectedText), "Response body does not contain expected text");
        logger.info("Response body contains text: {}", expectedText);
    }

    public static <T> T getJsonPathValue(Response response, String path) {
        logger.debug("Extracting JSON path value for path: {}", path);
        return response.jsonPath().get(path);
    }

    public static void printResponseDetails(Response response) {
        logger.info("\n--- Response Details ---");
        logger.info("Status Code: {}", response.getStatusCode());
        logger.info("Status Line: {}", response.getStatusLine());
        logger.info("Content Type: {}", response.getContentType());
        logger.debug("Response Body:\n{}", response.asString()); // Use debug for full body to avoid clutter
        logger.info("------------------------");
    }
} 