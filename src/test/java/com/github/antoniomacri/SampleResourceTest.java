package com.github.antoniomacri;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Slf4j
@QuarkusTest
public class SampleResourceTest {

    @Test
    public void testProtectedResource() {

        // Content without required name member
        Content data = new Content();
        given()
                .auth().preemptive().basic("user", "userpwd")
                .accept(ContentType.JSON)
                .when()
                .contentType(ContentType.JSON)
                .body(data)
                .post("/protected")
                .then()
                .statusCode(400);
    }
}
