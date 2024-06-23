package step_definitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;


@Listeners(ust.com.utils.ExtentReportsListener.class)
public class Hooks implements ITestListener {
    public static AndroidDriver driver;
    ExtentReports extent;
    ExtentTest test;
    
    @Before
	public void setup() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel_6");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://10.11.70.152:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
 
    @After
    public void closeBrowser(){
    	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Date d1 = new Date();
			FileUtils.copyFile(screenshot, new File("screenshots/" + d1.getTime() + "ss.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	
    }

}