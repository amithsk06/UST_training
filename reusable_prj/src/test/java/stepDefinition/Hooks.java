package stepDefinition;


import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.ReusableFunction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{

	    public static WebDriver driver;

	    private ExtentReports extent;
	    private ExtentTest test;

	    @Before
	    public void setup(){
	    	driver= ReusableFunction.invokeBrowser();
	    	ReusableFunction function = new ReusableFunction(driver);
	    	function.openBrowser("testSiteURL");
//	        driver.manage().window().maximize();
	        //Initialize the Extent reports with the HTML reporter
	        ExtentSparkReporter reporter = new ExtentSparkReporter("extent.html");
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        //create a new test
	        test = extent.createTest("Project");

	    }
	   @After
	    public void closeBrowser(Scenario scenario){
	        if (scenario.isFailed()) {
	           //Take the screenshot
	            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            //Add it to the report
	            test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
	        } else {
	            //Take the screenshot
	            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            //Add it to the report
	            test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
	            test.pass("Test passed");
	        }
	        extent.flush();
	        driver.quit();
	    }



	}

