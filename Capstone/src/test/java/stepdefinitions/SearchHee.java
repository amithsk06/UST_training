package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.ust.pom.SearchPage;

import io.cucumber.java.en.Then;

public class SearchHee {
	WebDriver driver = Hooks.driver;
	SearchPage searchPage;
	
	@Then("I should see {string} message")
	public void i_should_see_message(String string) {
		searchPage=new SearchPage(driver);
	    assertEquals(searchPage.notFound(),string);
	}

}
