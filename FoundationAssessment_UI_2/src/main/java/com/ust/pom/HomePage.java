package com.ust.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.base.Reusablefunctions;

public class HomePage {
	static WebDriver driver;
	Reusablefunctions rf=new Reusablefunctions(driver);
	
	
	
	   //creating a constructor//
	   public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	   
	 //locating elements in home page
	   @FindBy(linkText = "Men")
	   WebElement men_option;
	   @FindBy(xpath="//div[@class=\"swiper-slide 2 swiper-slide-next\"]/a")
	   WebElement item1;
	   @FindBy(className = "search-mobile")
	   WebElement searchbtn;
	   @FindBy(xpath="(//input[@type='text'])[1]")
	   WebElement searchbox;
	   
	   
	   
	   
	   
	   
	   //clicking the specified item
	   public void clickitem1()
	   {
		   rf=new Reusablefunctions(driver);
		   rf.jsClickOn(item1, 2);
	   }
	   
	   //clicking search button
	   public void searching(String str)
	   {
		   rf=new Reusablefunctions(driver);
		   rf.mouseAction(searchbtn);
		   rf.sendTextAndEnter(searchbox, str, Keys.ENTER);
		   
	   }
	  
	   

}
