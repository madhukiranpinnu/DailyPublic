package RestAssured.Basic.Day8GraphQL;

import RestAssured.Basic.Day8GraphQL.POJO.Multiple.GraphQLResponse.Response1;
import RestAssured.Basic.Day8GraphQL.POJO.Multiple.Query;
import RestAssured.Basic.Day8GraphQL.POJO.Multiple.Variables;
import RestAssured.Basic.Day8GraphQL.POJO.QuerySingle.Single;
import RestAssured.Basic.Day8GraphQL.TraverBlaze1.TravelResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RSGQLServer {
    @Test
    public void QuerySingle(){
        Single single=new Single();
        single.setQuery("query{character(characterId:6373){id}}");
        single.setVariables(null);
       Response response=given()
               .baseUri("https://rahulshettyacademy.com")
               .basePath("/gq/graphql")
               .header("Content-Type","application/json")
               .body(single)
               .log()
               .all()
               .when()
               .post()
               .then()
               .log()
               .all()
               .extract()
               .response();
       Assert.assertEquals(response.getStatusCode(),200);
       Assert.assertEquals(response.jsonPath().getInt("data.character.id"),6373);
       Assert.assertNotNull(response.getBody());
    }
    @Test
    public void MultipleQuery(){
        Query query=new Query();
        Variables variables=new Variables();
        variables.setCharet(6373);
        variables.setLoc(119);
        variables.setName("Ankur");
        query.setVariables(variables);
        query.setQuery("query($char:Int!,$loc:Int!,$name:String!){\n" +
                "  character(characterId:$char){\n" +
                "    id\n" +
                "    name\n" +
                "    type\n" +
                "    status\n" +
                "    species\n" +
                "    gender\n" +
                "    image\n" +
                "  }\n" +
                "  location(locationId:$loc){\n" +
                "    id\n" +
                "    name\n" +
                "    type\n" +
                "    dimension\n" +
                "  }\n" +
                "  characters(filters :{name :$name}){\n" +
                "    info{\n" +
                "      count\n" +
                "    }\n" +
                "  }\n" +
                "  locations(filters:{name: \"Ankur\"})\n" +
                "  {\n" +
                "    info{\n" +
                "      count\n" +
                "      pages\n" +
                "    }\n" +
                "  }\n" +
                "}");
        Response response=given()
                .baseUri("https://rahulshettyacademy.com")
                .basePath("/gq/graphql")
                .header("Content-Type","application/json")
                .body(query)
                .log()
                .all()
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .response();
        Response1 response1=response.as(Response1.class);
        System.out.println(response1.getData().getLocation().getId());
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void TravelBlaze(){
        RequestSpecification requestSpecification1=new RequestSpecBuilder()
                .setBaseUri("https://countries.trevorblades.com/")
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .setBody("{\"query\":\"query{\\n  country(code: \\\"IN\\\") {\\n    name\\n    native\\n    capital\\n    currency\\n    emoji\\n    phone\\n    continent{\\n      code\\n    }\\n  }\\n}\"}")
                .build();
        ResponseSpecification responseSpecification1=new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .build();
       Response response= given()
                .spec(requestSpecification1)
                .when()
                .post()
                .then()
                .spec(responseSpecification1)
                .extract()
                .response();
        TravelResponse travelResponse=response.as(TravelResponse.class);
        System.out.println(travelResponse.getData().getCountry().getCapital());
    }
    @Test
    public void CountryCodes(){
             RequestSpecification requestSpecification1=new RequestSpecBuilder()
                     .setBaseUri("https://countries.trevorblades.com/")
                     .log(LogDetail.ALL)
                     .setContentType(ContentType.JSON)
                     .setBody("{\"query\":\"query{\\n  continent(code:\\\"AS\\\"){\\n    code\\n    name\\n    countries{\\n      capital\\n      phone\\n      languages\\n      {\\n        code\\n        name\\n      }\\n    }\\n  }\\n  language(code: \\\"ps\\\")\\n  {\\n    code\\n    name\\n    native\\n    rtl\\n  }\\n}\"}")
                     .build();
             ResponseSpecification responseSpecification1=new ResponseSpecBuilder()
                     .log(LogDetail.ALL)
                     .expectContentType(ContentType.JSON)
                     .expectStatusCode(200)
                     .build();
            Response response= given()
                     .spec(requestSpecification1)
                     .when()
                     .post()
                     .then()
                     .spec(responseSpecification1)
                     .extract()
                     .response();
    }
}
