package pom;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;
import utils.FileIO;

public class ContactPage {
	AndroidDriver driver;
	AndroidActions actions=new AndroidActions(driver);
	Properties prop=FileIO.getProperties();
	public ContactPage(AndroidDriver driver) {
		 this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
    }
	
	@FindBy(id="android:id/button2")
	WebElement skip;
	@FindBy(id="com.android.permissioncontroller:id/permission_deny_button")
	WebElement dontallow;
	@AndroidFindBy(accessibility="Create contact")
	WebElement newcontact;
	@AndroidFindBy(xpath="//android.widget.TextView")	
	List<WebElement> contacttitle;
	@AndroidFindBy(xpath="//android.widget.EditText")	
	List<WebElement> details;
	@FindBy(id="com.google.android.contacts:id/toolbar_button")
	WebElement save;
	@FindBy(id="com.google.android.contacts:id/large_title")
	List<WebElement> contactname;	
	@AndroidFindBy(accessibility="Edit contact")
	WebElement edit_contact;
	@AndroidFindBy(accessibility="Mobile Phone")
	WebElement mobile_phone;
	
	

	
	
	public void skipsign_in()
	{
		skip.click();
		dontallow.click();
	}
	public void new_account()
	{
		newcontact.click();
	}
	public String getContacttitle()
	{
		return actions.title_check(contacttitle.get(0));
	}
	public void setContactDetails()
	{
		String arr=prop.getProperty("details");
		String[] arr1=arr.split(",");
		for(int i=0;i<arr1.length;i++)
		{
			details.get(i).sendKeys(arr1[i]);
		}
		save.click();
	}
	public String conatctcheck()
	{
		return actions.title_check(contactname.get(0));
	}
	public String[] contactname()
	{
		String arr=prop.getProperty("details");
		String[] arr1=arr.split(",");
		return arr1;
	}
	public void edit_contact()
	{
		edit_contact.click();
		mobile_phone.click();
		((JavascriptExecutor)driver).executeScript("mobile: clickGesture", ImmutableMap.of("elementId",((RemoteWebElement)mobile_phone).getId(),"endX",210,"endY",340));
	}
	
	
	
	

}
