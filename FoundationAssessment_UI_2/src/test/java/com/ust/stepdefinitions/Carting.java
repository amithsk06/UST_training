package com.ust.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.pom.HomePage;
import com.ust.pom.ItemPage;
import com.ust.pom.SearchPage;
import com.ust.utilities.FileIO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Carting {
	Properties prop=FileIO.getProperties();
	WebDriver driver = Hooks.driver;
	HomePage home;
	SearchPage search;
	ItemPage item;
	
	
	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
	   assertEquals(driver.getCurrentUrl(),prop.getProperty("SiteURL"));
	}

	@When("User searches for {string}")
	public void user_searches_for(String string) {
	    home=new HomePage(driver);
	    home.searching(string);
	}

	@Then("Cargo search page is loaded")
	public void cargo_search_page_is_loaded() {
	    assertEquals(driver.getCurrentUrl(),prop.getProperty("CargoURL"));
	}

	@When("User edits the filter options")
	public void user_edits_the_filter_options() throws InterruptedException {
	    search=new SearchPage(driver);
	    search.filtering();
	}

	@Then("new search page is loaded")
	public void new_search_page_is_loaded() {
	    assertEquals(driver.getCurrentUrl(),prop.getProperty("FilteredURL"));
	}

	@When("User clicks the first item")
	public void user_clicks_the_first_item() {
	   search.clickingProduct();
	}

	@Then("Item page is loaded")
	public void item_page_is_loaded() {
	   assertEquals(driver.getCurrentUrl(),prop.getProperty("ProductURL"));
	}

	@When("User add the item to cart")
	public void user_add_the_item_to_cart() throws InterruptedException {
		item=new ItemPage(driver);
	    item.addtoCart();
	}

	@Then("User validates the item if its is carted")
	public void user_validates_the_item_if_its_is_carted() {
	    
	}

}
