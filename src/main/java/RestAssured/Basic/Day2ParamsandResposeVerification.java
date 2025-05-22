package RestAssured.Basic;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class Day2ParamsandResposeVerification {
    @Test
    public void QueryParam(){
        given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .basePath("/api/users")
                .queryParam("page",2)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all();
    }
    @Test
    public void Pathparam(){
        given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .basePath("/api/users/{id}")
                .pathParam("id",3)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all();
    }
    @Test
    public void logHeaders(){
        given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .basePath("/api/users/{id}")
                .pathParam("id",3)
                .log()
                .headers()
                .when()
                .get()
                .then()
                .log()
                .headers();
    }
    @Test
    public void logBody(){
        given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .basePath("/api/users/{id}")
                .pathParam("id",3)
                .log()
                .body()
                .when()
                .get()
                .then()
                .log()
                .body();
    }
    @Test
    public void ResponseValidation(){
       Response response= given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .basePath("/api/users/{id}")
                .pathParam("id",3)
                .when()
                .get();
        Assert.assertEquals(response.jsonPath().getString("data.email"),"emma.wong@reqres.in");
        Assert.assertEquals(response.jsonPath().getString("data.first_name"),"Emma");
        Assert.assertEquals(response.jsonPath().getInt("data.id"),3);
        Assert.assertEquals(response.jsonPath().getString("data.last_name"),"Wong");
        Assert.assertEquals(response.jsonPath().getString("data.avatar"),"https://reqres.in/img/faces/3-image.jpg");
        Assert.assertEquals(response.jsonPath().getString("support.url"),"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        Assert.assertEquals(response.jsonPath().getString("support.text"),"Tired of writing endless social media content? Let Content Caddy generate it for you.");
        assertThat(response.jsonPath().get("data"),allOf(
                hasKey("id"),
                hasKey("email"),
                hasKey("first_name"),
                hasKey("last_name"),
                hasKey("avatar")
        ));
        assertThat(response.jsonPath().get("support"),allOf(
                hasKey("url"),
                hasKey("text")
        ));
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)<1300);
        Assert.assertTrue(response.jsonPath().get("data.id") instanceof Integer);
        Assert.assertTrue(response.jsonPath().get("data.first_name") instanceof String);
        Assert.assertTrue(response.jsonPath().get("data.last_name") instanceof String);
        Assert.assertTrue(response.jsonPath().get("data.email") instanceof String);
        Assert.assertTrue(response.jsonPath().get("data.avatar") instanceof String);
        Assert.assertTrue(response.jsonPath().get("support.text") instanceof String);
        Assert.assertTrue(response.jsonPath().get("support.url") instanceof String);
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
        Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
        Assert.assertEquals(response.getHeader("Server"),"cloudflare");
    }
    @Test
    public void SchemaValidator(){
        given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .basePath("/api/users/{id}")
                .pathParam("id",3)
                .when()
                .get()
                .then()
                .assertThat().
                body(matchesJsonSchemaInClasspath("schemas.day2-1.json"));
    }
}
