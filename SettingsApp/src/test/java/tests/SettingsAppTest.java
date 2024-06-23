package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.it.Date;
import pom.HomePage;
import ust.SettingsApp.AppiumServerManager;
import utilities.FileIO;

@Listeners(utilities.ExtentReportsListener.class)
public class SettingsAppTest {
	public static AndroidDriver driver;
    Properties properties ;
    HomePage homePage;
    static int i=0;
	

	@BeforeTest
	public void setup() throws MalformedURLException {
		properties= FileIO.getProperties();
		String port = AppiumServerManager.startServer();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(properties.getProperty("deviceName"));
		options.setAppPackage(properties.getProperty("appPackage"));
		options.setAppActivity(properties.getProperty("appActivity"));
		options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://127.0.0.1:"+ port), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);
		
	}
	
	@Test(priority=1)
	public void searchBoxClickTest() {
		homePage.searchClick();
		takeScreenshot();
		
	}
	@Test(priority=2)
	public void searchWithNullTest() {
		homePage.searchWithNull();
		assertTrue(homePage.noResult().isDisplayed());
		takeScreenshot();
	}
	@Test(priority=3)
	public void searchWithCorrectTest() {
		
		homePage.searchWithCorrect();
		System.out.println(homePage.searchDetails().getText());
		assertEquals(homePage.searchDetails().getText(),"Aps");
		takeScreenshot();

	}
	
	
	@AfterTest
	public void stopeServer() {
		AppiumServerManager.stopServer();
		
	}
public static void takeScreenshot() {
	String filepath="C:\\Users\\268859\\Desktop\\mobileaplications\\SettingsApp\\Screenshots";
	TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
	File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
	i++;
	File destFile = new File(filepath+"/"+i+".png");
	try {
	    FileUtils.copyFile(srcFile, destFile);
	} catch (IOException e) {
	    e.printStackTrace();
	}
}

	
	
}
