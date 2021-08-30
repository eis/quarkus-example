package org.acme.hello;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class GreetingQuteResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .accept(ContentType.HTML)
            .header(new Header("User-Agent","Rest-Assured"))
            .log().ifValidationFails()
            .when()
            .get("/")
            .then()
            .log().ifValidationFails()
            .statusCode(SC_OK)
            .body("html.head.title",
                    equalTo("Greetings"))
            .body("html.body.div.div.h2.span",
                    equalTo("Hello, Rest-Assured!") );

    }
}