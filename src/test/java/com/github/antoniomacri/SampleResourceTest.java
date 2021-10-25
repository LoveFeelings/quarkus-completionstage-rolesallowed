package com.github.antoniomacri;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Slf4j
@QuarkusTest
@TestHTTPEndpoint(SampleResource.class)
public class SampleResourceTest {

    @InjectMock
    SampleControl sampleControl;


    @Test
    public void testProtectedResource() {
        Mockito.doReturn(CompletableFuture.completedStage("{}"))
                .when(sampleControl).getProtected();

        given()
                .auth().preemptive().basic("user", "userpwd")
                .accept(ContentType.JSON)
                .when().get("/protected")
                .then()
                .statusCode(200)
                .body(is("{}"));
    }

    @Test
    public void testAnyUserResource() {
        Mockito.doReturn(CompletableFuture.completedStage("{}"))
                .when(sampleControl).getForAnyUser();

        given()
                .auth().preemptive().basic("user", "userpwd")
                .accept(ContentType.JSON)
                .when().get("/anyuser")
                .then()
                .statusCode(200)
                .body(is("{}"));
    }
}
