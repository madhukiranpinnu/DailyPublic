package RestAssured.Basic.Day9E2E;

import RestAssured.Basic.Day9E2E.POJOS.AddCart;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasKey;

public class EcommerceFlow {
    String token=null;
    String userId="";
    String productId=null;
    String productName="Product Name";
    String productAddedBy=userId;
    String productCategory="fashion";
    String productSubCategory="shirts";
    int productPrice=143;
    String productDescription="This is good as from RestAssured";
    String productFor="men";
    @Test(priority = 1)
    public void TokenGenerator(){
        HashMap hashMap=new HashMap<>();
        hashMap.put("userEmail","madhukiran819@gmail.com");
        hashMap.put("userPassword","Madhu@9939");
        RequestSpecification requestSpecification=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setBasePath("/api/ecom")
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .build();
        ResponseSpecification responseSpecification=new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectContentType(ContentType.JSON)
                .build();
        Response response=given()
                .spec(requestSpecification)
                .body(hashMap)
                .when()
                .post("/auth/login")
                .then()
                .spec(responseSpecification)
                .extract()
                .response();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(response.getTime()<3000);
        Assert.assertEquals(response.jsonPath().getString("message"),"Login Successfully");
        Assert.assertTrue(response.jsonPath().get("token")instanceof String);
        Assert.assertTrue(response.jsonPath().get("userId")instanceof String);
        token=response.jsonPath().getString("token");
        userId=response.jsonPath().getString("userId");
        assertThat(response.jsonPath().get(),allOf(
                hasKey("token"),
                hasKey("userId"),
                hasKey("message")
        ));
        Assert.assertEquals(response.getHeader("Connection"),"Keep-Alive");
        Assert.assertEquals(response.getHeader("X-Frame-Options"),"SAMEORIGIN");
    }
    @Test(priority = 2)
    public void createProduct(){
       RequestSpecification requestSpecification=new RequestSpecBuilder()
               .setContentType(ContentType.MULTIPART)
               .setBaseUri("https://rahulshettyacademy.com")
               .setBasePath("/api/ecom")
               .log(LogDetail.HEADERS)
               .log(LogDetail.URI)
               .build();
       ResponseSpecification responseSpecification=new ResponseSpecBuilder()
               .log(LogDetail.ALL)
               .expectContentType(ContentType.JSON)
               .expectStatusCode(201)
               .build();
      Response response= given()
               .spec(requestSpecification)
               .formParam("productName",productName)
               .formParam("productAddedBy",userId)
               .formParam("productCategory",productCategory)
               .formParam("productSubCategory",productSubCategory)
               .formParam("productPrice",productPrice)
               .formParam("productDescription",productDescription)
               .formParam("productFor",productFor)
               .multiPart("productImage",new File(System.getProperty("user.dir")+"/src/main/resources/Formdata/sc.png"))
               .header("Authorization",token)
               .when()
               .post("/product/add-product")
               .then()
               .spec(responseSpecification)
               .extract()
               .response();
      Assert.assertEquals(response.getStatusCode(),201);
      Assert.assertTrue(response.getTime()<4000);
      Assert.assertNotNull(response.getBody());
      Assert.assertEquals(response.getHeader("Connection"),"Keep-Alive");
      Assert.assertEquals(response.getHeader("X-Frame-Options"),"SAMEORIGIN");
      Assert.assertEquals(response.getHeader("Vary"),"Accept-Encoding");
      assertThat(response.jsonPath().get(),allOf(
              hasKey("productId")
              ,hasKey("message")
      ));
      productId=response.jsonPath().getString("productId");
      Assert.assertTrue(response.jsonPath().get("productId") instanceof  String);
      Assert.assertTrue(response.jsonPath().get("message") instanceof String);
      Assert.assertEquals(response.jsonPath().getString("message"),"Product Added Successfully");
    }
    @Test(priority = 3)
    private void addProductToCart(){
     RequestSpecification requestSpecification1=new RequestSpecBuilder()
             .log(LogDetail.ALL)
             .setContentType(ContentType.JSON)
             .setBaseUri("https://rahulshettyacademy.com")
             .setBasePath("/api/ecom/user")
             .addHeader("Authorization",token)
             .build();
     ResponseSpecification responseSpecification1=new ResponseSpecBuilder()
             .log(LogDetail.ALL)
             .expectContentType(ContentType.JSON)
             .expectHeader("Connection","Keep-Alive")
             .build();
        AddCart addCart=new AddCart();
        AddCart.Product product=new AddCart.Product();
        product.setProductAddedBy(userId);
        product.setProductDescription(productDescription);
        product.setProductCategory(productCategory);
        product.setProductFor(productFor);
        product.setProductSubCategory(productSubCategory);
        product.setId(productId);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setProductDescription(productDescription);
        product.setV(0);
        product.setProductStatus(true);
        product.setProductRating("0");
        product.setProductTotalOrders("0");
        product.setProductImage("https://rahulshettyacademy.com/api/ecom/uploads/productImage_1748880446052.png");
        addCart.setProduct(product);
        addCart.setId(userId);
     Response response=given()
             .spec(requestSpecification1)
             .body(addCart)
             .when()
             .post("/add-to-cart")
             .then()
             .spec(responseSpecification1)
             .extract()
             .response();
     Assert.assertEquals(response.getStatusCode(),200);
     Assert.assertNotNull(response.getBody());
     Assert.assertTrue(response.getTime()<4000);
     Assert.assertEquals(response.jsonPath().getString("message"),"Product Added To Cart");
    }
    @Test(priority = 4)
    public void Delete(){
        RequestSpecification deleteProdBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization", token).build();

        RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq).pathParam("productId",
                productId);

        String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}")
                .then().log().all().extract().response().asString();

        JsonPath js1 = new JsonPath(deleteProductResponse);

        Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
    }
    }

