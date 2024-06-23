package stepdefinitions;


import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ust.base.ReusableFunctions;
import com.ust.pom.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks{

	    public static WebDriver driver;
	    ReusableFunctions reuse;
//	    private ExtentReports extent;
//	    private ExtentTest test;
	    HomePage homePage;
	    ReusableFunctions functions;
	    int i=0;

	    @Before
	    public void setup(){
	    	 functions=new ReusableFunctions(driver);
	    	driver= functions.invokeBrowser("BROWSER");    
	    	functions.openBrowser("BASE_URL");
	    	homePage=new HomePage(driver);
	    }
	//	    homePage.closeOffers();

	        //Initialize the Extent reports with the HTML reporter
//	        ExtentSparkReporter reporter = new ExtentSparkReporter("extent.html");
//	        extent = new ExtentReports();
//	        extent.attachReporter(reporter);
//	        //create a new test
//	        test = extent.createTest("Project");
//
//	    }
//	    
//	    
//	    
	   @After
	    public void closeBrowser(Scenario scenario) {
		   System.out.println(scenario.getName());
		   String filename = System.getProperty("user.dir")+"/screenshots/cucumber/"+scenario.getName();
		 //validate if scenario has failed
			if(scenario.isFailed()) {
				functions.takeScreenShot(filename+"_failed.png");
			}
			else
				functions.takeScreenShot(filename+"_success.png");
			
        
	       driver.quit();  //make this in another function in resuable
    }


//	    @After
//	    public void teardown() {
//	    	 driver.quit();
//	    }

	}

