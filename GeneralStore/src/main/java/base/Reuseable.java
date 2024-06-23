package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Reuseable {
		private static WebDriver driver;
		public static String browser;
		
		
		/**
	     * Constructor for Reuseable class.
	     * @param driver The WebDriver object.
	     */
		public Reuseable(WebDriver driver) {
			this.driver = driver;
		}
		
		/**
		 * Method to take a screenshot.
		 * @param driver The WebDriver object.
		 * @param filepath The file path where the screenshot will be saved.
		 * @return True if the screenshot is taken successfully, false otherwise.
		 */
		public static void takeScreenShot(String filepath) {
			TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filepath);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Waits for the given WebElement to be clickable for the specified duration.
		 * @param element The WebElement to wait for.
		 * @param sec The duration in seconds to wait for the element to be clickable.
		 * @return The clickable WebElement if found within the specified duration, null otherwise.
		 */
		public static WebElement waitPgm(WebElement element, int sec) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			WebElement res = wait.until(ExpectedConditions.elementToBeClickable(element));
			return res;
		}
		
}
