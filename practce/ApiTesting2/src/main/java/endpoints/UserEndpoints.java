package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.Usermodel;

public class UserEndpoints {

	public static Response getUserlist() {
		Response response = RestAssured.given()
				.headers(
						
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseUri)
				.basePath(Routes.get_list)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		return response;	
	}
	
	
	public static Response getSingleUser(long id) {
		Response response = RestAssured.given()
				.headers(
						
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseUri)
				.basePath(Routes.get_single)
				.pathParam("id", id)
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
				.baseUri(Routes.baseUri)
				.basePath(Routes.post_user)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post();
		return response;	
	}
	
 
	public static Response updateUser(long id, Usermodel payload) {
		
		Response response = RestAssured.given()
				.headers(
						
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseUri)
				.basePath(Routes.put)
				.pathParam("id", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.put();
		return response;	
	}
	
	
	
	public static Response deleteUser(long id) {
		Response response = RestAssured.given()
				.headers(
						
						"Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseUri)
				.basePath(Routes.delete)
				.pathParam("id", id)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.delete();
		return response;	
	}
		
}









