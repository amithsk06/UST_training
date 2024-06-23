package ust.com.endpoints;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Book_model;

public class Endpoints {
	// --method to get all books--//
	public static Response getAllbooks() {
//		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
													 .baseUri(Routes.baseuri)
													 .basePath(Routes.get_basePath)
													 .contentType("application/json")
													 .accept(ContentType.JSON)
													 .when()
													 .get();

		return response;
	}

	// ---method to post a book----//
	public static Response postbook() {
//		RestAssured.useRelaxedHTTPSValidation();
		File payload = new File(System.getProperty("user.dir") + "//src//test//resources//payload//postpayload.json");
		Response response = RestAssured.given()
													 .baseUri(Routes.baseuri)
													 .basePath(Routes.post_basePath)
													 .body(payload)
													 .contentType("application/json")
													 .accept(ContentType.JSON)
													 .when()
													 .post();

		return response;
	}

	// ----method to use put request----//
	public static Response putbook() {
	//	RestAssured.useRelaxedHTTPSValidation();
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
	public static Response deletebook(long id) {
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

	// --method to get a book by id----//(used headers)
	public static Response getbookbyid() {
//		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
												     .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
												     .baseUri(Routes.baseuri)
												     .basePath(Routes.getUnique_basePath)
												     .pathParam("bid", 1)
												     .contentType("application/json")
												     .accept(ContentType.JSON)
												     .when()
												     .get();

		return response;
	}
	

	// ---for using in dataprovider---//
	public static Response createBook(Book_model payload) {
//		RestAssured.useRelaxedHTTPSValidation();
		Response response = RestAssured.given()
													 .baseUri(Routes.baseuri)
													 .basePath(Routes.post_basePath)
													 .contentType("application/json")
													 .accept(ContentType.JSON)
													 .body(payload)
													 .when()
													 .post();

		return response;

	}
	//--for schema validation---//
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

}
