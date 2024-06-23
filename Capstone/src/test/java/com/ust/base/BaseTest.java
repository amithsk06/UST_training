package com.ust.base;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ust.pom.HomePage;
import com.ust.pom.LoginPage;


public class BaseTest {	
	
	protected static WebDriver driver;

	ReusableFunctions functions;
	public HomePage homePage;
	public LoginPage loginPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void start(String browser) {
		functions=new ReusableFunctions(driver);
		driver = functions.invokeBrowser2(browser);
	    functions.openBrowser("BASE_URL");
	    homePage=new HomePage(driver);

    }
//	@BeforeClass
//	public void start_browser() {
//		functions=new ReusableFunctions(driver);
////		driver=functions.invokeBrowser(browser);		
//		driver = functions.invokeBrowser("BROWSER");
//		functions.openBrowser("BASE_URL");
//		homePage=new HomePage(driver);
//		//    homePage.closeOffers();
//	}
	
	@AfterClass
	public void stop()
{
	functions.closeBrowser();
}
	    
	
}
	

	
	
	



