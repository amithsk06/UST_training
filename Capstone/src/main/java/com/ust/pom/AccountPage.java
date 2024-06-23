package com.ust.pom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;
import com.ust.utilities.FileIO;

public class AccountPage {
	WebDriver driver;
	LoginPage loginPage;
	ReusableFunctions functions;
	Properties prop;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		functions=new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
		prop=FileIO.getProperties();
	}
	
	
	@FindBy(xpath="(//a[@class='action edit'])[1]")
	WebElement info_edit;
	
	//----locators in edit information page----//
	@FindBy(css="select[id='prefix']")
	WebElement prefix_dropdown;;	
	@FindBy(css="option[value='Mr.']")
	WebElement prefix;
	@FindBy(css="input[id='firstname']")
	WebElement firstname;
	@FindBy(css="input[id='lastname']")
	WebElement secondname;
	@FindBy(css="input[id='mobile']")
	WebElement phonenumber;
	@FindBy(css="button[title='Save']")
	WebElement info_save;
		
	
	//----locators of address page----//
	@FindBy(xpath="(//li[@class='nav item'])[2]/a")
	WebElement addresspage;
	@FindBy(css="button[type='button'][role='add-address']")
	WebElement createnew;
	@FindBy(css="input[id='telephone']")
	WebElement phoneno;
	@FindBy(css="input[id='street_1']")
	WebElement Line1;
	@FindBy(css="input[id='street_2']")
	WebElement Line2;
	@FindBy(css="input[id='city']")
	WebElement city;
	@FindBy(css="input[id='zip'")
	WebElement pincode;
	@FindBy(css="option[value='550']")
	WebElement kerala;
	@FindBy(xpath="//input[@id='primary_shipping']")
	WebElement save_checkbox;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement address_submit;
	
	//---locator of order history page---//
	@FindBy(css = "a[href='https://www.forestessentialsindia.com/sales/order/history/']")
	WebElement orderPage;
	@FindBy(xpath="//li[@class='nav item current']/strong")
	WebElement orderhistory;
	@FindBy(css="span[class='base']")
	WebElement order_msg;
	
	//-----locator of wishlist page----//
	@FindBy(css = "a[href='https://www.forestessentialsindia.com/wishlist/']")
	WebElement wishlistPage;
	@FindBy(xpath="//li[@class='nav item current']/strong")
	WebElement wishlist;
	@FindBy(xpath="(//span[@class='base'])[2]")
	WebElement wishlist_msg;
	
	//-----locator of newsletter-----//
	@FindBy(css="a[href='https://www.forestessentialsindia.com/newsletter/manage/']")
	WebElement newsletterPage;
	@FindBy(css="input[id='subscription']")
	WebElement subscribe_btn;
	@FindBy(xpath="//legend[@class='legend']/span")
	WebElement subscription_msg;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement subscribe_submit;
	
	//-----locators of password change page------//
	@FindBy(css="a[href='https://www.forestessentialsindia.com/customer/account/edit/changepass/1/']")
	WebElement password_change;
	@FindBy(css="span[class='base']")
	WebElement password_msg;
	@FindBy(css="input[id='current-password']")
	WebElement current_password;
	@FindBy(css="input[id='password']")
	WebElement new_password;
	@FindBy(css="input[id='password-confirmation']")
	WebElement password_confirm;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement password_submit;
	
	//-----locators of my returns----//
	@FindBy(css="a[href='https://www.forestessentialsindia.com/return/customer/history/'")
	WebElement my_returns;
	
	
	
	
	
	public void dashboard()
	{
		functions.mouseAction(info_edit);
	}
	//editting information by getting info from config file
	public void edit_information()
	{
		functions.delay(3);
		functions.clickOn(prefix_dropdown, 2);
		functions.clickOn(prefix, 2);
		firstname.clear();
		secondname.clear();
		phonenumber.clear();
		functions.sendText(firstname, prop.getProperty("FIRSTNAME"));
		functions.sendText(secondname, prop.getProperty("SECONDNAME"));
		functions.sendText(phonenumber, prop.getProperty("PHONENUMBER"));
		phonenumber.sendKeys(Keys.ENTER);	
	}
	
	public void to_addresspage()
	{
		functions.clickOn(addresspage, 1);
	}
	//adding new address
	public void new_address()
	{
		functions.delay(4);
		functions.mouseAction(createnew);
	}
	public void new_address_details(String phnNo,String address1,String address2,String City,String Postal)
	{
		List<WebElement> webElementList = new ArrayList<>();
		List<WebElement> list = Arrays.asList(phoneno,Line1,Line2,city,pincode);
		webElementList.addAll(list);
		//clearing all text values of webelements 
		for(int i=0;i<list.size();i++)
		{
			webElementList.get(i).clear();
		}	
		
		functions.delay(2);
		functions.sendText(phoneno, phnNo);
		functions.sendText(Line1, address1);
		functions.sendText(Line2, address2);
		functions.sendText(city, City);
		functions.sendText(pincode, Postal);
		functions.clickOn(kerala, 1);
		
	}
	
	public void save()
	{
		functions.mouseAction(save_checkbox);
		functions.delay(3);
		functions.mouseAction(address_submit);
	}
	
	public void to_order()
	{
		functions.delay(3);
		functions.mouseAction(orderPage);
	}

	public String orderhistory()
	{
		String heading=functions.getTextofElement(order_msg);
		return heading;
	}
	public void to_wishlist()
	{
		functions.delay(2);
		functions.clickOn(wishlistPage, 1);
	}
	public String wishlist()
	{
		String heading=functions.getTextofElement(wishlist_msg);
		return heading;
	}
		
	public void to_newsletter()
	{
		functions.delay(1);
		functions.mouseAction(newsletterPage);
	}
	public String subscription()
	{
		String heading=functions.getTextofElement(subscription_msg);
		return heading;
	}
	public void clicking_general_subscription()
	{
		functions.delay(2);
		functions.clickOn(subscribe_submit, 2);
	}
	public void to_changePassword()
	{
		functions.delay(2);
		functions.mouseAction(password_change);	
	}
	public String password_validation()
	{	
		functions.delay(3);
		String heading=functions.getTextofElement(password_msg);
		return heading;
		
	}
	public void changePassword()
	{
		functions.sendText(current_password, prop.getProperty("CURRENT_PASSWORD"));
		functions.sendText(new_password, prop.getProperty("NEW_PASSWORD"));
		functions.sendText(password_confirm, prop.getProperty("NEW_PASSWORD"));
		functions.mouseAction(password_submit);
	}
	public void to_my_returns()
	{
		functions.delay(2);
		functions.clickOn(my_returns, 2);
	}

}
