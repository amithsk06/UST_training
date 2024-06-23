package com.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableFunctions;
import com.utilities.FileIO;

public class ProductPage {
	static WebDriver driver;
	ReusableFunctions functions=new ReusableFunctions(driver);
	Properties prop = FileIO.getProperties();

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='Catalog']//child::a[1]")
	WebElement fish_1;
	@FindBy(xpath="(//div[@id='Catalog']//td[5]/a[1])[1]")
	WebElement addtocart;
	@FindBy(xpath="//form[@method='post']/table/tbody/tr[2]/td[3]")
	WebElement fishname;
	@FindBy(xpath="(//img)[1]")
	WebElement home;
	
	//click the fish
	public void click_fish1()
	{
		functions.clickOn(fish_1,2);
	}
	public String getfishname()
	{
		return functions.getTextofElement(fish_1);
	}
	public void click_addtocart()
	{
		functions.clickOn(addtocart,1);
	}	
	public String get_fishname()
	{
		return functions.getTextofElement(fishname);
	}
	public void returnhome()
	{
		functions.clickOn(home,1);
	}
}
