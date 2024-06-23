package com.pom;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReusableFunctions;
import com.utilities.FileIO;


public class RegisterPage {

		public static WebDriver driver;
		ReusableFunctions functions=new ReusableFunctions(driver);
		Properties prop = FileIO.getProperties();

		public RegisterPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		// -----locators the RegisterPage----//
		@FindBy(css = "input[name='username']")
		WebElement userID;
		@FindBy(xpath = "//input[@name='password']")
		WebElement newpassword;
		@FindBy(css = "input[name='repeatedPassword']")
		WebElement confirmpassword;
		@FindBy(css = "input[name='account.firstName']")
		WebElement firstname;
		@FindBy(css = "input[name='account.lastName']")
		WebElement lastname;
		@FindBy(css = "input[name='account.email']")
		WebElement email;
		@FindBy(css = "input[name='account.phone']")
		WebElement phone;
		@FindBy(css = "input[name='account.address1']")
		WebElement address1;
		@FindBy(css = "input[name='account.address2']")
		WebElement address2;
		@FindBy(css = "input[name='account.city']")
		WebElement city;
		@FindBy(css = "input[name='account.state']")
		WebElement state;
		@FindBy(css = "input[name='account.zip']")
		WebElement zip;
		@FindBy(css = "input[name='account.country']")
		WebElement country;
		@FindBy(css="option[value='REPTILES']")
		WebElement check1;
		@FindBy(xpath="//input[@name='account.listOption']")
		WebElement check2;
		@FindBy(xpath="//input[@name='account.bannerOption']")
		WebElement check3;
		@FindBy(css="input[name='newAccount']")
		WebElement check4;
		

		// -----providing data to USER INFROMATION-----//
		public void userInfo() throws InterruptedException {
			functions.sendText(userID, prop.getProperty("userid"));  //change the userid in config after each run
			functions.sendText(newpassword, prop.getProperty("password"));
			functions.sendText(confirmpassword, prop.getProperty("password"));
		}

		// ----providing data to ACCOUNT INFORMATION----//
		public void accountInfo(String data1, String data2, String data3, String data4, String data5, String data6,
				String data7, String data8, String data9, String data10) {
			functions.sendText(firstname, data1);
			functions.sendText(lastname, data2);
			functions.sendText(email, data3);
			functions.sendText(phone, data4);
			functions.sendText(address1, data5);
			functions.sendText(address2, data6);
			functions.sendText(city, data7);
			functions.sendText(state, data8);
			functions.sendText(zip, data9);
			functions.sendText(country, data10);
		}
		public void profile_Info()
		{
			functions.clickOn(check1, 2);
			functions.clickOn(check2, 2);
			functions.clickOn(check3, 2);
			functions.clickOn(check4, 2);
			
		}


}



