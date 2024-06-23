package pom;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumUtilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	public AndroidDriver driver;
	AndroidActions ac;
	WebDriverWait wait;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		ac=new AndroidActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	}
	@AndroidFindBy(id="com.android.settings:id/search_action_bar")
	WebElement searchInput;
	@AndroidFindBy(className="android.widget.EditText")
	WebElement searchArea;
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
	WebElement noResult;
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]")
	WebElement searchedItem;

	
	public void searchClick() {
		searchInput.click();
	}
	public void searchWithNull() {
		searchArea.sendKeys("",Keys.ENTER);
	}
	public WebElement noResult() {
		return noResult;
	}
	
	public void searchWithCorrect() {
		ac.setTextToField(searchArea,"Apps");
	//	searchArea.click();
		ac.tap(driver, 988, 2114);
	}
	public WebElement searchDetails() {
		 return searchedItem;
	}
	

}
