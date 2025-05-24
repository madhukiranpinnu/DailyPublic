package RestAssured.Basic;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class RequestsDay1 {
    @Test
    public void get(){
       Response response= given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api/users/2")
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
               .body(matchesJsonSchemaInClasspath("Day1Get.json"))
               .extract()
               .response();
       //Validate the Status code:
        Assert.assertEquals(response.getStatusCode(),200);
        //Validate the Response time
        Assert.assertTrue(response.getTime()<2500);
        //To get time in milliseconds
        Assert.assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)<1500);
        //Validate Response Body is not null
        Assert.assertNotNull(response.getBody());
        //To validate the Size\
        Map map=response.jsonPath().get("data");
        Assert.assertEquals(map.size(),5);
        Map map1=response.jsonPath().get("support");
        Assert.assertEquals(map1.size(),2);
        //To validate the headers
        //To validate the integer
        Assert.assertEquals(response.jsonPath().getInt("data.id"),2);
        //To validate the String
        Assert.assertEquals(response.jsonPath().getString("data.email"),"janet.weaver@reqres.in");
        Assert.assertEquals(response.jsonPath().getString("data.first_name"),"Janet");
        Assert.assertEquals(response.jsonPath().getString("data.last_name"),"Weaver");
        Assert.assertEquals(response.jsonPath().getString("data.avatar"),"https://reqres.in/img/faces/2-image.jpg");
        Assert.assertEquals(response.jsonPath().getString("support.url"),"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral");
        Assert.assertEquals(response.jsonPath().getString("support.text"),"Tired of writing endless social media content? Let Content Caddy generate it for you.");
        //Partial matching of content
        Assert.assertTrue(response.jsonPath().getString("data.email").contains("@reqres.in"));
        Assert.assertTrue(response.jsonPath().getString("support.url").contains("https"));
        Assert.assertTrue(response.jsonPath().getString("support.text").contains("Tired"));
        //To validate the datatype of specific attribute
        //To validate the integer
        Assert.assertTrue(response.jsonPath().get("data.id") instanceof Integer);
        Assert.assertTrue(response.jsonPath().get("data.email") instanceof String);
        Assert.assertTrue(response.jsonPath().get("data.first_name")instanceof String);
        Assert.assertTrue(response.jsonPath().get("data.last_name")instanceof String);
        Assert.assertTrue(response.jsonPath().get("data.avatar") instanceof String);
        Assert.assertTrue(response.jsonPath().get("support.url") instanceof String);
        Assert.assertTrue(response.jsonPath().get("support.text") instanceof String);
        //To validate all the attributes in response
        //Single key assertion
        assertThat(response.jsonPath().get("data"),allOf(
                hasKey("id")
        ));
        //multiple
        assertThat(response.jsonPath().get("data"),allOf(
                hasKey("id"),
                hasKey("email"),
                hasKey("first_name"),
                hasKey("last_name"),
                hasKey("avatar")
        ));
        //multiple
        assertThat(response.jsonPath().get("support"),allOf(
                hasKey("url"),
                hasKey("text")
        ));
    }
    @Test
    public void POST(){
        String body="{\n" +
                "  \"name\": \"Madhukiran\",\n" +
                "  \"job\": \"QA Engineer\"\n" +
                "}";
        Response response=given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .body(body)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post("/users")
                .then()
                .log()
                .all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Day1PostSchema.json"))
                .extract()
                .response();
        //To get Status code
        Assert.assertEquals(response.getStatusCode(),201);
        //To validate the response time
        Assert.assertTrue(response.getTime()<2000);
        Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS)<3);
        //To validate the headers
        //response
        Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
        Assert.assertEquals(response.getHeader("Server"),"cloudflare");
        Assert.assertEquals(response.getHeader("X-Powered-By"),"Express");
        //Gives header object from there we need to grab value
        Assert.assertEquals(response.getHeaders().get("Connection").getValue(),"keep-alive");

    }
    @Test
    public void Put(){
        String body="{\n" +
                "  \"name\": \"Madhukiran\",\n" +
                "  \"job\": \"QA Engineer\"\n" +
                "}";
       Response response= given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .body(body)
                .log()
                .all()
                .when()
                .put("/users/2")
                .then()
                .log()
                .all()
               .extract()
               .response();
       //To Validate Status code
        Assert.assertEquals(response.getStatusCode(),200);
        //To Validate Response time
        //In long
        Assert.assertTrue(response.getTime()<3000);
        //To validate in milliseconds
        Assert.assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)<3000);
        //To validate response is not null
        Assert.assertNotNull(response.getBody());
        //To validate headers
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
        Assert.assertEquals(response.getHeader("Server"),"cloudflare");
        Assert.assertEquals(response.getHeader("X-Powered-By"),"Express");
        //To validate the response body data
        Assert.assertEquals(response.jsonPath().getString("name"),"Madhukiran");
        Assert.assertEquals(response.jsonPath().getString("job"),"QA");
        //To validate the response partially
        Assert.assertTrue(response.jsonPath().getString("name").contains("Mad"));
        //To validate size
        Map map=response.jsonPath().get();
        Assert.assertEquals(map.size(),3);
        //To validate single key prescence
        assertThat(response.jsonPath().get(),allOf(
                hasKey("name")
        ));
        //To validate multiple keys
        assertThat(response.jsonPath().get(),allOf(
                hasKey("name"),
                hasKey("job"),
                hasKey("updatedAt")
        ));
        //To validate the datatype
        Assert.assertTrue(response.jsonPath().get("name") instanceof String);
        Assert.assertTrue(response.jsonPath().get("job") instanceof String);
        Assert.assertTrue(response.jsonPath().get("updatedAt") instanceof String);
    }
    @Test
    public void Patch(){
        String body="{\n" +
                "  \"job\": \"new\"\n" +
                "}";
        Response response=given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .body(body)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .patch("/users/2")
                .then()
                .body(matchesJsonSchemaInClasspath("Day1Put.json"))
                .log()
                .all()
                .extract()
                .response();
        //To validate the Response
        Assert.assertEquals(response.getStatusCode(),200);
        //Validate the response time
        Assert.assertTrue(response.getTime()<3000);
        //Validate in seconds
        Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS)<3);
        //To validate body is not null
        Assert.assertNotNull(response.getBody());
        //To validate the headers
        Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
        Assert.assertEquals(response.getHeader("Server"),"cloudflare");
        Assert.assertEquals(response.getHeader("X-Powered-By"),"Express");
        //To validate single header prescence
        assertThat(response.jsonPath().get(),allOf(
                hasKey("job")
        ));
        //To validate multiple headers prescence
        assertThat(response.jsonPath().get(),allOf(
                hasKey("job"),
                hasKey("updatedAt")
        ));
        //To validate the values
        Assert.assertEquals(response.jsonPath().getString("job"),"new");
        //to valiate the datatype
        Assert.assertTrue(response.jsonPath().get("job") instanceof String);
        Assert.assertTrue(response.jsonPath().get("updatedAt") instanceof String);
        //Size of response
        Map map=response.jsonPath().get();
        Assert.assertEquals(map.size(),2);
    }
    @Test
    public void Delete(){
       Response response= given()
                .header("x-api-key","reqres-free-v1")
                .baseUri("https://reqres.in/api")
                .log()
                .all()
                .when()
                .delete("/users/2")
                .then()
                .log()
                .all()
               .extract()
               .response();
        //Validate status code
        Assert.assertEquals(response.getStatusCode(),204);
        //Assert Time
        Assert.assertTrue(response.getTime()<3000);
    }
}
