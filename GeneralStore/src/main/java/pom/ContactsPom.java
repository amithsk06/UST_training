package pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ContactsPom {
	public AndroidDriver driver;
	public Faker faker;
	
	public ContactsPom(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		faker = new Faker();
	}
	
	@AndroidFindBy(id = "android:id/button2")
	WebElement skipButton;
	
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
	WebElement dontAllow;
	
	@AndroidFindBy(accessibility = "Create contact")
	WebElement addButton;
	
	@AndroidFindBy(className = "android.widget.EditText")
	List<WebElement> sentValues;
	
	@AndroidFindBy(id = "com.google.android.contacts:id/toolbar_button")
	WebElement saveButton;
	
	@AndroidFindBy(accessibility = "Edit contact")
	WebElement editButton;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
	WebElement moreOptionsButtons;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.TextView")
	List<WebElement> deletebButton;
	
	@AndroidFindBy(id = "android:id/button1")
	WebElement confirmDeleteButton;
	
	@AndroidFindBy(id = "com.google.android.contacts:id/open_search_bar_text_view")
	WebElement Search;
 
	@AndroidFindBy(className = "android.widget.EditText")
	WebElement input;
 
	@AndroidFindBy(id = "com.google.android.contacts:id/contacts_list_container")
	WebElement searchResult;
	
	public void setupForContact() {
		skipButton.click();
		dontAllow.click();
	}
	
	public void clickAdd() {
		addButton.click();
	}
	
	public void enterValues() {
		sentValues.get(0).sendKeys(faker.name().firstName());
		sentValues.get(1).sendKeys(faker.name().lastName());
		sentValues.get(2).sendKeys(faker.company().name());
		sentValues.get(3).sendKeys(faker.phoneNumber().phoneNumber());
		sentValues.get(4).sendKeys(faker.internet().emailAddress());
	}
	
	public void clickSave() {
		saveButton.click();
	}
	
	public void editContact() {
		editButton.click();
		sentValues.get(0).sendKeys(faker.name().firstName());
		sentValues.get(1).sendKeys(faker.name().lastName());
	}
	
	public void deleteContact() {
		moreOptionsButtons.click();
		deletebButton.get(0).click();
		confirmDeleteButton.click();
	}
 
	public void enterSearchInput(String name) {
		input.sendKeys(name);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void selectContact() {
		AndroidActions.tap(driver, 400, 200);
	}
}
