package com.ust.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.Test;

import com.ust.base.BaseLoginTest;
import com.ust.pom.CheckoutPage;
import com.ust.pom.HomePage;

import utilities.FileIO;

public class CheckoutTest extends BaseLoginTest{
	HomePage homepage;
	CheckoutPage checkout;
	Properties prop=FileIO.getProperties();
	
	//returning to home after baseloginTest
	@Test(priority=0)
	public void homeTest()
	{
		homepage=new HomePage(driver);
		homepage.to_home();
		assertEquals(prop.getProperty("BASE_URL"),driver.getCurrentUrl());
	}
	
	//method to naviagte to cart page
	@Test(priority=1)
	public void bagTest()
   {
		homepage.clickBag();
		assertEquals(prop.getProperty("CART_URL"),driver.getCurrentUrl());
	
    }
	//---checkouting---//
	@Test(priority=2)
	public void checkoutTest()
	{
		checkout=new CheckoutPage(driver);
		String qnty=checkout.getcount();
		String count="1";
		assertEquals(count,qnty);
	}
	@Test(priority=3)
	public void checkouting()
	{
		checkout.click_checkout();
		assertEquals(prop.getProperty("CHECKOUT_URL"),driver.getCurrentUrl());
	}
}
