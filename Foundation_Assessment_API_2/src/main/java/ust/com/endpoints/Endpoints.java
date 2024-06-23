package ust.com.endpoints;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Endpoints {
	// --method to get all comments--//
	public static Response getAllComment() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
													 .baseUri(Routes.baseuri)
													 .basePath(Routes.get_basePath)
													 .contentType("application/json")
													 .accept(ContentType.JSON)
													 .when()
													 .get();

		return response;
	}
	
	// --method to get a comment by id----//(used headers)
		public static Response getcommentbyid() {
			RestAssured.useRelaxedHTTPSValidation();
			Response response = RestAssured.given()
													     .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
													     .baseUri(Routes.baseuri)
													     .basePath(Routes.getUnique_basePath)
													     .pathParam("id", 1)
													     .contentType("application/json")
													     .accept(ContentType.JSON)
													     .when()
													     .get();

			return response;
		}

	// ---method to post a comment ----//
	public static Response postcomment() {
		RestAssured.useRelaxedHTTPSValidation();
		File payload = new File(System.getProperty("user.dir") + "//src//test//resources//payload//postpayload.json");
		Response response = RestAssured.given()
													 .baseUri(Routes.baseuri)
													 .basePath(Routes.post_basePath) 
													 .body(payload)
													 .contentType("application/json")
													 .when()
													 .post();

		return response;
	}

	// ----method to use put request----//
	public static Response putcomment() {
		RestAssured.useRelaxedHTTPSValidation();
		File payload = new File(System.getProperty("user.dir") + "//src//test//resources//payload//putpayload.json");
		Response response = RestAssured.given()
												     .baseUri(Routes.baseuri)
												     .basePath(Routes.put_basePath)
												     .body(payload)
												     .contentType("application/json")
												     .accept(ContentType.JSON)
												     .when()
												     .put();

		return response;
	}

	// ----method to use delete request----//(with query parameters)
	public static Response deletecomment() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
													 .baseUri(Routes.baseuri)
													 .basePath(Routes.delete_basePath)
													 .contentType("application/json")
													 .accept(ContentType.JSON)
													 .when()
													 .delete();

		return response;
	}
	// ----method to use patch request----//
	public static Response patchcomment() {
		RestAssured.useRelaxedHTTPSValidation();
		File payload = new File(System.getProperty("user.dir") + "//src//test//resources//payload//patchpayload.json");
		Response response = RestAssured.given()
				.baseUri(Routes.baseuri)
				.basePath(Routes.delete_basePath)
				.body(payload)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.when()
				.patch();
		
		return response;
	}

	
	


	//--for schema validation---//
	public static Response getComment(long id) {
		RestAssured.useRelaxedHTTPSValidation();
		Response response=RestAssured.given()
							.baseUri(Routes.baseuri)
							.basePath(Routes.getUnique_basePath)
							.pathParam("id", id)
							.contentType("application/json")
							.accept(ContentType.JSON)
							.when()
							.get();
		return response;
	}

}
