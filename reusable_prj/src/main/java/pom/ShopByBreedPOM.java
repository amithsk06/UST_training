package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import base.ReusableFunction;

public class ShopByBreedPOM {
	private WebDriver driver;
	
	public ShopByBreedPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By consultNow=By.xpath("(//div[@class='need-train-help'])[1]/a");
	By dogBehavior=By.id("AddToCart-7514766737646");
	By buyNow=By.xpath("//button[@data-testid='Checkout-button']");


	// Method to click on "Consult Now" link
	public void clickConsultNow() {
		ReusableFunction.clickOn(consultNow, Duration.ofSeconds(30));
	}
	
	// Method to click on "Dog Behavior Consultation" 
	public void clickDogBehavior() {
		ReusableFunction.clickOn(dogBehavior, Duration.ofSeconds(10));
	}
	
	// Method to click on "Buy It Now" button
	public void clickBuyNow() {
		ReusableFunction.clickOn(buyNow, Duration.ofSeconds(30));
	}

}
