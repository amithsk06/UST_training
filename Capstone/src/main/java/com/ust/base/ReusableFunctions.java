package com.ust.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ust.utilities.FileIO;

public class ReusableFunctions {
	private static WebDriver driver;
	private WebDriverWait wait;
	String browser_choice;
	Properties prop;

	public ReusableFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prop = FileIO.getProperties();
	}

	public  WebDriver invokeBrowser2(String browser) {
		if (browser.equals("edge")) {
			driver = DriverConfiguration.invokeEdge();
		} else
			driver = DriverConfiguration.invokeChrome();
		return driver;

	}

	// -----for invoking the browser with the data from config properties-----//
	public WebDriver invokeBrowser(String browser) {
		if (prop == null) {
			prop = FileIO.getProperties();
		}
		browser_choice = prop.getProperty(browser);
		System.out.println("Test_Browser: " + browser_choice);
		try {
			if (browser_choice.equalsIgnoreCase("edge")) {
				driver = DriverConfiguration.invokeEdge();
			} else if (browser_choice.equalsIgnoreCase("chrome")) {
				driver = DriverConfiguration.invokeChrome();
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

	/************** Switch to prev tab ****************/
	public static void switchToPrevTab() {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.close();
			driver.switchTo().window(tabs.get(tabs.size() - 2));
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	/************** Get list of web elements ****************/
	public static List<WebElement> getListOfElements(List<WebElement> element) {
		List<WebElement> list = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.visibilityOfAllElements(element));
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		list.addAll(element);
		
		return list;
	}

	/************** Check if an element is present ****************/
	public static boolean isElementPresent(By locator, long timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout))
					.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/************** Send text to an element ****************/
	public void sendText(WebElement element, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
//			driver.findElement(locator).sendKeys(text);
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	/************** Get text of element ****************/
	public String getText(By locator) {
		String text = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.presenceOfElementLocated(locator));
			text = driver.findElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return text;
	}

	/************** Get text of element ****************/
	public String getTextofElement(WebElement locator) {
		String text = null;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(locator));
			text = locator.getText();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
		return text;
	}

	/************** Click on element with By ****************/
	public void clickOn(By locator, long timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
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

	/************** Click on element with WebElement ****************/
	public void clickOnVisibility(WebElement opt, long num) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(num)).until(ExpectedConditions.visibilityOf(opt));
			opt.click();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	/************** Click on element with Actions ****************/
	public void clickAction(By locator, long timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout))
					.until(ExpectedConditions.elementToBeClickable(locator));
			Actions action = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
			jse.executeScript("window.scrollBy(0,-150)");
			action.moveToElement(driver.findElement(locator)).build().perform();
//			action.click(driver.findElement(locator)).build().perform();
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
//			action.click(driver.findElement(locator)).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	/************** Click on element with JavaScript ****************/
	public void clickJS(By locator, long timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout))
					.until(ExpectedConditions.elementToBeClickable(locator));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
			jse.executeScript("arguments[0].click", driver.findElement(locator));
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	/************** Click on element with JavaScript ****************/
	public void clickJS(WebElement e) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", e);
		} catch (Exception ex) {
			ex.printStackTrace();
			reportFail(ex.getMessage());
		}
	}

	/************** Switch to another frame ****************/
	public void switchToFrame(By locator) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(30))
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(e.getMessage());
		}
	}

	/************** Wait for document to be in ready state ****************/
	public void waitForDocumentReady(long timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));
		} catch (Exception e) {
			e.printStackTrace();

			reportFail(e.getMessage());
		}
	}

	/************** move cursor to an element ****************/
	public void moveCursorToElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/************** Wait for element to display ****************/
	public void waitForElementToDisplay(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/************** Thread Sleep ****************/
	public void delay(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

	/************** Report fail test ****************/
	public static void reportFail(String reportMessage) {
		Assert.fail("Test case failed: " + reportMessage);
	}

	/********* scrolling **********/
	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	// --------to use mouse actions and click------//
	public void mouseAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}

	// ----------to scroll up to element-------//
	public void scrollUpToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
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

	// --------refresh-------//
	public void refreshthescreen() {
		driver.navigate().refresh();
	}

	// -----quit-----//
	public void closeBrowser() {
		driver.quit();
	}
}
