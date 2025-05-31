package RestAssured.Basic;

import RestAssured.Basic.POJO.Example.MainResponse;
import RestAssured.Basic.POJO.SerializationDemo.Location;
import RestAssured.Basic.POJO.SerializationDemo.MainRequest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Day6POJOValidation {
    @Test
    public void ResponseValidation(){
        String body="{\n" +
                "  \"title\": \"Wireless Headphones\",\n" +
                "  \"description\": \"High-quality wireless headphones with noise cancellation.\",\n" +
                "  \"price\": 99.99,\n" +
                "  \"discountPercentage\": 10,\n" +
                "  \"rating\": 4.5,\n" +
                "  \"stock\": 50,\n" +
                "  \"brand\": \"AudioTech\",\n" +
                "  \"category\": \"electronics\",\n" +
                "  \"images\": [\n" +
                "    \"https://dummyjson.com/image/i/products/1/1.jpg\",\n" +
                "    \"https://dummyjson.com/image/i/products/1/2.jpg\"\n" +
                "  ]\n" +
                "}\n";
       MainResponse mainResponse= given()
                .baseUri("https://httpbin.org/anything")
                .contentType(ContentType.JSON)
                .body(body)
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
     given()
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
             .log()
             .all();
    }
}
