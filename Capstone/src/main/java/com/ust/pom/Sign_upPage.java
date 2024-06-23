package com.ust.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ust.base.ReusableFunctions;
import com.ust.utilities.FileIO;

public class Sign_upPage {
  
	
	
	static WebDriver driver;
	ReusableFunctions functions;
	Properties prop;
	
	public Sign_upPage(WebDriver driver) {
        Sign_upPage.driver=driver;
        functions=new ReusableFunctions(driver);
        PageFactory.initElements(driver, this);
        prop=FileIO.getProperties();
	}
	
	
	@FindBy(css="span[class='base']")
	WebElement create;
	@FindBy(css="select[name='prefix']")
	WebElement title;
	@FindBy(css="input[id='firstname']")
	WebElement firstName;
	@FindBy(css="input[id='lastname']")
	WebElement lastName;
	@FindBy(css="input[id='email_address']")
	WebElement email;
	@FindBy(css="input[id='mobile']")
	WebElement phno;
	@FindBy(css="input[id='password-confirmation']")
	WebElement confrmpasswd;
	@FindBy(css="input[id='password']")
	WebElement passwd;
	@FindBy(css="button[class='action submit primary']")
	WebElement submit;
	@FindBy(css="span[class='base']")
	WebElement dashboard;
	
	
	public boolean createPresent() {
		return create.isDisplayed();
	}
	
	
	//To enter Personal Information for account creation
	public void enterInformation() {
		Select select =new Select(title);
		select.selectByValue("Mr.");
		functions.sendText(firstName, prop.getProperty("USER_FIRSTNAME"));
		functions.sendText(lastName, prop.getProperty("USER_LASTNAME"));
		functions.sendText(email, prop.getProperty("USER_EMAIL"));
		functions.sendText(phno, prop.getProperty("USER_PHNO"));
		functions.sendText(passwd, prop.getProperty("USER_PASSWORD"));
		functions.sendText(confrmpasswd, prop.getProperty("USER_PASSWORD"));
		functions.delay(18);
		functions.mouseAction(submit);
	}
	
	public String getdashBoard() {
		return dashboard.getText();
	}
	
	
	
}
