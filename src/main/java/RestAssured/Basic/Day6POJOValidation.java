package RestAssured.Basic;

import RestAssured.Basic.POJO.Deserialization.ResponseDemo;
import RestAssured.Basic.POJO.Example.Json;
import RestAssured.Basic.POJO.Example.MainResponse;
import RestAssured.Basic.POJO.Example3.RequestPojo;
import RestAssured.Basic.POJO.Example3.ResponsePojo;
import RestAssured.Basic.POJO.JIRA.*;
import RestAssured.Basic.POJO.SerializationDemo.Location;
import RestAssured.Basic.POJO.SerializationDemo.MainRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Day6POJOValidation {
    @Test
    public void ResponseValidation(){
        Json json=new Json();
        json.setTitle("Wireless Headphones");
        json.setDescription("High-quality wireless headphones with noise cancellation.");
        json.setPrice(99);
        json.setDiscountPercentage(10);
        json.setRating(4);
        json.setStock(50);
        json.setBrand("AudioTech");
        json.setCategory("electronics");
        List<String> images=new ArrayList<>();
        images.add("https://dummyjson.com/image/i/products/1/1.jpg");
        images.add("https://dummyjson.com/image/i/products/1/2.jpg");
        json.setImages(images);
       MainResponse mainResponse= given()
                .baseUri("https://httpbin.org/anything")
                .contentType(ContentType.JSON)
                .body(json)
                .log()
                .all()
                .when().post()
                .then()
                .log()
                .all()
                .extract()
                .response()
                .as(MainResponse.class);
        System.out.println(mainResponse.getJson().getBrand());
        System.out.println(mainResponse.getData());
    }
    @Test
    public void Serialization(){
        MainRequest mainRequest=new MainRequest();
        Location location=new Location();
        location.setLat(-23.456);
        location.setLng(23.567);
        mainRequest.setLocation(location);
        mainRequest.setAccuracy(50);
        mainRequest.setName("Frontline house");
        mainRequest.setPhone_number("(+91) 983 893 3937");
        mainRequest.setAddress("29, side layout, cohen 09");
        List<String> types=new ArrayList<>();
        types.add("shoe park");
        types.add("shop");
        mainRequest.setTypes(types);
        mainRequest.setWebsite("http://google.com");
        mainRequest.setLanguage("French-IN");
    ResponseDemo responseDemo= given()
             .baseUri("https://rahulshettyacademy.com")
             .basePath("/maps/api/place/add/json")
             .queryParam("key","qaclick123")
             .body(mainRequest)
             .contentType(ContentType.JSON)
             .log()
             .all()
             .when()
             .post()
             .then()
             .extract()
             .response()
             .as(ResponseDemo.class);
        System.out.println(responseDemo.getId());
        System.out.println(responseDemo.getStatus());
        System.out.println(responseDemo.getScope());
        System.out.println(responseDemo.getPlace_id());
    }
    @Test
    public void Data(){
        RequestPojo requestPojo=new RequestPojo();
        requestPojo.setName("Learn Appium Automation with Java");
        requestPojo.setAuthor("John foe");
        requestPojo.setAisle("227");
        requestPojo.setIsbn("bcd");
        ResponsePojo responsePojo=given()
                .contentType(ContentType.JSON)
                .body(requestPojo)
                .baseUri("http://216.10.245.166/Library/Addbook.php")
                .log()
                .all()
                .when()
                .post()
                .then()
                .extract()
                .response()
                .as(ResponsePojo.class);
        System.out.println(responsePojo.getID());
        System.out.println(responsePojo.getMsg());
    }
    @Test
    public void CreateBug(){
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
        ResponseJira responseJira= given()
                .baseUri("https://mkptest939.atlassian.net")
                .basePath("/rest/api/2")
                .header("Authorization",
                        "Basic bWtwdGVzdDkzOUBnbWFpbC5jb206QVRBVFQzeEZmR0YwazV6ZWVTeEh1ekx0VnRvT2ViZzFCb0c2c1otaVJfLWE3SHRiUU9aQVRpbkthTWJEb3BtVjZaVHhieXRiZ2hPanFranhqdEZwMWxNeUVvNUU4SG4weE5rQy1kcHl0NjRMUmdpSEJXTjBwNnJxakFjcld3S2M3QmszeERIZmtzQlVKM05DbGN2ZE10TDlHWVFPb2VtOWJaN2dVU2FnSzF4b0JfV1BCaEx4cGFRPTk0QUU1MDBE")
                .body(request)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .post("/issue")
                .then()
                .log()
                .all()
                .extract()
                .response()
                .as(ResponseJira.class);
        System.out.println(responseJira.getId());
        System.out.println(responseJira.getSelf());
        System.out.println(responseJira.getKey());
    }
}
