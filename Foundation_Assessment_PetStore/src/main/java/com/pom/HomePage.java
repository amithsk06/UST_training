package com.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableFunctions;
import com.utilities.FileIO;

public class HomePage {
	static WebDriver driver;
	ReusableFunctions functions=new ReusableFunctions(driver);
	Properties prop = FileIO.getProperties();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//---locators of HomePage---//
	@FindBy(xpath="//div[@id='MenuContent']/a[2]")
	WebElement sign_in;
	@FindBy(linkText="Register Now!")
	WebElement register;
	@FindBy(xpath="//div[@id='MainImageContent']/map/area[2]")
	WebElement fish;
	
	// ----clicking the sign in link----//
			public void clickSign_In() {
				functions.clickOn(sign_in,3);
				
			}
			public void clickRegister() {
				functions.clickOn(register,3);
			}
			
			public void clickFish() {
                functions.clickOn(fish,3);
            }
	

}
