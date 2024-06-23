package com.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.ReusableFunctions;
import com.pom.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	    public static WebDriver driver;
	    ReusableFunctions functions;
	    private ExtentReports extent;
	    private ExtentTest test;
	    HomePage homePage;
	    int i=1;

	    @Before
	    public void setup(){
	    	 functions=new ReusableFunctions(driver);
	    	driver= functions.invokeBrowser();    
	    	functions.openBrowser("test_url");
	    	homePage=new HomePage(driver);
	    	//Initialize the Extent reports with the HTML reporter
	        ExtentSparkReporter reporter = new ExtentSparkReporter("extent.html");
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        //create a new test
	        test = extent.createTest("Project");
	    }
	    @After
	    public void closeBrowser(Scenario scenario) throws InterruptedException, IOException{
	        if (scenario.isFailed()) {
	           //Take the screenshot
	            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            
	            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/screenshots/"+ i++ +".png"));
	            
	            
	            
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
