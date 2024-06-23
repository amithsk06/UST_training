package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.ust.pom.SearchPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sorting {

	 public WebDriver driver = Hooks.driver;
	 SearchPage searchPage;
	

	 
	@When("Select sort by price low to high")
	public void select_sort_by_price_low_to_high() {
		searchPage = new SearchPage(driver);
		 assertTrue(searchPage.isSortByPresent());
		 searchPage.sortBy();
	}

/**
 * This method checks if the product is displayed in ascending order of price.
 *
 * @return void
 * @throws Exception if any error occurs during the test
 */
@Then("Product displayed in ascending order of price")
public void product_displayed_in_ascending_order_of_price() throws Exception {
    // Get the SearchPage object using the WebDriver instance
    searchPage = new SearchPage(driver);
    // Get the original list of product prices in 
    List<Integer> original=searchPage.printprices();
     //perform sortBy low to high
    searchPage.sortByLowToHigh();
     // Get the list of product prices in ascending order
    List<Integer> asc=searchPage.printprices();
     // sorting the original price
    Collections.sort(original);
    // comparing the sorted original price and low to high list
    assertTrue(original.equals(asc));
//    searchPage.sortByLowToHigh();
//    assertTrue(searchPage.isSortedAsc());

}


@When("Select sort by price high to low")
public void select_sort_by_price_high_to_low() {
	searchPage = new SearchPage(driver);
	 assertTrue(searchPage.isSortByPresent());
	 searchPage.sortBy();
}
@Then("Product displayed in descending order of price")
public void product_displayed_in_descending_order_of_price() {
	  // Get the SearchPage object using the WebDriver instance
    searchPage = new SearchPage(driver);
    // Get the original list of product prices in 
    List<Integer> original=searchPage.printprices();
     //perform sortBy low to high
    searchPage.sortByHighToLow();
     // Get the list of product prices in ascending order
    List<Integer> desc=searchPage.printprices();
     // sorting the original price
    Collections.sort(original);
    Collections.reverse(original);
    // comparing the sorted original price and low to high list
    assertTrue(original.equals(desc));
//    searchPage.sortByHighToLow();
//    assertTrue(searchPage.isSortedDesc());
}
	
}
