package com.restassured.tests;

import com.restassured.config.ConfigurationManager;
import com.restassured.endpoints.ApiEndpoints;
import com.restassured.utils.ResponseUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class OpenWeatherMapTests extends BaseTest {

    private static String openWeatherApiKey;
    private static RequestSpecification openWeatherRequestSpec;

    @BeforeAll
    public static void setupOpenWeather() {
        openWeatherApiKey = ConfigurationManager.getProperty("openweathermap.api.key");
        // Ensure the API key is not null or empty
        if (openWeatherApiKey == null || openWeatherApiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("OpenWeatherMap API key is not configured in config.properties");
        }

        openWeatherRequestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigurationManager.getProperty("openweathermap.base.url"))
                .build();
    }

    @Test
    @DisplayName("Get current weather by city name")
    void getCurrentWeatherByCityName() {
        String cityName = "London";

        Response response = given().spec(openWeatherRequestSpec)
                .queryParam("q", cityName)
                .queryParam("appid", openWeatherApiKey)
                .when()
                .get(ApiEndpoints.OPENWEATHER_CURRENT_WEATHER)
                .then()
                .extract().response();

        ResponseUtils.printResponseDetails(response);
        ResponseUtils.verifyStatusCode(response, 200);
        ResponseUtils.verifyContentType(response, "application/json");
        response.then().body("name", equalTo(cityName));
        response.then().body("main.temp", notNullValue());
        response.then().body("weather[0].description", notNullValue());
    }
} 