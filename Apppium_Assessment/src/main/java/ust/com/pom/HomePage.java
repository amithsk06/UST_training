package ust.com.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ust.com.base.ReusableFunctions;

public class HomePage {
	public AndroidDriver driver;
	ReusableFunctions rf;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "android:id/button2")
	WebElement skip;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	WebElement allowNotification;

	@AndroidFindBy(accessibility = "Create contact")
	WebElement plusSign;

	@AndroidFindBy(id = "com.google.android.contacts:id/open_search_bar_text_view")
	WebElement SearchButton;
	
	@AndroidFindBy(id = "com.google.android.contacts:id/open_search_bar_text_view")
	WebElement SearchInput;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Adham John\"]")
	WebElement contact;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Adham James\"]")
	WebElement contactUpdated;
	
	@AndroidFindBy(id="com.google.android.contacts:id/navigation_bar_item_active_indicator_view")
	WebElement contacts;
	
	@AndroidFindBy(id="com.google.android.contacts:id/attribution_header")
	WebElement noOfContacts;

	public void clickSearch() {
		SearchButton.click();
	}

	public void enterSearchInput(String name) throws InterruptedException {
		rf.delay(4);
		SearchInput.sendKeys(name);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void clickSkip() {
		skip.click();
	}

	public void clickAllow() {
		allowNotification.click();
	}

	public void clickAdd() {
		plusSign.click();
	}
	
	public void clickFirstContact() {
		contacts.click();
		contact.click();
	}
	
	public void clickFirstUpdatedContact() {
		contacts.click();
		contactUpdated.click();
	}
	
	public int numberOfContacts() {
		String [] arr = noOfContacts.getText().split(" ");
		return Integer.parseInt(arr[2]);
	}
}
