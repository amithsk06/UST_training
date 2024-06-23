package apiTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TrialTest {
	
	public static Response getAll() {
		Response response =RestAssured.given().baseUri("https://fakerestapi.azurewebsites.net/").basePath("/api/v1/Books")
				.when().get();
		return response;
	}
	
	@Test
	public void test1() {
		Response response =getAll();
		assertEquals(response.statusCode(), 200);
	}

}
