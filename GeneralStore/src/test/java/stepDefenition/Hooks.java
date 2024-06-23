package stepDefenition;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static AndroidDriver driver;

	private ExtentReports extent;
	private ExtentTest test;

	/**
     * Method to setup the WebDriver instance before each scenario.
     */
	@Before
	public void openBrowser() {
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("Pixel_6");
		option.setAppPackage("com.google.android.contacts");
		option.setAppActivity("com.android.contacts.activities.PeopleActivity");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:"+AndroidActions.getPort()+"/") ,options);
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/") ,option);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//code to generate report
		ExtentSparkReporter reporter = new ExtentSparkReporter("CucumberExtent.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// create a new test
		test = extent.createTest("Foundation");
	}

	

	/**
     * Method to capture screenshots and close the browser after each scenario.
     */
	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			//code to take the screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// code to add it to the report
			test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
		} else {
			//code to take the screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Add it to the report
			test.addScreenCaptureFromPath("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot));
			test.pass("Test passed");
		}
		extent.flush();
		driver.quit();
	}

}
