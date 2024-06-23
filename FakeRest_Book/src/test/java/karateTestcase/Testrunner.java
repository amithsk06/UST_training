package karateTestcase;

import com.intuit.karate.junit5.Karate;

public class Testrunner {

	@Karate.Test
	Karate KarateTest() {
        return Karate.run("classpath:karateTestcase/bookstest.feature").relativeTo(getClass());
    }
}





//-------petstore------------//---authorization//
//RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
//// Username and Password
//String username = "roshan";
//String password = "shafeek";
//// Sending GET request with username and password in headers
//Response response = given()
//        .header(new Header("username", username))
//        .header(new Header("password", password))
//        .when()
//        .get("/login");