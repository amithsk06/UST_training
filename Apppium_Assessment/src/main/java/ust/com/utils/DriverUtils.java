package ust.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DriverUtils {
	
	public static AndroidDriver driver;
	public static WebElement timeUsingDynamicXpath(String time) {
		try {
		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'"+time+"')]"));
		element.isDisplayed();
		return element;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public static WebElement itemUsingDynamicXpath(String item) {
		try {
		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text =\""+item+"\"]/following-sibling::android.widget.LinearLayout[2]/android.widget.TextView[2]"));
		element.isDisplayed();
		return element;
		}
		catch(Exception e) {
			return null;
		}
	}
	
    public static WebElement countryUsingDynamicXpath(String country) {
    	try {
//    		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@text='"+country+"']"));
    		WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text('"+country+"')"));
    		element.isDisplayed();
    		return element;
    		}
    		catch(Exception e) {
    			return null;
    		}
    	} 	
    
    public static WebElement numberUsingDynamicXpath(String num) {
//    	WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='"+num+"']"));
    	WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+num+"\")"));
    	return element;
    }
}
