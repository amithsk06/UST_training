package step_definitions;

import static org.testng.Assert.assertEquals;

import org.testng.ITestListener;
import org.testng.annotations.Listeners;



import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ust.com.pom.Contact;
import ust.com.pom.HomePage;
import ust.com.pom.SearchPage;
import ust.com.utils.ExtentReportsListener;



/** Test cases for testing the search feature of Contacts App**/


public class SearchTest implements ITestListener{
	ExtentReportsListener extentReportsListener = new ExtentReportsListener();
	private final AndroidDriver driver = Hooks.driver;
	
	@Given("User opens the contact App")
	public void user_opens_the_contact_app() {
		System.out.println("App opened");
	}

	@When("User clicks on search bar")
	public void user_clicks_on_search_bar() {
		HomePage homePage = new HomePage(driver);
		homePage.clickSkip();
		homePage.clickAllow();
		homePage.clickSearch();
	}

	@When("User enters {string} in the search box")
	public void user_enters_in_the_search_box(String string) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.enterSearchInput(string);
	}

	@When("User clicks on the search result")
	public void user_clicks_on_the_search_result() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.selectContact();
	}

	@Then("User get the contact details of {string}")
	public void user_get_the_contact_details_of(String string) {
//		Contact contactPage = new Contact(driver);
//		assertEquals(contactPage.validateContactName().equals(string), true);
	}
}
