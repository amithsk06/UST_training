package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import utilities.FileIO;

public class ReusableFunctions {

	private static WebDriver driver;
	private WebDriverWait wait;
	public static Properties properties;
	public static String browser_choice;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    String timestamp = dateFormat.format(new Date());
	String status=null;
	public ReusableFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		properties = FileIO.getProperties();
	}
	/*********Report fail Test**********/
	public static void reportFail(String message) {
		Assert.fail("Testcase Failed: "+message);
	}
	/*********Invokes the driver**********/
	public static WebDriver invokeBrowser() {
		if(properties==null) {
			properties = FileIO.getProperties();	
		}
		browser_choice = properties.getProperty("browser");
		try {
			if (browser_choice.equalsIgnoreCase("chrome")) {
				driver = DriverSetup.invokeChromeBrowser();
			} else if (browser_choice.equalsIgnoreCase("edge")) {
				driver = DriverSetup.invokeEdgeBrowser();
			}else {
				throw new Exception("Invalid browser name provided in property file");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return driver;
	}
	
	/**********open website*********/
	public void openWebsite(WebDriver driver) {
		if(properties == null) {
			properties= FileIO.getProperties();
		}
		try {
			driver.get(properties.getProperty("url"));
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/**********Navigates to website*********/
	public void navtoWebsite(WebDriver driver) {
		if(properties == null) {
			properties= FileIO.getProperties();
		}
		try {
			driver.navigate().to(properties.getProperty("url"));
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/**********wait for the element to display on the page*********/
	public void waitForElementToDisplay(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**********set text to any input field*********/
	public void setTextToInputField(WebElement element, String text) {
		waitForElementToDisplay(element);
	    element.clear();
	    element.sendKeys(text);
	}
	/**********click on any element*********/
	public void clickOnElement(WebElement element) {
		waitForElementToDisplay(element);
		element.click();
	}
	/********** close driver **********/
	public void closethedriver() {
		driver.quit();
	}
	/********** Get the element text **********/
	public String gettheText(WebElement element) {
		return element.getText();
	}
	public String geturl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	/********** Captures Screenshot of Success Case **********/
	public void captureScreenshotofSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			status="Passed";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\"+status+"-"+ timestamp+ "ss.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/********** Captures Screenshot of Failed Case **********/
	public void captureScreenshotOfFail(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			status="Failed";
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\"+status+"-"+ timestamp+ "ss.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}


