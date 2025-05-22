package RestAssured.Basic;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class RequestsDay1 {
    @Test
    public void get(){
        given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api/users/2")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all();
    }
    @Test
    public void POST(){
        String body="{\n" +
                "  \"name\": \"Madhukiran\",\n" +
                "  \"job\": \"QA Engineer\"\n" +
                "}";
        given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .body(body)
                .log()
                .all()
                .when()
                .post("/users")
                .then()
                .log()
                .all();
    }
    @Test
    public void Put(){
        String body="{\n" +
                "  \"name\": \"Madhukiran\",\n" +
                "  \"job\": \"QA Engineer\"\n" +
                "}";
        given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .body(body)
                .log()
                .all()
                .when()
                .put("/users/2")
                .then()
                .log()
                .all();
    }
    @Test
    public void Patch(){
        String body="{\n" +
                "  \"job\":QA" +
                "}";
        given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .body(body)
                .log()
                .all()
                .when()
                .patch("/users/2")
                .then()
                .log()
                .all();
    }
    @Test
    public void Delete(){
        given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .log()
                .all()
                .when()
                .delete("/users/2")
                .then()
                .log()
                .all();
    }
}
