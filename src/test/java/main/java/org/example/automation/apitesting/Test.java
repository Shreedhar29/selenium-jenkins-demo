package main.java.org.example.automation.apitesting;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Test {

    public void test(){
        User user = new User();
        user = User.builder().city("Jagaluru").build();
        RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("http://localhost:8080/")
                .addHeader("Content-Type", "application/json")
                .build();
      //  given().spec(reqSpec).body().when().get("/user").then().statusCode(200).log().all();
    }
}
