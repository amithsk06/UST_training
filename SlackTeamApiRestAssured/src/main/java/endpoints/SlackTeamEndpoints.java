package endpoints;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.SlackTeamModel;

public class SlackTeamEndpoints {
	
//	Response method for get books list
	public static Response getlist() {
		Response response = RestAssured.given()
				.headers("Content-Type",
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
	
//	Response method for get single book
	public static Response getSingle(int id) {
		Response response = RestAssured.given()
				.headers("Content-Type",
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
	
//	Response method for create new book
	public static Response create(SlackTeamModel payload) {
		Response response = RestAssured.given()
				.headers("Content-Type",
						ContentType.JSON,
						"Accept",
						ContentType.JSON)
				.baseUri(Routes.baseUri)
				.basePath(Routes.post)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post();
		return response;	
	}

//	Response method for update a book details
	public static Response update(int id, SlackTeamModel payload) {
		
		Response response = RestAssured.given()
				.headers("Content-Type",
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
	
//	Response method for update a book details
	public static Response updatePartial(int id, SlackTeamModel payload) {
		
		Response response = RestAssured.given()
				.headers("Content-Type",
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
				.patch();
		return response;	
	}
	

//	Response method for delete a book
	public static Response delete(int id) {
		Response response = RestAssured.given()
			.headers("Content-Type",
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
