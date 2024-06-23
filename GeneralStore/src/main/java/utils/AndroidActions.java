package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidActions extends AppiumUtils{
	
	public AndroidDriver driver;
    public static AppiumDriverLocalService service;
    WebDriverWait wait;
    public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	
	public AndroidActions(AndroidDriver driver)
	{
	
		this.driver = driver;
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	

	public void scrollToEndAction(WebDriver driver)
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	
	public WebElement scrollToText(String text)
	{
		
		return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	
	
	public void swipeAction(WebElement ele,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void dragDrop(WebElement source, int first, int second) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement) source).getId(),
				"endX", first,
				"endY", second 
				));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void startServer() {
  	   if (service == null) {
             AppiumServiceBuilder builder = new AppiumServiceBuilder()
                 .withAppiumJS(new File("C:\\Users\\268896\\node_modules\\appium\\build\\lib\\main.js")) // Path to appium.js
                 .withTimeout(Duration.ofSeconds(60)) // Increase the timeout to 60 seconds
                 .usingAnyFreePort()
                 .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                 .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
             service = AppiumDriverLocalService.buildService(builder);
         }
      service.start();
      System.out.println("Appium Server is Started");
      System.out.println(service.getUrl().getPort());
	 }
	
	 public static void stopServer() {
	      if (service != null && service.isRunning()) {
	          service.stop();
	          System.out.println("Appium Server is Stopped");
	      }
	 }
	 
	 public static String getPort() {
	      return service.getUrl().getPort() + "";
	}
	 
	
	 public static void tap(AppiumDriver driver, int x, int y) {
		    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		    Sequence sequence = new Sequence(finger, 1)
		            .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger, Duration.ofMillis(150)))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		    driver.perform(Collections.singletonList(sequence));
		    System.out.println("Tap with Coordinates");
		}
	 
	 public void waitForElementToDisplay(WebElement element) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/******** send search element ***************/
		public void setTextToInputField(WebElement element, String text) {
			waitForElementToDisplay(element);
			element.clear();
			element.sendKeys(text);
		}
		// *********************click elemet***********************
		public void clickOnElement(WebElement element) {
			waitForElementToDisplay(element);
			element.click();
		}
		// ********************* Get Text ***********************
		public String ReturnGetText(WebElement element) {
			waitForElementToDisplay(element);
			return element.getText();
		}
		// ********************** Action *******************
		public void HoldTheElement(WebElement element, WebElement newoption) {
			waitForElementToDisplay(element);
			element.click();
			waitForElementToDisplay(newoption);
			newoption.click();
		}
		public void clearInput(WebElement element) {
			waitForElementToDisplay(element);
			element.clear();
		}
		public boolean isDisplayed(WebElement element) {
			waitForElementToDisplay(element);
			return element.isDisplayed();
		}
		public boolean isEnabled(WebElement element) {
			waitForElementToDisplay(element);
			return element.isEnabled();
		}
		/************** Take screenshot ****************/
		public static void takeScreenShot(AndroidDriver driver,String filepath) {
//			System.out.println("filepath:  " + filepath);
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			// Generate a timestamp
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			// Append the timestamp to the filename
			String fileNameWithTimestamp = "screenshot_" + timestamp + ".png";
			// Construct the destination file path with the unique filename
			File destFile = new File(filepath + File.separator + fileNameWithTimestamp);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public static ExtentReports report(String string) {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\TestngReports\\" + string);
			ExtentReports reports = new ExtentReports();
			reports.attachReporter(htmlReporter);
			// add environtment variables
			reports.setSystemInfo("OS", "Windows");
			reports.setSystemInfo("Browser", "chrome");
			reports.setSystemInfo("Environment", "QA");
			reports.setSystemInfo("user", "nabil ");
			// configuration look
			htmlReporter.config().setDocumentTitle("Report");
			htmlReporter.config().setReportName("Report");
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("EEE,MMM dd, yyyy, hh:mm a '('zzz')'");
			return reports;
		}
		
		public void dragAndDrop(WebElement element,int x,int y) {
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		public void clickTwoElement(WebElement element, WebElement element2) {
			waitForElementToDisplay(element);
			element.click();
			waitForElementToDisplay(element2);
			element2.click();
		}
		public void scrollToElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		public void scrollByPixel(int x, int y) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + x + ", " + y + ");", "");
		}
		public void takeADelay(int i) {
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void refresh() {
			driver.navigate().refresh();
		}
		public void setTextToInputFieldandEnter(WebElement element, String text) {
			waitForElementToDisplay(element);
			element.clear();
			element.sendKeys(text);
			element.sendKeys(Keys.ENTER); // Press "Enter" key after sending text
		}
		// ************* mouse Element Click ******************
		public void actionClick(WebElement element) {
			waitForElementToDisplay(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		}
		
		/************** Take screenshot ****************/
		public void takeScreenShot(String filepath) {
//			System.out.println("filepath:  " + filepath);
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			// Generate a timestamp
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			// Append the timestamp to the filename
			String fileNameWithTimestamp = "screenshot_" + timestamp + ".png";
			// Construct the destination file path with the unique filename
			File destFile = new File(filepath + File.separator + fileNameWithTimestamp);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// Method to tap by coordinates
		public void tapByCoordinates(int x, int y) {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence tap = new Sequence(finger, 1)
					.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
					.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
					.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			driver.perform(Collections.singletonList(tap));
		}


}
