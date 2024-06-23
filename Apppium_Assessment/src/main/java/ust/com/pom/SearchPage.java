package ust.com.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
 
import ust.com.base.AndroidActions;
 
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
 
public class SearchPage {
	private AndroidDriver driver;
 
	public SearchPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
 
//	@AndroidFindBy(id = "com.google.android.contacts:id/open_search_bar_text_view")
//	WebElement Search;
 
	@AndroidFindBy(className = "android.widget.EditText")
	WebElement input;
 
//	@AndroidFindBy(id = "com.google.android.contacts:id/contacts_list_container")
//	WebElement searchResult;
 
	public void enterSearchInput(String name) {
		input.sendKeys(name);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}
 
	public void selectContact() {
		AndroidActions.tap(driver, 407, 407);
	}
 
}