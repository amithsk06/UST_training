package com.ust.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;
import com.ust.utilities.FileIO;

public class WishlistPage {
	WebDriver driver;
	ReusableFunctions functions;
	Properties prop;
	public WishlistPage(WebDriver driver)
	{
		this.driver=driver;
		functions=new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
		prop=FileIO.getProperties();
	}
	

	
	//locators in wishlist page-----//
	
	@FindBy(className="wishlist-product-count")
	WebElement count;
	@FindBy(xpath="(//span[@class='base'])[2]")
	WebElement wishlist_msg;
	@FindBy(xpath="(//a[@href='https://www.forestessentialsindia.com/soundarya-radiance-cream-with-24k-gold-spf-25.html'])[2]")
	WebElement wishlisted_item1name;
	@FindBy(xpath="(//a[@href='https://www.forestessentialsindia.com/hydrating-facial-moisturiser-sandalwood-orange-peel-130ml.html'])[4]")
	WebElement wishlisted_item2name;
	@FindBy(css="a[pid='1299']")
	WebElement remove_item1;
	@FindBy(css="button[pid='1093']")
	WebElement item2_movetoBag;
	
	
	
	//---returning the count of item in wishlist for asserting-----//
	public String[] wishlist_count()
	{
		String item_count=functions.getTextofElement(count);
		String[] c=item_count.split("\\W+");
		String heading=functions.getTextofElement(wishlist_msg);
		String[] list= {heading,c[1]};
		return list;		
	}
	
	//getting name of wishlisted item
	public String wishlisted_item1()
	{
		String item_n=functions.getTextofElement(wishlisted_item1name);
		return item_n;
	}
	public String wishlisted_item2()
	{
		String item_n=functions.getTextofElement(wishlisted_item2name);
		return item_n;
	}
	
	//removing item1 from wishlist
	public void removing_item1()
	{
		functions.delay(3);
		functions.mouseAction(remove_item1);
		functions.refreshthescreen();
		functions.delay(3);
	}
	
	//moving item2 to bag
	public void movetoBag()
	{
		functions.delay(3);
        functions.clickOn(item2_movetoBag, 2);
	}
}
