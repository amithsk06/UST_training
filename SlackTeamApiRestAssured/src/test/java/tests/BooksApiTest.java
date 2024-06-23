package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import endpoints.Routes;
import endpoints.SlackTeamEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.SlackTeamModel;

@Listeners(base.ExtentReportManager.class)
public class BooksApiTest {
	
//	public SlactTeamModel team;
	
//	@BeforeClass
//	public void setup() {
//		team=new SlactTeamModel(3);
//	}
//	
//	Test method for get single book
	@Test(priority=1)
	public void getSingleBook() {
		RestAssured.useRelaxedHTTPSValidation();
		SlackTeamModel team=new SlackTeamModel(4);
		Response response=SlackTeamEndpoints.getSingle(team.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);

	}
	
//	Test method for get books list
	@Test(priority=2)
	public void getAllBooks() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response=SlackTeamEndpoints.getlist();
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	
//	Test method for post a book
	@Test(priority=3)
	public void postBook() {
		RestAssured.useRelaxedHTTPSValidation();
		SlackTeamModel team1=new SlackTeamModel("abcd","xyz","abc@gmail.com","ardtjfkg");
		Response response=SlackTeamEndpoints.create(team1);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	
	
//	Test method for update a book
	@Test(priority=5)
	public void putBook() {
		RestAssured.useRelaxedHTTPSValidation();
		SlackTeamModel team=new SlackTeamModel("tom","chandler","tomchandler@gmail.com","lastshipss");
		Response response=SlackTeamEndpoints.update(252, team);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	
//	Test method for update a book
	@Test(priority=5)
	public void patchBook() {
		RestAssured.useRelaxedHTTPSValidation();
		SlackTeamModel team=new SlackTeamModel("tom","chandler","tomchandler145@gmail.com","lastship");
		Response response=SlackTeamEndpoints.update(252, team);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	
//	Test method for delete a book
	@Test(priority=6)
	public void deleteBook() {
		RestAssured.useRelaxedHTTPSValidation();
		SlackTeamModel team=new SlackTeamModel(252);
		Response response=SlackTeamEndpoints.delete(team.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}



}
