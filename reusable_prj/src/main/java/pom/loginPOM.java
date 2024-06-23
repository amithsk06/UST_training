package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunction;



public class loginPOM {
	
	private WebDriver driver;
	
	public loginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	 By loginIcon=By.xpath("//*[@id='shopify-section-header-new-desktop']/header/div/div[2]/div[2]/div[1]/a[3]");
	
	 @FindBy(css = "div[class='login-box step-box-wrapper'] input[placeholder='Phone number']")
	 WebElement loginphnumber;
	
	 By loginbtn=By.xpath("//button[@class='send-btn otp-btn']");
	
	// Method to click on login icon
	public void loginIcon() {
		 ReusableFunction.clickOn(loginIcon, Duration.ofSeconds(10));
	 }
	
	// Method to enter phone number for login
	public void loginphnumber(String phnumber) {
		ReusableFunction.sendText(loginphnumber,phnumber);
	}
	
	// Method to click on login button
	public void btnclick() {
		ReusableFunction.clickOn(loginbtn, Duration.ofSeconds(10));
	}
}
