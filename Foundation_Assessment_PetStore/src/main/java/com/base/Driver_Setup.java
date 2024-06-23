package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver_Setup {
	public static WebDriver driver;
	
	//method for invoking the browser
	public static WebDriver invokeEdgebrowser() 
	{
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--guest");
		driver = new EdgeDriver(options);
		return driver;
	}
	public static WebDriver invokeChromebrowser() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		return driver;
	}

}
