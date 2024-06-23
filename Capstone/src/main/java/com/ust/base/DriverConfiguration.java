package com.ust.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverConfiguration{
	
	
	static  WebDriver driver;
	public static WebDriver invokeChrome() {
	ChromeOptions opt = new ChromeOptions();
    opt.addArguments("--disable-notifications");
    driver = new ChromeDriver(opt);
    driver.manage().window().maximize();
    return driver;
    
}

public static  WebDriver invokeEdge() {
	EdgeOptions edgeOptions = new EdgeOptions();
    edgeOptions.addArguments("--disable-notifications");
    edgeOptions.addArguments("--guest");
    driver = new EdgeDriver(edgeOptions);
    driver.manage().window().maximize();
    return driver;
   
}
}