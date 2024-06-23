package com.ust.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.base.Reusablefunctions;

public class ItemPage {
	static WebDriver driver;
	Reusablefunctions rf=new Reusablefunctions(driver);
	
	 public ItemPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

	//locating elements in Item page
	 @FindBy(css="input[id='Dark Olive Green']")
	 WebElement color;
	 @FindBy(xpath="(//div[@class='size ']/p)[1]")
	 WebElement size;
	 @FindBy(linkText = "BUY NOW")
	 WebElement buyNow;
	
	 //locators for product in cucmber testing
	 @FindBy(xpath="(//div[@class='size '])[2]/p")
	 WebElement size1;
	 @FindBy(xpath= "(//div[@class='left'])[3]")
	 WebElement addToCart;
	 
	 
	 //methods for clicking the size and color of the item
	 public void colorSelect()
	 {
		 rf=new Reusablefunctions(driver);
		 rf.jsClickOn(color, 2);
	 }
	 public void sizeSelect()
	 {
		 rf.mouseAction(size);
	 }
	 public void clickBuyNow() {
		 rf.jsClickOn(buyNow, 2);
	 }
	
	 
	 public void addtoCart() throws InterruptedException
	 {
		 rf=new Reusablefunctions(driver);
		 rf.mouseAction(size1);
		 rf.delay(3);
		 rf.jsClickOn(addToCart, 2);
	 }
	 
	 
	 
	 
}
