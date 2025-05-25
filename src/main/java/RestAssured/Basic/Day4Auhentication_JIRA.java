package RestAssured.Basic;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class Day4Auhentication_JIRA {
    String jiraId=null;
    @Test
    public void BasicAuthentication(){
        String body="{\n" +
                "    \"fields\": {\n" +
                "       \"project\":\n" +
                "       {\n" +
                "          \"key\": \"SCRUM\"\n" +
                "       },\n" +
                "       \"summary\": \"Defect through Rest Assured Automation\",\n" +
                "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API with Automation\",\n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Bug\"\n" +
                "       }\n" +
                "   }\n" +
                "}\n";
     Response response= given()
               .baseUri("https://mkptest939.atlassian.net")
               .basePath("/rest/api/2")
               .header("Authorization",
                       "Basic bWtwdGVzdDkzOUBnbWFpbC5jb206QVRBVFQzeEZmR0YwazV6ZWVTeEh1ekx0VnRvT2ViZzFCb0c2c1otaVJfLWE3SHRiUU9aQVRpbkthTWJEb3BtVjZaVHhieXRiZ2hPanFranhqdEZwMWxNeUVvNUU4SG4weE5rQy1kcHl0NjRMUmdpSEJXTjBwNnJxakFjcld3S2M3QmszeERIZmtzQlVKM05DbGN2ZE10TDlHWVFPb2VtOWJaN2dVU2FnSzF4b0JfV1BCaEx4cGFRPTk0QUU1MDBE")
               .body(body)
               .contentType(ContentType.JSON)
               .log()
               .all()
               .when()
               .post("/issue")
               .then()
               .log()
               .all()
             .extract()
             .response();
        //To assert Status code
        Assert.assertEquals(response.getStatusCode(),201);
        //To assert Response Time
        Assert.assertTrue(response.getTime()<4000);
        //To validate the headers
        Assert.assertEquals(response.getHeader("Content-Type"),"application/json;charset=UTF-8");
        Assert.assertEquals(response.getHeader("Server"),"AtlassianEdge");
        Assert.assertEquals(response.getHeader("X-Cache"),"Miss from cloudfront");
        //To validate it has json body
        Assert.assertNotNull(response.getBody());
        //To Validate the single attribute prescence
        assertThat(response.jsonPath().get(),allOf(
                hasKey("id")
        ));
        assertThat(response.jsonPath().get(),allOf(
                hasKey("id"),
                hasKey("key"),
                hasKey("self")
        ));
        jiraId=response.jsonPath().getString("id");
        //Validate text partially
        Assert.assertTrue(response.jsonPath().getString("self").contains("https://mkptest939.atlassian.net/"));
    }
    @Test
    public void AddScreenshotToBug(){
        given()
                .baseUri("https://mkptest939.atlassian.net")
                .basePath("/rest/api/3/issue")
                .header("Authorization",
                        "Basic bWtwdGVzdDkzOUBnbWFpbC5jb206QVRBVFQzeEZmR0YwazV6ZWVTeEh1ekx0VnRvT2ViZzFCb0c2c1otaVJfLWE3SHRiUU9aQVRpbkthTWJEb3BtVjZaVHhieXRiZ2hPanFranhqdEZwMWxNeUVvNUU4SG4weE5rQy1kcHl0NjRMUmdpSEJXTjBwNnJxakFjcld3S2M3QmszeERIZmtzQlVKM05DbGN2ZE10TDlHWVFPb2VtOWJaN2dVU2FnSzF4b0JfV1BCaEx4cGFRPTk0QUU1MDBE")
                .header("X-Atlassian-Token","no-check")
                .multiPart("file",new File(System.getProperty("user.dir")+""))
                .log()
                .all()
                .when()
                .pathParam("jiraid",jiraId)
                .post("{jiraid}/attachments")
                .then()
                .log()
                .all();

    }
}
