package stepDefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import base.ReusableFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.ShopByBreedPOM;


public class ShopByBreedTest {
	
	public WebDriver driver=Hooks.driver;
	
	@Given("User navigate to the Supertails website")
	public void user_navigate_to_the_supertails_website() {
		assertEquals("https://supertails.com/", driver.getCurrentUrl());
	}

	@When("User select {string} from Shop By Breed section")
	public void user_select_from_shop_by_breed_section(String string) {
		WebElement shopByBreed=driver.findElement(By.xpath("//ul[@class='lev-1']/li[4]/a/span/span"));
		Actions a=new Actions(driver);
		a.clickAndHold().moveToElement(shopByBreed).build().perform();
		driver.findElement(By.linkText(string)).click();
//		System.out.println(driver.getTitle());
	}


	@Then("User should validate the page")
	public void user_should_validate_the_page() {
	    Assert.assertEquals(driver.getCurrentUrl(), "https://supertails.com/pages/labrador-retriever");
	    Assert.assertTrue(driver.getTitle().contains("Labrador"));
	}

	@Then("User select {string}")
	public void user_select(String string) {
	   driver.findElement(By.linkText(string)).click();
	   Assert.assertTrue(driver.getCurrentUrl().contains(string.toLowerCase()));
	}
	
	@Then("User navigate to Consult Now page")
	public void user_navigate_to_consult_now_page()  throws InterruptedException {
//		Thread.sleep(1000);
		ShopByBreedPOM shop=new ShopByBreedPOM(driver);
		shop.clickConsultNow();
//		driver.findElement(By.xpath("(//div[@class='need-train-help'])[1]/a")).click();
	}

	@Then("Click view details of Dog Behaviour Consultation")
	public void click_view_details_of_dog_behaviour_consultation()  throws InterruptedException {
//		Thread.sleep(1000);
		ShopByBreedPOM shop=new ShopByBreedPOM(driver);
		shop.clickDogBehavior();
//	    driver.findElement(By.id("AddToCart-7514766737646")).click();
	}

	@Then("Click on Buy It Now")
	public void click_on_buy_it_now() {
		ShopByBreedPOM shop=new ShopByBreedPOM(driver);
		shop.clickBuyNow();
//	    driver.findElement(By.xpath("//button[@data-testid='Checkout-button']")).click();
	}

	@Then("User should validate the checkout page")
	public void user_should_validate_the_checkout_page() {
	    Assert.assertTrue(driver.getTitle().contains("Checkout"));
	}
	

}
