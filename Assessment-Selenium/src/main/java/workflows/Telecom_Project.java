package workflows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ReusableFunctions;

public class Telecom_Project {
	public static WebDriver driver;
	public ReusableFunctions reuse;

	public Telecom_Project(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath = "//input[@id='fname']")
	WebElement firstname;
	@FindBy()
	@FindBy(id = "lname")
	WebElement lastname;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(xpath = "textarea[placeholder='Enter your address']")
	WebElement address;

//	public void setup() {
//		reuse = new ReusableFunctions(driver);
//		driver = reuse.invokeBrowser();
//		reuse.openBrowser("test_url");
//	}

	public void accessingTelecom() {
		reuse.clickOn(By.linkText("Telecom Project"), Duration.ofSeconds(5));

		// for handling the ad
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reuse.clickOn(By.linkText("Add Customer"), Duration.ofSeconds(3));
	}

	// adding a customer to telecome project
	public void addingCustomer() {
		reuse.clickOn(By.xpath("//label[@for='done']"), Duration.ofSeconds(5));
	}

	public void cust_data(String data1, String data2, String data3, String data4) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reuse.sendText(firstname, data1);
		reuse.sendText(lastname, data2);
		reuse.sendText(email, data3);
		reuse.sendText(address, data4);
		reuse.clickOn(By.xpath("//input[@value='Submit']"), Duration.ofSeconds(5));
	}

}
