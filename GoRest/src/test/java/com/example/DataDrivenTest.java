package com.example;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.UserModel;
import api.utilities.DataProviders;
import io.restassured.response.Response;
@Listeners(api.utilities.ExtentReportManager.class)
public class DataDrivenTest {

	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
    public void testPostUser(String id, String name, String email, String gender, String status) {
        UserModel user = new UserModel();
        user.setId(Long.parseLong(id));
        user.setName(name);
        user.setEmail(email);
        user.setGender(gender);
        user.setStatus(status);
        
        // Assuming UserEndPoints.createUser() method returns a Response object
        Response response = UserEndPoints.createUser(user);
        
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 201);
    }

		
	
	
	
	
}
