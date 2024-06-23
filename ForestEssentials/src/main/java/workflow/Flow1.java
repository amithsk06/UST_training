package workflow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;
import utilities.FileIO;

public class Flow1 {
	public static WebDriver driver;
	public static ReusableFunctions reuse;
	Properties prop = FileIO.getProperties();
	String str;
	

	public Flow1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href=\"/fragrances.html\"][@class='ms-label ']")
	WebElement fragrance;
	@FindBy(xpath="/html/body/div[3]/aside[2]/div[2]/header/button")
	WebElement adclose;
	@FindBy(className="product-item-link")
	List<WebElement> arr;
	
	public void adHandling()
	{
		String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
		    if (!window.equals(currentWindow)) {
		        driver.switchTo().window(window);
		    }
		}
		reuse.clickOn(adclose, Duration.ofSeconds(10));
	}
	public void fragrance()
	{
		reuse.clickOn(fragrance,Duration.ofSeconds(4));;
	}
	public void frag_list()
	{
		for(WebElement w:arr)
		{
			if(prop.getProperty("item1").equals(w.getText()))
			{
				System.out.println(w);
				reuse.clickOn(w, Duration.ofSeconds(9));
			}
			else
			{
				System.out.println("Not");
			}
		}
		
	}

}
