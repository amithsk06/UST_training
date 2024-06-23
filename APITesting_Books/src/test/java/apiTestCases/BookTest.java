package apiTestCases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import ust.com.endpoints.Endpoints;

@Listeners(utilities.ExtentReportManager.class)
public class BookTest {

	// testing the method getAllbooks and asserting the statuscode
	@Test(priority = 0)
	public void testGetAllbook() {
		Response response = Endpoints.getAllbooks();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// testing the method postbook and asserting the statuscode
	@Test(priority = 1)
	public void testPostbook() {
		Response response = Endpoints.postbook();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// testing the method putbook and asserting the statuscode
	@Test(priority = 2)
	public void testputbook() {
		Response response = Endpoints.putbook();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// testing the method deletebook and asserting the statuscode
	@Test(priority = 3)
	public void testdeletebook() {
		Response response = Endpoints.deletebook(3);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// testing the method getbookbyid and asserting the statuscode
	@Test(priority = 4)
	public void testgetbyidbook() {
		Response response = Endpoints.getbookbyid();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 5)
	public void schemavalidation() {
		String filepath = System.getProperty("user.dir") + "//src//test//resources//schema.json";
		
		Response response = Endpoints.getUser(1);
		response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(filepath)));

	}
	@Test(priority = 6)
	public void testSchemaValidation() {
		// Load JSON schema file
		File f = new File(System.getProperty("user.dir") + "/src/test/resources/Schema.json");
		// Validate schema for first 5 authors
		for (int i = 1; i <= 5; i++) {
			Response response = Endpoints.getUser(i);
			response.then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchema(f));
			System.out.println("--------------- " + i + " schema ------------");
		}
	}

}
