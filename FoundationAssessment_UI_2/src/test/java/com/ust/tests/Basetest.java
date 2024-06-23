package com.ust.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import com.ust.utilities.Extentreportlistener;

import ust.base.Reusablefunctions;

@Listeners(Extentreportlistener.class)
public class Basetest {

	 public static WebDriver driver;
	 public Reusablefunctions rf;
	 	    
	   @BeforeClass
	    public void before() {
	        driver = Reusablefunctions.invokeBrowser();
	        rf = new Reusablefunctions(driver);
	        rf.openBrowser("SiteURL");     
	    }
	   @AfterClass
	   public void teardown()
	   {
		   driver.quit();
	   }
	  
	   
  
	   
	   
	   
	   
	   

	   
	   
	   

}
