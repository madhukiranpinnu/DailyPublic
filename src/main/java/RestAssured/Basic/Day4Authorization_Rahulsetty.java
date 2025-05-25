package RestAssured.Basic;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Day4Authorization_Rahulsetty {
    String token=null;
    @Test(priority = 1)
    public void getAccessToken(){
      Response response=  given()
                .baseUri("https://rahulshettyacademy.com/oauthapi")
                .basePath("/oauth2/resourceOwner")
                .multiPart("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParam("grant_type","client_credentials")
                .formParam("scope","trust")
                .contentType(ContentType.MULTIPART)
                .log()
                .all()
                .when()
                .post("/token")
                .then()
                .log()
                .all()
                .extract()
                .response();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getTime()<3000);
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
        Assert.assertEquals(response.getHeader("Connection"),"Keep-Alive");
        Assert.assertEquals(response.jsonPath().getString("token_type"),"Bearer");
        Assert.assertEquals(response.jsonPath().getString("scope"),"create");
        assertThat(response.jsonPath().get(),allOf(
                hasKey("access_token"),
                hasKey("token_type"),
                hasKey("expires_in"),
                hasKey("refresh_token"),
                hasKey("scope")
        ));
        token=response.jsonPath().getString("access_token");
    }
    @Test(priority = 2)
    public void GetDetails(){
        Response response=given()
                .baseUri("https://rahulshettyacademy.com/oauthapi")
                .basePath("/getCourseDetails")
                .queryParam("access_token",token)
                .log()
                .all()
                .when()
                .get()
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}
