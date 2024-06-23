package ust.com.basetest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import ust.com.utils.FileIO;

public class BaseTest {
	public AndroidDriver driver;
	Properties prop=FileIO.getProperties();

	@BeforeMethod
	public AndroidDriver invokeDriver() {
		try {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("DEVICE_NAME"));
		options.setPlatformName(prop.getProperty("PLATFORM_NAME"));
		options.setAppPackage(prop.getProperty("APP_PACKAGE"));
		options.setAppActivity(prop.getProperty("APP_ACTIVITY"));
		driver = new AndroidDriver(new URL(prop.getProperty("PORT")),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
		
	}
	
	@AfterMethod
	public void after(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				Date d1 = new Date();
				FileUtils.copyFile(screenshot, new File("screenshots/" + d1.getTime() + "ss.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
