package com.restassured.tests;

import com.restassured.endpoints.ApiEndpoints;
import com.restassured.utils.ResponseUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderTests extends BaseTest {

    @Test
    @DisplayName("Get all posts")
    void getAllPosts() {
        Response response = given().spec(getRequestSpec())
                .when()
                .get(ApiEndpoints.JSONPLACEHOLDER_POSTS)
                .then()
                .extract().response();

        ResponseUtils.printResponseDetails(response);
        ResponseUtils.verifyStatusCode(response, 200);
        ResponseUtils.verifyContentType(response, "application/json");
        response.then().body("size()", greaterThan(0));
    }

    @Test
    @DisplayName("Get a single post by ID")
    void getPostById() {
        int postId = 1;
        Response response = given().spec(getRequestSpec())
                .pathParam("id", postId)
                .when()
                .get(ApiEndpoints.JSONPLACEHOLDER_POST_BY_ID)
                .then()
                .extract().response();

        ResponseUtils.printResponseDetails(response);
        ResponseUtils.verifyStatusCode(response, 200);
        ResponseUtils.verifyContentType(response, "application/json");
        response.then().body("id", equalTo(postId));
        response.then().body("title", notNullValue());
    }

    @Test
    @DisplayName("Create a new post")
    void createNewPost() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("title", "foo");
        newPost.put("body", "bar");
        newPost.put("userId", 1);

        Response response = given().spec(getRequestSpec())
                .contentType("application/json")
                .body(newPost)
                .when()
                .post(ApiEndpoints.JSONPLACEHOLDER_POSTS)
                .then()
                .extract().response();

        ResponseUtils.printResponseDetails(response);
        ResponseUtils.verifyStatusCode(response, 201);
        ResponseUtils.verifyContentType(response, "application/json");
        response.then().body("id", notNullValue());
        response.then().body("title", equalTo("foo"));
        response.then().body("body", equalTo("bar"));
    }

    @Test
    @DisplayName("Update an existing post")
    void updateExistingPost() {
        int postId = 1;
        Map<String, Object> updatedPost = new HashMap<>();
        updatedPost.put("id", postId);
        updatedPost.put("title", "updated title");
        updatedPost.put("body", "updated body");
        updatedPost.put("userId", 1);

        Response response = given().spec(getRequestSpec())
                .contentType("application/json")
                .pathParam("id", postId)
                .body(updatedPost)
                .when()
                .put(ApiEndpoints.JSONPLACEHOLDER_POST_BY_ID)
                .then()
                .extract().response();

        ResponseUtils.printResponseDetails(response);
        ResponseUtils.verifyStatusCode(response, 200);
        ResponseUtils.verifyContentType(response, "application/json");
        response.then().body("id", equalTo(postId));
        response.then().body("title", equalTo("updated title"));
    }

    @Test
    @DisplayName("Delete a post")
    void deletePost() {
        int postId = 1;
        Response response = given().spec(getRequestSpec())
                .pathParam("id", postId)
                .when()
                .delete(ApiEndpoints.JSONPLACEHOLDER_POST_BY_ID)
                .then()
                .extract().response();

        ResponseUtils.printResponseDetails(response);
        ResponseUtils.verifyStatusCode(response, 200);
        // Jsonplaceholder returns an empty JSON object for a successful delete, not an empty body.
        // So, we'll check for an empty body, which will be ' {}'.
        response.then().body(equalTo("{}"));
    }
} 