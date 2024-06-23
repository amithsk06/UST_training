package com.example;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserModel;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserTests {


    private Faker faker;
    private UserModel userPayload;

    @BeforeClass
    public void setup() {
        faker = new Faker();
        userPayload = new UserModel();
        userPayload.setId(faker.number().numberBetween(1,5000)); // Adjust as needed
        userPayload.setName(faker.name().fullName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setGender(faker.demographic().sex());
        userPayload.setStatus("active"); // Assuming status is always "active"
        // Logs or any other setup steps
    }
    @Test(priority = 1)
    public void testPostUser()
    {
        Response response = UserEndPoints.createUser(this.userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),201);
    }
    @Test(priority=2)
    public void testGetUserByName()
    {
        Response response = UserEndPoints.getUser(this.userPayload.getId());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 3)
    public void testUpdateuserByName()
    {
    		 faker = new Faker();
 	        userPayload = new UserModel();
    	        
    	        // Update data using payload
 	        Long updatedId=(long) 2653;
    	        String updatedName = faker.name().firstName();
    	        String updatedEmail =  faker.internet().safeEmailAddress();
    	        String updatedGender =faker.demographic().sex();
    	        String updatedStatus ="inactive";
    	        
    	        userPayload.setName(updatedName);
    	        userPayload.setEmail(updatedEmail);
    	        userPayload.setStatus(updatedStatus);
    	        
    	        // Update user using UserEndPoints.updateUser()
    	        Response response = UserEndPoints.updateUser(updatedId, userPayload);
    	        response.then().log().all();
    	        Assert.assertEquals(response.getStatusCode(), 200);

    	        // Checking data after updation
    	        Response responseAfterUpdate = UserEndPoints.getUser(updatedId);
    	        responseAfterUpdate.then().log().all();
    	        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

    	        // Validate the updated data
    	        UserModel updatedUser = responseAfterUpdate.getBody().as(UserModel.class);
    	        Assert.assertEquals(updatedUser.getName(), updatedName);
    	        Assert.assertEquals(updatedUser.getGender(), updatedGender);
    	        Assert.assertEquals(updatedUser.getEmail(), updatedEmail);
    
    }
    @Test(priority = 4)
    public void testDeleteUserByName()
    {
        Response response = UserEndPoints.deleteUser(this.userPayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 5)
    public void schemavalidation() {
    	
    	String schemaFile=System.getProperty("user.dir") + "\\src\\test\\resources\\schema.json";
    	Response response=UserEndPoints.getUser(6798309);
    	response.then().log().all()
    	.assertThat()
    	.body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFile)));
    }
}
