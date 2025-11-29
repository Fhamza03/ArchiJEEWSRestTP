
import fr.ubo.hello.bean.Greeting;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GreetingServiceTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "";
    }


    @Test
    void testGreeting() {
        given().header("Accept", "application/json")
                .when().get("/greeting")
                .then().statusCode(200)
                .body("message", equalTo("name est obligatoire. Merci de le renseigner."))
                .body("auteur", equalTo("Hamza FELLAH"));
    }

    @Test
    void testGreetingPath() {
        given().header("Accept", "application/json")
                .when().get("/greeting/Hamza")
                .then().statusCode(200)
                .body("message", equalTo("Hello, Hamza"))
                .body("auteur", equalTo("Hamza FELLAH"));
    }

    @Test
    void testGreeting2Default() {
        given().header("Accept", "application/json")
                .when().get("/greeting2")
                .then().statusCode(200)
                .body("message", equalTo("Hello, world"))
                .body("auteur", equalTo("Hamza FELLAH"));
    }

    @Test
    void testGreeting2WithName() {
        given().header("Accept", "application/json")
                .when().get("/greeting2?name=Hamza")
                .then().statusCode(200)
                .body("message", equalTo("Hello, Hamza"))
                .body("auteur", equalTo("Hamza FELLAH"));
    }

    @Test
    void testGreeting3() {
        given().header("Accept", "application/json")
                .when().get("/greeting3?name=Hamza")
                .then().statusCode(200)
                .body("message", equalTo("Hello, Hamza"))
                .body("auteur", equalTo("Hamza FELLAH"));
    }
}
