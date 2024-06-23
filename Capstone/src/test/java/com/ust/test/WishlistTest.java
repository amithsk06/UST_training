package com.ust.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseLoginTest;
import com.ust.pom.HomePage;
import com.ust.pom.WishlistPage;

import com.ust.utilities.ExtentReportsListener;
import com.ust.utilities.FileIO;

@Listeners(ExtentReportsListener.class)
public class WishlistTest extends BaseLoginTest {
	WishlistPage wishlist;
	Properties prop=FileIO.getProperties();
	HomePage homepage;
	@Test(priority=0)
	public void home()
	{
		wishlist=new WishlistPage(driver);
		homepage=new HomePage(driver);
		homepage.to_home();
	}
	@Test(priority=1)
	public void wishlisting_item1Test()
	{
		//getting the item_name to be wishlisted
		String expected_item_name=homepage.item1_name();
		homepage.adding_item1_wishlist();
		assertTrue(driver.getCurrentUrl().contains(prop.getProperty("WISHLIST_URL")));
		//getting the string array which contains the heading and item_count
		String[] list=wishlist.wishlist_count();
		assertEquals(prop.getProperty("WISHLIST_HEADING"),list[0]);
		assertEquals(expected_item_name,wishlist.wishlisted_item1());
		//returning to home
		homepage.to_home();
	}
	
	 @Test(priority=2)
	 public void wishlisting_item2Test()
	 {
		String expected_item_name=homepage.item2_name();
		homepage.adding_item2_wishlist();
		assertTrue(driver.getCurrentUrl().contains(prop.getProperty("WISHLIST_URL")));

		//getting the string array which contains the heading and item_count
		String[] list=wishlist.wishlist_count();
		assertEquals(prop.getProperty("WISHLIST_HEADING"),list[0]);
		assertEquals(expected_item_name,wishlist.wishlisted_item2());
	}
	 @Test(priority=3)
	 public void remove_itemTest()
	 {
		 wishlist.removing_item1();
		 String[] list=wishlist.wishlist_count();
		 assertEquals(prop.getProperty("COUNT"),list[1]);
	 }

}
