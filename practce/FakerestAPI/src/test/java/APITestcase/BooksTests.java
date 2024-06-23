package APITestcase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Endpoints.BookEndpoints;
import Endpoints.Routes;
import Payload.Book_modal;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import utilities.XLutility;

@Listeners(utilities.ExtentReportManager.class)
public class BooksTests {

	private Faker faker;
	private Book_modal bookPayload;
	String timestamp=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	int i=1;
	@BeforeClass
	public void setup() {
	        faker = new Faker();
	        bookPayload = new Book_modal();
	        bookPayload.setId(1); // Adjust as needed
	        bookPayload.setTitle(faker.name().title());
	        bookPayload.setDescription(faker.lorem().word());
	        bookPayload.setPageCount(faker.number().numberBetween(1, 100));
	        bookPayload.setExcerpt(faker.lorem().paragraph()); // Assuming status is always "active"
	        bookPayload.setPublishDate(timestamp+"T15:11:27.2751261+00:00");	   // Logs or any other setup steps
	 }
	
	
	
	 @Test(priority = 1)
	 public void testPostuser() {
		 Response response=BookEndpoints.createUser(this.bookPayload);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(),200);
	 }
	 
	 @Test(priority = 2)
	 public void testGetuser() {
		 Response response=BookEndpoints.getUser(this.bookPayload.getId());
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(),200);
	 }
	 
	 @Test(priority = 3)
	    public void testUpdateuser()
	    {
	    		 faker = new Faker();
	    		 bookPayload = new Book_modal();
	    	        
	    	        // Update data using payload
	 	        	Long updatedId= (long) 2653;
	    	        String updatedTitle = faker.name().title();
	    	        String updatedDescription =  faker.lorem().word();
	    	        int updatedPageCount=faker.number().numberBetween(1, 100);
	    	        String updatedExcerpt=faker.lorem().paragraph(); 
	    	        String updatedPublishDate=timestamp+"T15:11:27.2751261+00:00";
	    	        
	    	        bookPayload.setTitle(updatedTitle);
	    	        bookPayload.setDescription(updatedDescription);
	    	        bookPayload.setPageCount(updatedPageCount);
	    	        bookPayload.setExcerpt(updatedExcerpt);
	    	        bookPayload.setPublishDate(updatedPublishDate);
	    	        
	    	        // Update user using UserEndPoints.updateUser()
	    	        Response response = BookEndpoints.updateUser(updatedId, bookPayload);
	    	        response.then().log().all();
	    	        Assert.assertEquals(response.getStatusCode(), 200);

	    	        // Checking data after updation
//	    	        Response responseAfterUpdate = BookEndpoints.getUser(updatedId);
//	    	        responseAfterUpdate.then().log().all();
//	    	        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

	    	        // Validate the updated data
//	    	        Book_modal updatedUser = responseAfterUpdate.getBody().as(Book_modal.class);
//	    	        Assert.assertEquals(bookPayload.getTitle(), updatedTitle);
//	    	        Assert.assertEquals(bookPayload.getDescription(), updatedDescription);
//	    	        Assert.assertEquals(bookPayload.getPageCount(), updatedPageCount);
//	    	        Assert.assertEquals(bookPayload.getExcerpt(), updatedExcerpt);
//	    	        Assert.assertEquals(bookPayload.getPublishDate(), updatedPublishDate);
	    }
	    @Test(priority = 4)
	    public void testDeleteUser()
	    {
	        Response response = BookEndpoints.deleteUser(this.bookPayload.getId());
	        response.then().log().all();
	        Assert.assertEquals(response.getStatusCode(),200);
	    }
	    
	    @Test(priority = 5)
	    public void schemavalidation() {
	    	String filepath=System.getProperty("user.dir") + "\\src\\test\\resources\\schema.json";
	    	
	    		 Response response=BookEndpoints.getUser(i);
				 response.then().log().all()
				 .assertThat()
				 .body(JsonSchemaValidator.matchesJsonSchema(new File(filepath)));
			
	    	
	    }
}
