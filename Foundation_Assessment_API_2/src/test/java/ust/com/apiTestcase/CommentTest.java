package ust.com.apiTestcase;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import ust.com.endpoints.Endpoints;

@Listeners(ust.com.utilities.ExtentReportManager.class)
public class CommentTest {

	// testing the method getAllcomment and asserting the statuscode
	@Test(priority = 0)
	public void testGetAllComment() {
		Response response = Endpoints.getAllComment();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// testing the method postcomment and asserting the statuscode
	@Test(priority = 1)
	public void testPostComment() {
		Response response = Endpoints.postcomment();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	// testing the method putcomment and asserting the statuscode
	@Test(priority = 2)
	public void testputComment() {
		Response response = Endpoints.putcomment();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 3)
	public void testpatchComment() {
		Response response = Endpoints.patchcomment();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// testing the method deletecomment and asserting the statuscode
	@Test(priority = 4)
	public void testdeleteComment() {
		Response response = Endpoints.deletecomment();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
	}

	// testing the method getcommentbyid and asserting the statuscode
	@Test(priority = 5)
	public void testgetCommentbyid() {
		Response response = Endpoints.getcommentbyid();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 6)
	public void schemavalidation() {
		String filepath = System.getProperty("user.dir") + "//src//test//resources//schema.json";
		
		Response response = Endpoints.getComment(1);
		response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(filepath)));
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	@Test(priority = 7)
	public void testSchemaValidation() {
		// Load JSON schema file
		File f = new File(System.getProperty("user.dir") + "/src/test/resources/schema.json");
		// Validate schema for first 5 authors
		for (int i = 1; i <= 5; i++) {
			Response response = Endpoints.getComment(i);
			response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(f));
			System.out.println("--------------- " + i + " schema ------------");
		}
	}

}
