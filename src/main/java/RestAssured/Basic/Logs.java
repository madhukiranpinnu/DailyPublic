package RestAssured.Basic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Logs {
    @Test
    public void LogsALL(){
        given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("x-api-key","reqres-free-v1")
                .log()
                .all()
                .when()
                .get("/users/2")
                .then()
                .log()
                .all();
    }
    @Test
    public void LogHeaders(){
        given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("x-api-key","reqres-free-v1")
                .log()
                .headers()
                .when()
                .get("/users/2")
                .then()
                .log()
                .headers();
    }
    @Test
    public void LogBody(){
        given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("x-api-key","reqres-free-v1")
                .when()
                .get("/users/2")
                .then()
                .log()
                .body();
    }
    @Test
    public void LogStatus(){
        given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("x-api-key","reqres-free-v1")
                .when()
                .get("/users/2")
                .then()
                .log()
                .status();
    }
}
