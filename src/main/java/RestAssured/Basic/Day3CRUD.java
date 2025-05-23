package RestAssured.Basic;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Day3CRUD {
    String id=null;
    @Test(priority = 1)
    public void PostData(){
        String body="{\n" +
                "    \"id\": 189,\n" +
                "    \"name\": \"USERHERE736\",\n" +
                "    \"job\": \"JOBDONE4930\"\n" +
                "}";
       Response response= given()
                .baseUri("https://crudcrud.com/api")
                .basePath("/aa3f638172a04c89989174f4573fe6fb")
               .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .when()
                .post("/resources")
                .then().log()
                .all()
                .extract()
                .response();
         id=response.jsonPath().getString("_id");
        System.out.println(id);
    }
    @Test(priority = 2)
    public void getData(){
        given()
                .baseUri("https://crudcrud.com/api")
                .basePath("/aa3f638172a04c89989174f4573fe6fb")
                .log()
                .all()
                .when()
                .get("/resources")
                .then()
                .log()
                .all();
    }
    @Test(priority = 3)
    public void getSingle(){
        given().baseUri("https://crudcrud.com/api")
                .basePath("/aa3f638172a04c89989174f4573fe6fb")
                .log().all()
                .pathParam("id",id)
                .when().get("/resources/{id}")
                .then().log().all();
    }
    @Test(priority = 4)
    public void PUT(){
        String body="{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"USERHERE789\",\n" +
                "    \"job\": \"JOBDONE40\"\n" +
                "}";
        given()
                .baseUri("https://crudcrud.com/api")
                .basePath("/aa3f638172a04c89989174f4573fe6fb")
                .header("Content-Type","application/json")
                .body(body)
                .log().all()
                .pathParam("id",id)
                .when()
                .put("/resources/{id}")
                .then()
                .log()
                .all();
    }
    @Test(priority = 5)
    public void Delete(){
         given().baseUri("https://crudcrud.com/api")
                 .basePath("/aa3f638172a04c89989174f4573fe6fb")
                 .pathParam("id",id)
                 .log().all()
                 .when()
                 .delete("/resources/{id}")
                 .then()
                 .log().all();
    }
}
