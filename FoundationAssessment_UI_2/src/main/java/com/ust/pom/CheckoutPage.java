package com.ust.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ust.base.Reusablefunctions;

public class CheckoutPage {
	
	static WebDriver driver;
	Reusablefunctions rf=new Reusablefunctions(driver);
	
	 public CheckoutPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	 }
	 
	 //locating elements with xpath with formats of child/preceeding
	 @FindBy(xpath="//div[@class='price-detail']/strong")
	 WebElement price;
	 @FindBy(xpath=" (//div[@class='mrp-text'])[4]/span[2]")
	 WebElement checkprice;
	 //locating elements in checkout page 
	 @FindBy(css="a[class='checkout-btn'")
	 WebElement checkoutbtn;
	 @FindBy(xpath="(//input[@type='text'])[1]")
	 WebElement firstname;
	 @FindBy(xpath="(//input[@type='text'])[2]")
	 WebElement lastname;
	 @FindBy(xpath="(//input[@type='text'])[3]")
	 WebElement email;
	 @FindBy(xpath="//input[@type='number']")
	 WebElement phoneno;
	 @FindBy(xpath="//input[@type='tel']")
	 WebElement pincode;
	 @FindBy(xpath="(//input[@type='text'])[5]")
	 WebElement town;
	 @FindBy(xpath="(//input[@type='text'])[6]")
	 WebElement city;
	 @FindBy(xpath="(//input[@type='text'])[7]")
	 WebElement state;
	 @FindBy(xpath="(//input[@type='text'])[8]")
	 WebElement address;
	 @FindBy(css="button[class='checkout-btn']")
	 WebElement paymentbtn;
	
	 
	 
	 
	 
	 //returning the item price
	 public String getPrice()
	 {
		 return rf.getTextofElement(price);
	 }
	 //returning the cart's item price
	 public String getCheckPrice()
	 {
		 return rf.getTextofElement(checkprice);
	 }
	 public void checkingOut()
	 {
		 rf=new Reusablefunctions(driver);
		 rf.jsClickOn(checkoutbtn,1);
	 }
	 
	 public void new_address_details(String data1, String data2,String data3,String data4,String data5,String data6,String data7,String data8,String data9) throws InterruptedException
	 {
		 rf.delay(2);
		 firstname.sendKeys(data1);
		 lastname.sendKeys(data2);
		 email.sendKeys(data3);
		 phoneno.sendKeys(data4);
		 pincode.sendKeys(data5);
		 town.sendKeys(data6);
		 address.sendKeys(data9);
	 }
	 public void proceedTopayment()
	 {
		 rf.mouseAction(paymentbtn);
	 }
	 

}
