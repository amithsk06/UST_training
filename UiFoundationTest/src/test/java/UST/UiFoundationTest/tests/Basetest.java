package UST.UiFoundationTest.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import UST.UiFoundationTest.base.Reusablefunctions;
import UST.UiFoundationTest.utilities.Extentreportlistener;

@Listeners(Extentreportlistener.class)
public class Basetest {

	 public static WebDriver driver;
	 public Reusablefunctions reusableFunctions;
	 
	   @BeforeClass
	    public void before() {
	        driver = Reusablefunctions.invokeBrowser();
	        reusableFunctions = new Reusablefunctions(driver);
	        reusableFunctions.openBrowser("SiteURL");
	       
	    }
	   @Test
	   public void openTestSite() {
          
          System.out.println("");
       }
	   @Test
	   public void openTestSite1() {
          
          assertTrue(false);
       }
	   
	   
	   
	   
	   
	   
	   
	   
//	   @Test(priority=3,dataProvider = "Data",dataProviderClass = DataProviders.class)
//		public void adding_new_address(String data1,String data2,String data3,String data4,String data5)
//		{
//			account.new_address_details(data1, data2, data3, data4, data5);
//		}
}
