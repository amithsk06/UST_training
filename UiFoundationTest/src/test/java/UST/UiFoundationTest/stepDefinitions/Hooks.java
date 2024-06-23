package UST.UiFoundationTest.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import UST.UiFoundationTest.base.Reusablefunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	public static WebDriver driver;
	public Reusablefunctions reusableFunctions;
	private ExtentReports extent;
	private ExtentTest test;

	/**
	 * Method to initialize the browser and Extent report before each scenario.
	 */
	@Before
	public void openBrowser() {
		driver = Reusablefunctions.invokeBrowser();
		reusableFunctions = new Reusablefunctions(driver);
		reusableFunctions.openBrowser("SiteURL");

		String repname = "CucumberReport" + getTimeStamp() + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//CucumberReports//" + repname);
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		test = extent.createTest("cucumbertestreport");
	}

	/**
	 * Method to generate timestamp.
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}


	 @After
	    public void closeBrowser(){
	    			java.io.File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    			try {
	    				Date d1 = new Date();
	    				FileUtils.copyFile(screenshotfile, new File("CucumberScreenshots/"+ d1.getTime()+ "ss.jpg"));
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
	        test.pass("Test passed");
	        extent.flush();
	      driver.quit();
	    }
}
