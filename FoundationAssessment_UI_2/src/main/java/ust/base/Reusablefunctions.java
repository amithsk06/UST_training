package ust.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ust.utilities.FileIO;



public class Reusablefunctions {

	private static WebDriver driver;
	public static Properties prop;
	public static String browser_choice;

	public Reusablefunctions(WebDriver driver) {
		Reusablefunctions.driver = driver;
		new WebDriverWait(driver, Duration.ofSeconds(10));
		prop = FileIO.getProperties();
	}

	/************** Invoke Browser ****************/
	public static WebDriver invokeBrowser() {
		if(prop==null)
		{
			prop=FileIO.getProperties();
		}
		browser_choice = prop.getProperty("browserName");
		try {
			if (browser_choice.equalsIgnoreCase("msedge")) {
				driver = Driversetup.invokeEdgeBrowser();
			} else if (browser_choice.equalsIgnoreCase("chrome")){
				driver = Driversetup.invokeChromeBrowser();
			} else{
				throw new Exception("Invalid browser name provided in property file");
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		return driver;
	}
	
	public  WebDriver invokeBrowser2(String browser) {
		if (browser.equals("edge")) {
			driver = Driversetup.invokeEdgeBrowser();
		} else
			driver = Driversetup.invokeChromeBrowser();
		return driver;

	}
	
	
	
	/************** Open website URL ****************/
	public void openBrowser(String websiteUrlKey) {
		if (prop == null) {
	        prop = FileIO.getProperties();
	    }
		try {
			driver.get(prop.getProperty(websiteUrlKey));

		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	
	
	/************** Send text to an element ****************/
	public void sendText(WebElement element, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	
	/************** Send text to an element and click enter ****************/
	public static void sendTextAndEnter(WebElement element, String text,Keys enter) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(text,enter);

		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}


	/************** Clear Textbox ****************/
	public static void textboxClear(WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** Get text of element ****************/
	public String getTextofElement(WebElement element) {
		String text = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
			text = element.getText();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return text;
	}
	
	/************** Click on element with locator ****************/
	public static void clickOn(WebElement element, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	/************** Click on element with WebElement ****************/
	public void clickOn(WebElement opt, long num) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(num)).until(ExpectedConditions.elementToBeClickable(opt));
			opt.click();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** Click on element with Actions ****************/
	public void clickAction(WebElement element, long timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout))
					.until(ExpectedConditions.elementToBeClickable(element));
			Actions action = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			jse.executeScript("window.scrollBy(0,-150)");
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	/************** Click on element with JavaScript ****************/
	public static void clickJS(WebElement element, Duration timeout) {
		try {
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.elementToBeClickable(element));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();",
				 element);
			jse.executeScript("arguments[0].click", element);
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	
	
	/************** delay with locator ****************/
	public static void delay(long timeout) throws InterruptedException {

		Thread.sleep(timeout*1000);
	
	}
	
	/************** is display with locator ****************/
	public static boolean isDisplayed(WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return false;
		
	}
	/************** Switch to new tab ****************/
	public static void switchToNewTab() {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(tabs.size() - 1));
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}
	/************** Switch to another frame ****************/
	public void switchToFrame(WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
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
	
	//------method for hovering a webelement-----//
	public void hoverto(WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element);
	}
	
	// -------javascrpit executor--------//
		public void jsClickOn(WebElement element, int delaySeconds) {
			// Execute JavaScript to click the element
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			// Delay
			try {
				Thread.sleep(delaySeconds * 1000); // Convert seconds to milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//clicking an item//
		public void mouseAction(WebElement element)
		{
			Actions a=new Actions(driver);
			a.click(element).build().perform();
		}
	
	/************** Report fail test ****************/
	public static void reportFail(String reportMessage) {
		Assert.fail("Test case failed: " + reportMessage);
	}
}
