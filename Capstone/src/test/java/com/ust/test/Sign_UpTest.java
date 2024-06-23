package com.ust.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseTest;
import com.ust.pom.HomePage;
import com.ust.pom.LoginPage;
import com.ust.pom.Sign_upPage;
import com.ust.utilities.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class Sign_UpTest extends BaseTest{
	
    LoginPage loginpage;
    HomePage homepage;
    Sign_upPage signUpPage;
	
	@Test(priority=0)
	public void checkAccountPage()
	{
		HomePage homepage=new HomePage(driver);
		loginpage=homepage.clickAccount();
		assertTrue(driver.getTitle().equals("Welcome, please sign in"));
		
	}
	
	@Test(priority=1)
	public void checkSignUpPage()
	{
		Sign_upPage signUpPage=new Sign_upPage(driver);
		loginpage=new LoginPage(driver);
		signUpPage=loginpage.clickCreate();
		assertTrue(signUpPage.createPresent());
		
	}
	
	
	@Test(priority=1)
	public void validSignUp()
	{
		signUpPage=new Sign_upPage(driver);
		signUpPage.enterInformation();
		assertEquals(signUpPage.getdashBoard(),"Dashboard");
	}
	
	
	
	

}
