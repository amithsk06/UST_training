package ust.com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Contact {
	public AndroidDriver driver;
	
	public Contact(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "Edit contact")
	WebElement edit;

	@AndroidFindBy(accessibility = "More options")
	WebElement options;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
	WebElement delete;
	
	@AndroidFindBy(id  = "android:id/button1")
	WebElement confirmDel;
	
	@AndroidFindBy(id="com.google.android.contacts:id/large_title")
	WebElement contactName;
	
	
	
	public void clickEdit() {
		edit.click();
	}
	
	public void clickOptions() {
		options.click();
	}
	
	public void clickDelete() {
		delete.click();
		confirmDel.click();
	}
	
	public String validateContactName() {
		return contactName.getText();
	}
}
