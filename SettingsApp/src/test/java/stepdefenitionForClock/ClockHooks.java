package stepdefenitionForClock;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ust.SettingsApp.AppiumServerManager;
import utilities.FileIO;

public class ClockHooks{
    public static AndroidDriver driver;
    private ExtentReports extent;
   
    
    @Before
	public void setup() throws MalformedURLException {
    	
		String port = AppiumServerManager.startServer();
		UiAutomator2Options options = new UiAutomator2Options();
		 options.setDeviceName("RemyaPhone");
	        options.setAppPackage("com.google.android.deskclock");
	        options.setAppActivity("com.android.deskclock.DeskClock");
	        options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://127.0.0.1:"+ port), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
 
    @After
    public void closeBrowser(){
    	AppiumServerManager.stopServer();
    }

}