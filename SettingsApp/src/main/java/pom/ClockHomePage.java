package pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumUtilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClockHomePage {
    public AndroidDriver driver;
    AndroidActions ac;
    WebDriverWait wait;

    public ClockHomePage(AndroidDriver driver) {
        this.driver = driver;
        ac = new AndroidActions(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Add city']")
    WebElement plusIcon;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup")
    WebElement getStarted;

    @AndroidFindBy(id = "com.google.android.deskclock:id/search_src_text")
    WebElement searchForCity;

    @AndroidFindBy(id = "com.google.android.deskclock:id/navigation_bar_item_active_indicator_view")
    WebElement clockIcon;
    @AndroidFindBy(id = "com.google.android.deskclock:id/plus_button")
    WebElement addTime;
    @AndroidFindBy(id = "com.google.android.deskclock:id/wake_clock")
    WebElement getTime;
    
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button[2]")
    WebElement nextButton;
    
    @AndroidFindBy(id="com.google.android.deskclock:id/bedtime_onboarding_done")
    WebElement doneButton;
    @AndroidFindBy(id="com.google.android.deskclock:id/action_bar_title")
    WebElement bedTimeIcon;
    @AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Timer\"]/android.widget.FrameLayout/android.widget.ImageView")
    WebElement timerIcon;
    
    
	

    public void plusIconClick() {
        plusIcon.click();
    }

    public WebElement searchForCityWebElement() {
        return searchForCity;
    }

    public void searchCityEnterDetails() {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchForCity));
            searchForCity.sendKeys("kochi");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    public WebElement getStartedWebElement() {
        return getStarted;
    }

    public void getStartedClick() {
        ac.tap(driver, 501, 1856);
    }
    public void increaseTime() {
    	addTime.click();
    }
    public String getIncreasedtime() {
    	return getTime.getText();
    }
    public void nextButtonClick() {
    	nextButton.click();
    }
    public void doneButtonClick() {
    	doneButton.click();
    }
    public WebElement bedTimeWebElement() {
    	return bedTimeIcon;
    }
    public void timerClick()
    {
    	timerIcon.click();
    }
}
