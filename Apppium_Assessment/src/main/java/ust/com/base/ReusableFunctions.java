package ust.com.base;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ust.com.utils.FileIO;
 

public class ReusableFunctions {

	public  AndroidDriver driver;
	public WebDriverWait wait;
	Properties prop=FileIO.getProperties();
	
	public ReusableFunctions(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	public void setImplicitWait(int num) {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
        }
    }
    public void setExplicitWait(WebElement element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected AndroidDriver getDriver() {
		return driver;
	}
    
    public void clickGo() {
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
    }
    
    public void clickElement(WebElement element) {
    	setExplicitWait(element);
    	element.click();
    }
    
   public void sendText(WebElement element , String text) {
	   setExplicitWait(element);
	   element.sendKeys(text);
   }
   
   public void clickUsingtext(AndroidDriver driver,String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+text+"\")")).click();
   }
   public static void waits(int num) {
	   try {
		Thread.sleep(num*1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
   }
   
   public static void takeScreenshot(AndroidDriver driver,String filepath) {
	   	TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
	       File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
	       File destFile = new File(filepath);
	       try {
	           FileUtils.copyFile(srcFile, destFile);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
   
   public static List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
	 //System.getProperty("user.dir")+"/src/main/resources/Testdata/Data.json"
	 		// conver json file content to json string
	 		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
	 		ObjectMapper mapper = new ObjectMapper();
	 		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
	 				new TypeReference<List<HashMap<String, String>>>() {
	 				});
	 		return data;
	 	}
   
   /************** delay with locator ****************/
	public static void delay(long timeout) throws InterruptedException {

		Thread.sleep(timeout*1000);
	
	}
}
