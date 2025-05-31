package RestAssured.Basic.Day7;
import RestAssured.Basic.POJO.ReqresRequest.RequestPost;
import RestAssured.Basic.POJO.ReqresRequest.ResponsePost;
import RestAssured.Basic.POJO.ReqresRequest.RespsonseReqres;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RequestResponseSpecification {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    @BeforeTest
    public void BeforeTest(){
       requestSpecification=new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("/api")
                .addHeader("x-api-key","reqres-free-v1")
                .log(LogDetail.ALL)
                .build();
       responseSpecification=new ResponseSpecBuilder()
               .log(LogDetail.ALL)
               .build();
    }
    @Test
   public void Get(){
        RespsonseReqres responseReqres= given()
               .spec(requestSpecification)
               .pathParam("user",2)
               .when()
               .get("/users/{user}")
               .then()
               .spec(responseSpecification)
               .body(matchesJsonSchemaInClasspath("Day1Get.json"))
               .extract()
               .response()
                .as(RespsonseReqres.class);
        System.out.println(responseReqres.getData().getId());
        System.out.println(responseReqres.getSupport().getText());
        System.out.println(responseReqres.getData().getEmail());
        System.out.println(responseReqres.getData().getAvatar());
    }
    @Test
    public void POST(){
        RequestPost requestPost=new RequestPost();
        requestPost.setJob("QA");
        requestPost.setName("MAdhukiran");
        Response response=given()
                .spec(requestSpecification)
                .body(requestPost)
                .contentType(ContentType.JSON)
                .when()
                .post("/users")
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Day1PostSchema.json"))
                .extract()
                .response();
        ResponsePost responsePost=response.as(ResponsePost.class);
        System.out.println(responsePost.getJob());
        System.out.println(requestPost.getName());
        System.out.println(responsePost.getCreatedAt());
        System.out.println(responsePost.getId());
    }
}
