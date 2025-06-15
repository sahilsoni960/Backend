package com.restassured.tests;

import com.restassured.config.ConfigurationManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigurationManager.getProperty("jsonplaceholder.base.url");
        // You can add more common configurations here, e.g., authentication, logging

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigurationManager.getProperty("jsonplaceholder.base.url"))
                .build();
    }

    protected static RequestSpecification getRequestSpec() {
        return requestSpec;
    }
} 