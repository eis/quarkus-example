package org.acme.hello;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingRestResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus"));
    }
    @Test
    public void test500Request() {
        given()
            .log().ifValidationFails()
            .when()
            .get("/500")
            .then()
            .log().ifValidationFails()
            .statusCode(SC_INTERNAL_SERVER_ERROR)
            .body(is("Internal error from Quarkus"));
    }
    @Test
    public void test400Request() {
        given()
            .log().ifValidationFails()
            .when()
            .get("/400")
            .then()
            .log().ifValidationFails()
            .statusCode(SC_BAD_REQUEST)
            .body(is("Bad request from Quarkus"));
    }

}