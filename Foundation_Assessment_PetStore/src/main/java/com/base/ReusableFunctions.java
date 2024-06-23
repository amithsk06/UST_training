package com.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.FileIO;

public class ReusableFunctions 
{
	private static WebDriver driver;
	private WebDriverWait wait;
	String browser_choice;
	Properties prop;
	
	public ReusableFunctions(WebDriver driver) 
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prop = FileIO.getProperties();
	}
	
	// -----for invoking the browser with the data from config properties-----//
		public  WebDriver invokeBrowser() {
			if (prop == null) {
				prop = FileIO.getProperties();
			}
			browser_choice = prop.getProperty("browser");
			System.out.println("Test_Browser: " + browser_choice);
			try {
				if (browser_choice.equalsIgnoreCase("edge")) {
					driver = Driver_Setup.invokeEdgebrowser();
				} else if (browser_choice.equalsIgnoreCase("chrome")) {
					driver = Driver_Setup.invokeChromebrowser();
				} else {
					throw new Exception("Invalid browser name provided in property file");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return driver;
		}

		// -----method to retrive the test_url from config properties-----//
		public void openBrowser(String websiteUrlKey) {
			if (prop == null) {
				prop = FileIO.getProperties();
			}
			try {
				System.out.println("Test_url: " + prop.getProperty(websiteUrlKey));
				driver.get(prop.getProperty(websiteUrlKey));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/************** Click on element with WebElement ****************/
		public void clickOn(WebElement opt, long num) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(num)).until(ExpectedConditions.elementToBeClickable(opt));
				opt.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/************** Send text to an element ****************/
		public void sendText(WebElement element, String text) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
				element.sendKeys(text);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*********clear text***********/
		public void clearText(WebElement element)
		{
			element.clear();
		}
		
		/************** Get text of element ****************/
		public String getTextofElement(WebElement locator) {
			String text = null;
			try {
				new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(locator));
				text = locator.getText();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return text;
		}
		
		/************** Take screenshot ****************/
		public void takeScreenShot(String filepath) {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filepath);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
}