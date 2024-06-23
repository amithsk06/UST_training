package com.ust.base;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.ust.pom.HomePage;
import com.ust.pom.LoginPage;

import utilities.FileIO;

public class BaseLoginTest {	
	/*--- protected static method would allow you to provide "utility" type functionality to derived classes, 
	without exposing them in the public API where they might not make sense on their own----*/
	protected static WebDriver driver;

	ReusableFunctions functions;
	HomePage homePage;
	Properties prop=FileIO.getProperties();
	
	
	@BeforeClass
	public void start() {
		functions=new ReusableFunctions(driver);
		driver=functions.invokeBrowser("BROWSER");
		functions=new ReusableFunctions(driver);
	    functions.openBrowser("BASE_URL");
	    homePage=new HomePage(driver);
	    //homePage.closeOffers();

        LoginPage loginPage = homePage.clickAccount();

        // Act
        functions.delay(3);
        loginPage.enterEmail("USERNAME");              
        functions.delay(5);
        loginPage.enterPassword("CURRENT_PASSWORD");
        functions.delay(5);
        loginPage.clickSignIn();
        // Assert
        assertTrue(loginPage.logoutPresent(), "Login was successful");
    }
	   
	@AfterClass
	public void stop()
	{	
		functions.closeBrowser();
	}
}



