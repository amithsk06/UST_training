package com.ust.tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.Test;

import com.ust.pom.CheckoutPage;
import com.ust.pom.HomePage;
import com.ust.pom.ItemPage;
import com.ust.utilities.Dataproviders;
import com.ust.utilities.FileIO;

public class CheckoutTest extends Basetest{
	Properties prop=FileIO.getProperties();
	HomePage home;
	ItemPage item;
	CheckoutPage checkout;
	
	
	@Test(priority=0)
	public void start()
	{
		assertEquals(driver.getCurrentUrl(),prop.getProperty("SiteURL"));
	}
	
	@Test(priority=1)
	public void itemclickTest()
	{
		home=new HomePage(driver);

		home.clickitem1();
		//asserting the page
		assertEquals(driver.getCurrentUrl(),prop.getProperty("itemURL"));
		
	}
	@Test(priority=2)
	public void buyingtheItemTest()
	{
		item=new ItemPage(driver);
		//checking the elements of color and size
		item.colorSelect();
		item.sizeSelect();
		item.clickBuyNow();
		assertEquals(driver.getCurrentUrl(),prop.getProperty("CartURL"));
	}
	@Test(priority=3)
	public void checkingoutTest()
	{
		checkout=new CheckoutPage(driver);
		String price=checkout.getPrice();
		String checkprice=checkout.getCheckPrice();
		//asseerting if the items price is same 
		assertEquals(price,checkprice);
		checkout.checkingOut();
		assertEquals(driver.getCurrentUrl(),prop.getProperty("checkoutURL"));
	}
	
	//getting data from excel
	   @Test(priority=4,dataProvider = "Data",dataProviderClass = Dataproviders.class)
		public void addressdetailsTest(String data1,String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9) throws InterruptedException
		{
			checkout.new_address_details(data1, data2, data3, data4, data5,data6,data7,data8,data9);
		}
	   

	

}
