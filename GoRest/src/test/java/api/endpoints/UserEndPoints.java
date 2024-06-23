package api.endpoints;



import api.payload.UserModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(UserModel payload) {
		Response response = RestAssured.given()
				.headers(
			              "Authorization",
			              "Bearer " + "befb29c71e41ed77e406ce735c6403a2b5c366340bef8f95ba1be9a26ada856b",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
						.baseUri(Routes.baseuri)
																.basePath(Routes.post_basePath)
																.contentType("application/json")
																.accept(ContentType.JSON)
																.body(payload)
															.when()
																.post();
		return response;	
	}
	public static Response getUser(long id) {
		Response response = RestAssured.given()
				.headers(
			              "Authorization",
			              "Bearer " + "befb29c71e41ed77e406ce735c6403a2b5c366340bef8f95ba1be9a26ada856b",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
																.baseUri(Routes.baseuri)
																.basePath(Routes.get_basePath)
																.pathParam("userid", id)
																.contentType("application/json")
																.accept(ContentType.JSON)
															.when()
																.get();
		return response;
	}
	public static Response deleteUser(long id) {
		Response response = RestAssured.given()
				.headers(
			              "Authorization",
			              "Bearer " + "befb29c71e41ed77e406ce735c6403a2b5c366340bef8f95ba1be9a26ada856b",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
																.baseUri(Routes.baseuri)
																.basePath(Routes.delete_basePath)
																.pathParam("userid", id)
																.contentType("application/json")
																.accept(ContentType.JSON)
															.when()
																.delete();
		return response;
	}
	public static Response updateUser(long id,UserModel payload) {
		Response response = RestAssured.given()
				.headers(
			              "Authorization",
			              "Bearer " + "befb29c71e41ed77e406ce735c6403a2b5c366340bef8f95ba1be9a26ada856b",
			              "Content-Type",
			              ContentType.JSON,
			              "Accept",
			              ContentType.JSON)
																.baseUri(Routes.baseuri)
																.basePath(Routes.update_basePath)
																.pathParam("userid", id)
																.contentType("application/json")
																.accept(ContentType.JSON)
								       							.body(payload)
															.when()
																.put();
		return response;
	}
}
