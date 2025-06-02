package RestAssured.Basic.Day8GraphQL;

import RestAssured.Basic.Day8GraphQL.Mutation.Response1;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class MutationExamples {
    @Test
    public void CreateLocation(){
        RequestSpecification requestSpecification1=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/gq/graphql")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        ResponseSpecification responseSpecification1=new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .build();
        Response response=given()
                .spec(requestSpecification1)
                .body("{\"query\":\"mutation{\\n  createLocation(location: {\\n    name:\\\"MadhuPur\\\",\\n    type:\\\"Hub\\\",\\n    dimension:\\\"Area 31\\\"\\n  }){\\n    id\\n  }\\n}\",\"variables\":null}")
                .when()
                .post()
                .then()
                .spec(responseSpecification1)
                .extract()
                .response();
        Response1 response1=response.as(Response1.class);
        System.out.println(response1.getData().getCreateLocation().getId());
    }
    @Test
    public void MultipleRequests(){
        RequestSpecification requestSpecification1=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/gq/graphql")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        ResponseSpecification responseSpecification1=new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .build();
        Response response=given()
                .spec(requestSpecification1)
                .body("{\"query\":\"mutation{\\n  createLocation(location: {\\n    name:\\\"MadhuPur\\\",\\n    type:\\\"Hub\\\",\\n    dimension:\\\"Area 31\\\"\\n  }){\\n    id\\n  }\\n  createCharacter(character:{\\n    name:\\\"Madhu\\\",\\n    type:\\\"HERO\\\",\\n    status:\\\"Strong\\\",\\n    species:\\\"Lion\\\",\\n    gender:\\\"male\\\",\\n    image:\\\"Sai.png\\\",\\n    originId:21471,\\n    locationId:21471\\n  } )\\n  {\\n    id\\n  }\\n  createEpisode(episode:{\\n    name:\\\"Hero of all time\\\",\\n    air_date:\\\"19-09-1998\\\",\\n    episode:\\\"SHaZM\\\"\\n  })\\n  {\\n    id \\n  }\\n\\n}\",\"variables\":null}")
                .when()
                .post()
                .then()
                .spec(responseSpecification1)
                .extract()
                .response();
        System.out.println(response.getStatusCode());
        System.out.println(response.jsonPath().getInt("data.createLocation.id"));
        System.out.println(response.jsonPath().getInt("data.createCharacter.id"));
        System.out.println(response.jsonPath().getInt("data.createEpisode.id"));

    }
}
