package ApiTestcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import endpoints.Userendpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.Usermodel;

public class UserTest {

    public Usermodel userPayload;

    @BeforeClass
    public void setup() {
    	 userPayload = new Usermodel(
    		    2,                  // id
    		    "tex",            // username
    		    "Tex",            // firstName
    		    "Pyper",                // lastName
    		    "texpyper@gmail.com",  // email
    		    "texpyper",            // password
    		    "2345783",       // phone
    		    1                   // userStatus
    		);

    }
    @Test
    public void getSingleUserByUsernameTest() {
        RestAssured.useRelaxedHTTPSValidation();
        Response response = Userendpoints.getSingleUserByUsername(this.userPayload.getUsername());
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getSingleUserByLoginTest() {
        RestAssured.useRelaxedHTTPSValidation();
        Response response = Userendpoints.loginUser(this.userPayload.getUsername(), this.userPayload.getPassword());
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 0)
    public void createUserTest() {
        RestAssured.useRelaxedHTTPSValidation();
        Response response = Userendpoints.createUser(this.userPayload);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void updateUserTest() {
        RestAssured.useRelaxedHTTPSValidation();
        Response response = Userendpoints.updateUser(userPayload,userPayload.getUsername());
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void deleteUserTest() {
        RestAssured.useRelaxedHTTPSValidation();
        Response response = Userendpoints.deleteUser(userPayload.getUsername());
        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }
}
