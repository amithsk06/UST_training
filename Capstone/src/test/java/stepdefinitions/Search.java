package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ust.base.ReusableFunctions;
import com.ust.pom.HomePage;
import com.ust.pom.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search{
	WebDriver driver=Hooks.driver;
	HomePage homePage;
	SearchPage searchPage;

/**
 * This method verifies that the user is on the home page.
 *
 * @throws Exception If an error occurs while checking the homepage URL or search icon presence.
 */
@Given("I am in home page")
public void i_am_in_home_page() throws Exception {
	
	
	homePage = new HomePage(driver);
    // Check if the search icon is present on the homepage
    assertTrue(homePage.isSearchIconPresent());
}

@When("I click on the search icon")
public void i_click_on_the_search_icon() throws Exception {
    
    // Click on the search icon
    homePage.clickSearchIcon();
    
    // To check presence of search bar after clicking on the search icon
    assertTrue(homePage.isSearchBarPresent());
}

@And("I fill in the search field with {string}")
public void i_fill_in_the_search_field_with(String string) {
    
    // Enter the provided text into the search field
    homePage.enterTextToSearch(string);
    
    // Assert that the search action is performed successfully
    assertTrue(homePage.actionSearch());
}

@And("I click on the search button")
public void i_click_on_the_search_button() {
    
    // Assert that the logo is present on the page
    assertTrue(homePage.logoisPresent());
    
    // Click on the search button
    homePage.clickSearch();
    searchPage = new SearchPage(driver);
}

@Then("I should see the list of valid search list with {string}")
public void i_should_see_the_list_of_valid_search_list_with(String string) {
    
    
    // Check if the URL contains "result", indicating that the search action redirected to a new page with products
    assertTrue(searchPage.getUrl().contains("result"));
    
    // Get the name of the first product in the search results list
    String productName = searchPage.getProductName();
    
    // Check if the first product in the list contains the search keyword
    assertTrue(productName.contains(string));
}





}
