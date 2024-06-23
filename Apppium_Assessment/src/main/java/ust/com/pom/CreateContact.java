package ust.com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateContact {
	public AndroidDriver driver;
	
	public CreateContact(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='First name']")
	WebElement Firstname;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Last name']")
	WebElement Lastname;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Company']")
	WebElement Company;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone']")
	WebElement Number;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
	WebElement Email;
	
	@AndroidFindBy(id = "com.google.android.contacts:id/toolbar_button")
	WebElement save;
	
	public void enterFirstName(String fname) {
		Firstname.clear();
		Firstname.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		Lastname.sendKeys(lname);
	}
	
	public void enterCompany(String company) {
		Company.sendKeys(company);
	}
	
	public void enterNumber(String number){
		Number.sendKeys(number);
	}
	
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	
	public void clickSave() {
		save.click();
	}
	
}
