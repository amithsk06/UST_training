package workflow;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ReusableFunctions;

public class BankManagerLogin {
	public static WebDriver driver;
	public ReusableFunctions reuse;

	public BankManagerLogin(WebDriver driver)
	 {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	 }
	
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	@FindBy(xpath="//input[@placeholder='Post Code']")
	WebElement postcode;
	
	//clicking the manager login butotn
	public void clickLoginbutton()
	{
		reuse.clickOn(By.xpath("//button[@ng-click=\"manager()\"]"), Duration.ofSeconds(5));
	}
	
	public void addCustomer()
	{
		reuse.clickOn(By.xpath("//button[@ng-class='btnClass1']"),Duration.ofSeconds(5));
	}
	public void cust_Details(String data1,String data2,String data3)
	{
		reuse.sendText(firstname, data1);
		reuse.sendText(lastname, data2);
		reuse.sendText(postcode, data3);
		reuse.clickOn(By.xpath("//button[@type='submit']"), Duration.ofSeconds(5));
		Alert a=driver.switchTo().alert();
		a.accept();
	}
//	public void checking_Added_cust()
//	{
//		reuse.clickOn(By.cssSelector("button[ng-class='btnClass3']"),Duration.ofSeconds(4));
//		String text="Tex";
//		ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
//		Assert.assertEquals(true, list.size() ==1);
//	}
	
	public String cust_Name()
	{
		String name="";
		reuse.clickOn(By.xpath("//button[@ng-class='btnClass2']"),Duration.ofSeconds(5));
		reuse.clickOn(By.id("userSelect"),Duration.ofSeconds(5));
		name=reuse.getText(By.cssSelector("option[value='6']"));
		reuse.clickOn(By.cssSelector("option[value='6']"),Duration.ofSeconds(5));
		return name;
		
	}
	public String cust_Currency()
	{
		String currency="";
		reuse.clickOn(By.id("currency"),Duration.ofSeconds(5));
		currency=reuse.getText(By.cssSelector("option[value='Rupee']"));
		reuse.clickOn(By.cssSelector("option[value='Rupee']"),Duration.ofSeconds(5));
		return currency;
		
	}
	public void addingaccount()
	{
		reuse.clickOn(By.xpath("//button[@type='submit']"), Duration.ofSeconds(5));
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	public void backtoHome()
	{
		reuse.clickOn(By.cssSelector("button[ng-click='home()']"),Duration.ofSeconds(5));
	}

}
