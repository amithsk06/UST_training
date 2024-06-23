package com.workflow;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.ReusableFunctions;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.RegisterPage;
import com.utilities.ExtentReportsListener;
import com.utilities.DataProviders;
import com.utilities.FileIO;

@Listeners(ExtentReportsListener.class)
public class RegisterTest  {

	WebDriver driver;
	ReusableFunctions functions;
	RegisterPage reg_pom;
	HomePage home;
	LoginPage login;
	Properties prop = FileIO.getProperties();
	
	@BeforeTest
	public void openBrowser() {
		functions = new ReusableFunctions(driver);
		driver = functions.invokeBrowser();
		functions.openBrowser("test_url");
		assertEquals(driver.getCurrentUrl(), prop.getProperty("test_url"));
	}

	@Test(priority = 1)
	public void signingIn() {
		home=new HomePage(driver);
		home.clickSign_In();
		home.clickRegister();
//		assertEquals(driver.getCurrentUrl(), prop.getProperty("sign_up_url"));
	}

	@Test(priority = 2)
	public void userInformation() throws InterruptedException {
		reg_pom = new RegisterPage(driver); // -----entering user info directly
		reg_pom.userInfo();
	}

	@Test(priority = 3, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void addingaccountdetails(String data1, String data2, String data3, String data4, String data5, String data6,
			String data7, String data8, String data9, String data10) {
		reg_pom = new RegisterPage(driver);
		reg_pom.accountInfo(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		// -------entering account info with dataprovider
	}
	
	// -------entering the profile informations
	@Test(priority = 4)
	public void profileinformation() 
	{
		reg_pom = new RegisterPage(driver);
		reg_pom.profile_Info();
		assertEquals(driver.getCurrentUrl(), prop.getProperty("test_url"));
	}

	@Test(priority = 5)
	public void login() // -----logging in with credentials created
	{
		home=new HomePage(driver);
		home.clickSign_In();
		login = new LoginPage(driver);
		login.logging_in();
		assertEquals(driver.getCurrentUrl(), prop.getProperty("test_url"));
	}
}
