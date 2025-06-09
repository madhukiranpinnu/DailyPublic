package RestAssured.Basic.Day11ExcelIntegration.Resources;

import RestAssured.Basic.Day8GraphQL.Mutation.Response1;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class LibraryAPI {
    @Test(dataProvider = "CreateLibrary",dataProviderClass = ExcelDataTest.class)
    public void PostData(HashMap<String,String> input){
        RequestSpecification requestSpecification1=new RequestSpecBuilder()
                .setBaseUri("http://216.10.245.166")
                        .setBasePath("Library/Addbook.php")
                                .log(LogDetail.ALL)
                                        .setContentType(ContentType.JSON)
                                                .build();
        ResponseSpecification responseSpecification1=new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .build();
        LibraryPostRequest libraryPostRequest=new LibraryPostRequest();
        libraryPostRequest.setIsbn(input.get("isbn"));
        libraryPostRequest.setName(input.get("name"));
        libraryPostRequest.setAuthor(input.get("author"));
        libraryPostRequest.setAisle(input.get("aisle"));
       Response response= given()
                .spec(requestSpecification1)
                .body(libraryPostRequest)
                .when()
                .post()
                .then()
                .spec(responseSpecification1)
                .extract()
                .response();
       Assert.assertEquals(response.getStatusCode(),200);
       Assert.assertNotNull(response.getBody());
       Assert.assertEquals(response.jsonPath().getString("Msg"),"successfully added");
       Assert.assertEquals(response.jsonPath().getString("ID"),input.get("isbn")+input.get("aisle"));
       Assert.assertEquals(response.getHeader("Connection"),"Keep-Alive");
       Assert.assertEquals(response.getHeader("Transfer-Encoding"),"chunked");
    }
}
