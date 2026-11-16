package org.example.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.ws.rs.core.Request;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class postAPI {
    protected String apiURL = "";
    Response response ;

    public postAPI(String apiName, String jsonPath) throws IOException {

       String baseURL = propertyUtil.getProperty("baseUrl");
       String resourceName = propertyUtil.getProperty(apiName);
       apiURL = baseURL + resourceName;
       String jPath = propertyUtil.getProperty(jsonPath);

       //Request specification
        String jsonPayload = jsonUtil.getJson(jPath);
        System.out.println(jsonPayload);

        RequestSpecification rs = new RequestSpecBuilder().setBaseUri(baseURL)
                .setContentType(ContentType.JSON).build();
        RequestSpecification req = given().log().all().spec(rs).body(jsonPayload);

        response = req.when().post(apiURL)
                .then().statusCode(200).extract().response();
    }

    public Response getResponse()
    {
        return response;
    }
}
