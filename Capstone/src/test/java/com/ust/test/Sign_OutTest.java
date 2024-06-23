package com.ust.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseLoginTest;
import com.ust.pom.HomePage;
import com.ust.utilities.ExtentReportsListener;

import utilities.FileIO;

@Listeners(ExtentReportsListener.class)
public class Sign_OutTest extends BaseLoginTest{
	Properties prop=FileIO.getProperties();
	HomePage homepage;
	
	@Test(priority=0)
	public void signingoutTest()
	{
		homepage=new HomePage(driver);
		homepage.signing_out();
	}
	@Test(priority=1)
	public void sign_out_messagetest()
	{
	assertEquals("You are signed out",homepage.sign_out_check());
	assertEquals(prop.getProperty("LOGOUT_URL"),driver.getCurrentUrl());
	}

}
