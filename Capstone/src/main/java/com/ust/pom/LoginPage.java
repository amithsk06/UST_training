package com.ust.pom;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;

import utilities.FileIO;

public class LoginPage {

	
	static WebDriver driver;
	ReusableFunctions functions;
	Properties prop = FileIO.getProperties();
	
	public LoginPage(WebDriver driver) {
        LoginPage.driver=driver;
        functions=new ReusableFunctions(driver);
        PageFactory.initElements(driver, this);
	}
	 
	//---locators of Login Page----//  
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;     
    @FindBy(css = "input[id='pass'][title='Password']")
    WebElement password;   
    @FindBy(css = "div[class='primary']>button#send2.action.login.primary")
    WebElement signIn;
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border' and @role=\"presentation\"]")
    List<WebElement> captchas;  
    @FindBy(css="a[class='action create primary']")
    WebElement create;
    @FindBy(css = "li[class='header_account_link_list']>a")
    WebElement logout;
    
    
   
    //Enter the user's email into the email input field.
    public void enterEmail(String usermail) {
        functions.sendText(email, prop.getProperty(usermail));
    }
    
    //Enter the user's password into the password input field.
    public void enterPassword(String pass) {
        functions.sendText(password, prop.getProperty(pass));
        functions.delay(8);
    }

    //Click the sign-in button.
    public void clickSignIn() {
        functions.clickOnVisibility(signIn, 15);
    }
    

    
     // Check if the logout button is present. 
    public boolean logoutPresent() {
        return logout.isDisplayed();
    }
    
    //returning driver
    public LoginPage lp()
    {
    	return new LoginPage(driver);
    }
    
    public Sign_upPage clickCreate() {
   	 functions.mouseAction(create);
		return new Sign_upPage(driver);
   	
   }


	
	
}
