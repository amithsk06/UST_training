package com.ust.pom;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;

import utilities.FileIO;

public class CartItembyCategory {
	WebDriver driver;
	ReusableFunctions functions;
	Properties prop=FileIO.getProperties();
	public CartItembyCategory(WebDriver driver)
	{
		this.driver=driver;
		functions=new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='ms-label '])[7]")
	WebElement men;
	@FindBy(xpath="//div[@id='submenu-11']/div/div/div/div[1]/div[2]/div/a[3]")
	WebElement haircare;
	@FindBy(css="span[id='filter_span']")
	WebElement filter;
	@FindBy(xpath = "//input[@value='276']")
	WebElement wavy;
	@FindBy(css="button[id='apply_btn']")
	WebElement apply;
	@FindBy(className="select_expandLabel")
	WebElement sort;
	@FindBy(css="label[id='price-asc']")
	WebElement lowest;
	@FindBy(css="img[alt='Travel Size Ayurvedic Herb Enriched Head Massage Oil Bhringraj']")
	WebElement item;
	@FindBy(css="span[class='base']")
	WebElement current_item_name;
	@FindBy(css="input[id='codvalue']")
	WebElement pincodecheck;
	@FindBy(css="button[id='codcheck-button']")
	WebElement pincodeenter;
	@FindBy(xpath="(//div[@class='msg'])[5]")
	WebElement deliverymsg;
	@FindBy(xpath="(//div[@class='msg'])[4]")
	WebElement deliveryinvalidmsg;
	@FindBy(xpath="(//span[@class='product-sizes'])[2]")
	WebElement weight;
	@FindBy(xpath="(//input[@id='qty'])[2]")
	WebElement number;
	@FindBy(css="button[id='product-addtocart-button-custom']")
	WebElement addtobag;
	@FindBy(xpath="(//span[@class='counter-number'])[1]")
	WebElement countnumber;
	public void menoption()
	{
		functions.moveCursorToElement(driver, men);
	}
	public void haircare()
	{
		functions.clickOn(haircare, 3);
	}
	
	public void searching()
	{
		functions.clickOn(filter, 3);
		
	}
	public void sorting()
	{
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(sort).click().build().perform();
		functions.clickOn(sort, 3);
		functions.clickOn(lowest, 3);		 
	}
	public String get_item_name()
	{
		String s=item.getAttribute("alt");
		System.out.println(s);
		return s;
	}
	public void item_click()
	{	
		functions.clickOn(item, 3);		
	}
	public String getCurrent_ItemName()
	{
		String current_name=functions.getTextofElement(current_item_name);
		return current_name;
	}
	public void deliverycheck()
	{
		String pincode=prop.getProperty("PINCODE");
		functions.sendText(pincodecheck, pincode);
		functions.delay(4);
		functions.clickOn(pincodeenter, 3);
	}
	public String deliveryresult()
	{
		String message=functions.getTextofElement(deliverymsg);
		return message;	
	}
	public String deliveryresultInvalid()
	{
		String message=functions.getTextofElement(deliveryinvalidmsg);
		return message;	
	}
	
	public void deliverycheckInvalid()
	{
		String pincode=prop.getProperty("INVALID_PINCODE");
		functions.sendText(pincodecheck, pincode);
		functions.delay(4);
		functions.clickOn(pincodeenter, 3);
		
	}
	public void item_size_and_number()
	{
		functions.clickOn(weight, 3);
		functions.delay(5);
		number.clear();
		functions.sendText(number, "2");
	}
	public void item_size_and_number_Invalid()
	{
		number.clear();
		functions.sendText(number, "1.5");
	}
	public void addingtobag()
	{
		number.sendKeys(Keys.ENTER);
	}
	public String bag_count_number()
	{
		functions.delay(3);
		String count=functions.getTextofElement(countnumber);
		return count;
	}
	
}


