package com.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.pom.HomePage;
import com.pom.ProductPage;
import com.utilities.FileIO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartingFish {
		WebDriver driver=Hooks.driver;
		HomePage home;
		ProductPage product;
		Properties prop=FileIO.getProperties();
	
	@Given("User on the PetStore")
	public void user_on_the_pet_store() {
	    home=new HomePage(driver);
	}

	@When("User clicks fish")
	public void user_clicks_fish() {
	    home.clickFish();
	}

	@Then("User validates fish page")
	public void user_validates_fish_page() {
	    assertTrue(driver.getCurrentUrl().contains("FISH"));
	}
	@When("User navigates to Angel Fish")
	public void user_navigates_to_angel_fish() {
		product = new ProductPage(driver);
	    product.click_fish1();
	}

	@Then("User validates the page")
	public void user_validates_the_page() {
	    assertEquals(driver.getCurrentUrl(),prop.getProperty("fish_url"));
	}

	@When("User clicks Add to Cart")
	public void user_clicks_add_to_cart() {
	    product.click_addtocart();
	}

	@Then("User validates cart page")
	public void user_validates_cart_page() {
	    assertEquals(driver.getCurrentUrl(),prop.getProperty("cart_url"));
	    assertEquals(product.get_fishname(),"Large Angelfish");
	}

	@When("User clicks home page")
	public void user_clicks_home_page() {
	   product.returnhome();
	   
	}

	@Then("User validates home page")
	public void user_validates_home_page() {
	   assertEquals(driver.getCurrentUrl(),prop.getProperty("test_url"));
	}

}
