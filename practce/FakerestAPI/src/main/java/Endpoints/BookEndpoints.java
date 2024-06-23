package Endpoints;

import Payload.Book_modal;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookEndpoints {

	public static Response createUser(Book_modal payload) {	
		RestAssured.useRelaxedHTTPSValidation();
		Response response=RestAssured.given()
							.baseUri(Routes.baseuri)
							.basePath(Routes.post_basePath)
							.contentType("application/json")
							.accept(ContentType.JSON)
							.body(payload)
							.when()
							.post();
		
		return response;
		
	}
	public static Response getAlluser() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response=RestAssured.given()
				.baseUri(Routes.baseuri)
				.basePath(Routes.get_basePath)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.get();
		
		return response;
	}
	
	public static Response getUser(long id) {
		RestAssured.useRelaxedHTTPSValidation();
		Response response=RestAssured.given()
							.baseUri(Routes.baseuri)
							.basePath(Routes.getUnique_basePath)
							.pathParam("bid", id)
							.contentType("application/json")
							.accept(ContentType.JSON)
							.when()
							.get();
		return response;
	}
	public static Response deleteUser(long id) {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
							.baseUri(Routes.baseuri)
							.basePath(Routes.delete_basePath)
							.pathParam("bid", id)
							.contentType("application/json")
							.accept(ContentType.JSON)
							.when()
							.delete();
		return response;
	}
	public static Response updateUser(long id,Book_modal payload) {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
							.baseUri(Routes.baseuri)
							.basePath(Routes.update_basePath)
							.pathParam("bid", id)
							.contentType("application/json")
							.accept(ContentType.JSON)
							.body(payload)
							.when()
							.put();
		return response;
	}
}
