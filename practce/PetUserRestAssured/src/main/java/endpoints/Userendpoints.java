package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Usermodel;

public class Userendpoints {

    public static Response getSingleUserByUsername(String username) {
    	  Response response = RestAssured.given()
                  .headers(
                          "Content-Type",
                          ContentType.JSON,
                          "Accept",
                          ContentType.JSON)
                  .baseUri("https://petstore.swagger.io/v2/user/login")
                  .queryParam("username", username)
                  .contentType("application/json")
                  .accept(ContentType.JSON)
                  .when()
                  .get();
          return response;
    }

    public static Response loginUser(String username, String password) {
        Response response = RestAssured.given()
                .headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .baseUri("https://petstore.swagger.io/v2/user/login")
                .queryParam("username", username)
                .queryParam("password", password)
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .get();
        return response;
    }


    public static Response createUser(Usermodel payload) {
        Response response = RestAssured.given()
                .headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .baseUri(Routes.baseuri)
                .basePath(Routes.base_post)
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post();
        return response;
    }

    public static Response updateUser(Usermodel payload,String username) {
        Response response = RestAssured.given()
                .headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .baseUri(Routes.baseuri)
                .basePath(Routes.base_put) // Adjusted base path
                .pathParam("username", username) // Assuming username parameter here
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put();
        return response;
    }

    public static Response deleteUser(String username) {
        Response response = RestAssured.given()
                .headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .baseUri(Routes.baseuri)
                .basePath(Routes.base_delete) // Adjusted base path
                .pathParam("username", username) // Assuming username parameter here
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .delete();
        return response;
    }

}
