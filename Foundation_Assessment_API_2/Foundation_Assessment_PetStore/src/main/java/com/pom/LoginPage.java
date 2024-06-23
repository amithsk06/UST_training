package com.pom;


import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableFunctions;
import com.utilities.FileIO;

public class LoginPage {
	public static WebDriver driver;
	public ReusableFunctions functions=new ReusableFunctions(driver);
	Properties prop=FileIO.getProperties();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//------locating the WebElements--------//
	@FindBy(css="input[name='username']")
	WebElement username;
	@FindBy(css="input[name='password']")
	WebElement password;
	@FindBy(xpath="//input[@name='signon']")
	WebElement submit;
	
	//------Login-------//
	public void logging_in() {
		functions.sendText(username, prop.getProperty("userid"));
		functions.clearText(password);
		functions.sendText(password, prop.getProperty("password"));
		functions.clickOn(submit,2);
	}
}
