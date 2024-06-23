package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.aeonbits.owner.ConfigCache;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import utilities.FileIO;

public class ReusableFunctions {
	private static WebDriver driver;
	private WebDriverWait wait;
	public static Properties prop;
	public static String browser_choice;
    public static final TestConfig testConfigProperties = ConfigCache.getOrCreate(TestConfig.class);


	public ReusableFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prop = FileIO.getProperties();
	}

	// -----for invoking the browser with the data from config properties-----//
//	public static WebDriver invokeBrowser() {
//		if (prop == null) {
//			prop = FileIO.getProperties();
//		}
//		browser_choice = prop.getProperty("browser");
//		System.out.println("Test_Browser: " +testConfigProperties.browser());
//		try {
//			if (browser_choice.equalsIgnoreCase("edge")) {
//				driver = Driver_Setup.invokeEdgebrowser();
//			} else {
//				throw new Exception("Invalid browser name provided in property file");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return driver;
//	}

	// -----method to retrive the test_url from config properties-----//
	public void openBrowser() {
		
		System.out.println("Test_url: " +(testConfigProperties.baseUrl()));
		driver.get(testConfigProperties.baseUrl());		
	}

	// -----for clicking a webelement-----//
	public static void clickOn(WebElement element, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// -----sending text to web element----//
	public static void sendText(WebElement element, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	//---------getting the text of WebElement----------//
	public static String getText(By locator) {
		String text = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
			text = driver.findElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		return text;
	}
	
	//--------take a screenshot----//
	public static void takeScreenShot(String filepath) {
		TakesScreenshot takeScreenShot=(TakesScreenshot) driver;
		File srcFile=takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filepath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
