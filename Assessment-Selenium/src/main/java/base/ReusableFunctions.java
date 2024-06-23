package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.FileIO;

public class ReusableFunctions 
{
	private static WebDriver driver;
	private WebDriverWait wait;
	public static Properties prop;
	public static String browser_choice;
	
	public ReusableFunctions(WebDriver driver) 
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		prop = FileIO.getProperties();
	}
	
	//for invoking the browser with the data from config properties
	public static WebDriver invokeBrowser() 
	{
		if(prop==null)
		{
			prop=FileIO.getProperties();
		}
		browser_choice = prop.getProperty("browser");
		System.out.println("Test_Browser: "+ browser_choice);
		try 
		{
			if (browser_choice.equalsIgnoreCase("edge")) 
			{
				driver = Driver_Setup.invokeEdgebrowser();
			} 
			else if (browser_choice.equalsIgnoreCase("chrome"))
			{
				driver = Driver_Setup.invokeChromebrowser();
			} 
			else
			{
				throw new Exception("Invalid browser name provided in property file");
			}
		}
		catch (Exception e) 
		{
				e.printStackTrace();
		}
		
		return driver;
	}
	
	//method to retrive the test_url from config properties
	public void openBrowser(String websiteUrlKey) 
	{
		if (prop == null) 
		{
	        prop = FileIO.getProperties();
	    }
		try {
			System.out.println("Test_url: "+prop.getProperty(websiteUrlKey));
			driver.get(prop.getProperty(websiteUrlKey));

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//for clicking a webelement 
	public static void clickOn(By locator, Duration timeout) 
	{
		try 
		{
			new WebDriverWait(driver, timeout).until(ExpectedConditions
					.elementToBeClickable(locator));
			driver.findElement(locator).click();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	//sending text to web element
	public static void sendText(WebElement element, String text) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}

