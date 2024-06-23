package com.ust.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.base.Reusablefunctions;

public class SearchPage {
	WebDriver driver;
	Reusablefunctions rf=new Reusablefunctions(driver);
	
	 //creating a constructor//
	   public SearchPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	   
	   @FindBy(linkText="Cargo Pants")
	   WebElement CargoPants;
	   @FindBy(xpath="(//div[@class='filter-options display'])[2]/a[2]")
	   WebElement Size;
	   @FindBy(xpath="(//div[@class='products'])[1]")
	   WebElement product;
	   
	   
	   
	   
	   
	   public void filtering() throws InterruptedException
	   {
		   rf=new Reusablefunctions(driver);
		   rf.jsClickOn(CargoPants,2);
		   rf.delay(2);
		   rf.mouseAction(Size);
		   rf.delay(2);
	   }
	   public void clickingProduct()
	   {
		   rf.mouseAction(product);
	   }
	   
	   

}
