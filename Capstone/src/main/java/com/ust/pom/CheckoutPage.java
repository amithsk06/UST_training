package com.ust.pom;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;
import com.ust.utilities.FileIO;

public class CheckoutPage {
		WebDriver driver;
		ReusableFunctions functions;
		Properties prop;
	//Constructor for the CheckoutPage class
		public CheckoutPage(WebDriver driver)
		{
			this.driver=driver;
			functions=new ReusableFunctions(driver);
			PageFactory.initElements(driver, this);
			prop=FileIO.getProperties();
		}
		
		//locators in checkout page
		//increase the number of products
		@FindBy(css="button[class='button increase-qty hollow square']")
		WebElement increase;
		//quantity of product
		@FindBy(id="cart-10046134-qty")
		WebElement count_txt;
		//price of the product
		@FindBy(xpath="(//span[@class='price'])[10]")
		WebElement price;
		//all total price
		@FindBy(xpath="(//span[@class='price'])[8]")
		WebElement total_price;
		//checkout button
		@FindBy(id="proceed-checkout")
		WebElement checkout_btn;
		
		
		public void increase_the_quantity()
		{
            functions.clickOn(increase,2);
        }
		public String getcount()
		{
			functions.delay(3);
			return count_txt.getAttribute("value");
		}
		public String[] getprice()
		{
			String product_price=functions.getTextofElement(price);
			String t_price=functions.getTextofElement(total_price);
			String[] values= {product_price, t_price};
			return values;
		}
		public void click_checkout()
		{
			functions.mouseAction(checkout_btn);
			functions.delay(4);
		}
}
