package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import org.testng.ITestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import endpoints.Routes;
import endpoints.UserEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Usermodel;
import utilities.ExtentReportsListener;

@Listeners(utilities.ExtentReportsListener.class)
public class UserTest{

	public Usermodel userPayload;
	
	
	@Test(priority=0)
	public void getSingleUser() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndpoints.getSingleUser(1);
		 response.then().log().all();
		 assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=1)
	public void getListUsers() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndpoints.getUserlist();
		response.then().log().all();
		 assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void deleteUser() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndpoints.deleteUser(2);
		response.then().log().all();
		 assertEquals(response.getStatusCode(), 204);
	}
	
	@Test(priority=3)
	public void postUser() {
		Usermodel userPayload1=new Usermodel();
		userPayload1=new Usermodel(21,"test",123,23,"");
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndpoints.createUser(userPayload1);
		response.then().log().all();
		 assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void putUser() {
		Usermodel userPayload2=new Usermodel();
		userPayload2=new Usermodel(21,"test",123,23,"");
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndpoints.updateUser(21, userPayload2);
		response.then().log().all();
		 assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	@Test(priority=5)
    public void schemavalidation() {
	 RestAssured.useRelaxedHTTPSValidation();
	    RestAssured.given()
	    .baseUri(Routes.baseUri)
		.basePath(Routes.baseUrii)
	        .when()
	        .get()
	        .then()
	        .assertThat()
	        .body(matchesJsonSchema(new File("C://Users\\268896//eclipse-workspace//practce//ApiTesting2//src//test//resources//payload//schema.json")));
	}
}
