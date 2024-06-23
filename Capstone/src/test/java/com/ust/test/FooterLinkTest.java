package com.ust.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseTest;
import com.ust.pom.HomePage;
import com.ust.utilities.ExtentReportsListener;
import com.ust.utilities.FileIO;

@Listeners(ExtentReportsListener.class)
public class FooterLinkTest extends BaseTest {
		HomePage homepage;
		Properties prop=FileIO.getProperties();
	
		/*
		 * This method tests the "About Us" link in the footer.
		 * It navigates to the "About Us" page and verifies the title.
		 */
	  @Test(priority=0)
	  public void moveToAboutUs() throws Exception {
        homepage=new HomePage(driver);
        homepage.clickPagePhilosophy();
        assertEquals(driver.getTitle(),prop.getProperty("ABOUT_US"));
        driver.navigate().back();
     }
	 
	 
	  /*
	  * This method tests the "Policies" link in the footer.
	  * It navigates to the "Policies" page and verifies the title.
	  */
	  @Test(priority=1)
	  public void moveToPolicies() throws Exception {
        homepage=new HomePage(driver);
        homepage.clickPolicies();
        assertEquals(driver.getTitle(), prop.getProperty("POLICIES"));
     }
	 
	 
	  /*
	  * This method tests the "Customize" link in the footer.
	  * It navigates to the "Customize" page and verifies the title.
	  */
	  @Test(priority=2)
	  public void moveToCustomizePage() throws Exception {
        homepage=new HomePage(driver);
        homepage.clickCustomize();  
        assertTrue(driver.getTitle().contains(prop.getProperty("SKIN_CARE")));
        homepage.to_home();
        assertEquals(prop.getProperty("BASE_URL"),driver.getCurrentUrl());
     }
	  
	  @Test(priority=3)
	  public void move_to_home()
	  {
		  homepage=new HomePage(driver);
		  homepage.to_home();
		  assertEquals(prop.getProperty("BASE_URL"),driver.getCurrentUrl());
	  }
	 
}