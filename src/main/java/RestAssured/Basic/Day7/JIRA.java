package RestAssured.Basic.Day7;

import RestAssured.Basic.POJO.JIRA.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JIRA {
    @Test
 public void Test(){
     Request request=new Request();
     Fields fields=new Fields();
     IssueType issueType=new IssueType();
     Project project=new Project();
     issueType.setName("Bug");
     fields.setDescription("Creating of an issue using project keys and issue type names using the REST API");
     fields.setSummary("REST ye merry gentlemen.");
     project.setKey("SCRUM");
     fields.setProject(project);
     fields.setIssueType(issueType);
     request.setFields(fields);
     RequestSpecification requestSpecification=new RequestSpecBuilder()
             .setBaseUri("https://mkptest939.atlassian.net")
             .setBasePath("/rest/api/2")
             .addHeader("Authorization", "Basic bWtwdGVzdDkzOUBnbWFpbC5jb206QVRBVFQzeEZmR0YwazV6ZWVTeEh1ekx0VnRvT2ViZzFCb0c2c1otaVJfLWE3SHRiUU9aQVRpbkthTWJEb3BtVjZaVHhieXRiZ2hPanFranhqdEZwMWxNeUVvNUU4SG4weE5rQy1kcHl0NjRMUmdpSEJXTjBwNnJxakFjcld3S2M3QmszeERIZmtzQlVKM05DbGN2ZE10TDlHWVFPb2VtOWJaN2dVU2FnSzF4b0JfV1BCaEx4cGFRPTk0QUU1MDBE")
             .setContentType(ContentType.JSON)
             .log(LogDetail.ALL)
             .build();
     ResponseSpecification responseSpecification=new ResponseSpecBuilder()
             .log(LogDetail.ALL)
             .build();
     ResponseJira responseJira= given()
             .spec(requestSpecification)
             .body(request)
             .when()
             .post("/issue")
             .then()
             .spec(responseSpecification)
             .extract()
             .response()
             .as(ResponseJira.class);
     System.out.println(responseJira.getId());
     System.out.println(responseJira.getSelf());
     System.out.println(responseJira.getKey());
 }
}
