package pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumUtilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AlarmPage {
	public AndroidDriver driver;
    AndroidActions ac;
    WebDriverWait wait;

    public AlarmPage(AndroidDriver driver) {
        this.driver = driver;
        ac = new AndroidActions(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    @AndroidFindBy(accessibility="Alarm")
    WebElement alarmOption;
    @AndroidFindBy(accessibility="Add alarm")
    WebElement addNewAlarm;
    @AndroidFindBy(xpath="//com.google.android.material.button.MaterialButtonToggleGroup[@content-desc=\"Select AM or PM\"]/android.widget.CompoundButton[2]")
    WebElement setTime;
    @AndroidFindBy(id="com.google.android.deskclock:id/material_timepicker_ok_button")
    WebElement okButton;
    @AndroidFindBy(xpath="(//androidx.cardview.widget.CardView[@content-desc=\" Alarm\"])")
    WebElement alarmTimeDetails;
    
  
    public void alarmOptionClick() {
    	alarmOption.click();
    }
    public WebElement addNewAlarmWebElement() {
    	return addNewAlarm;
    }
    public void addNewAlarmClick() {
    	addNewAlarm.click();;
    }
    public void setupAlarm() {
    	setTime.click();
    }
    public WebElement okButtonWebElement() {
    	return okButton;
    }
    public void okButtonClick() {
    	okButton.click();
    }
    public WebElement alarmTimeDetailsWebElement() {
    	return alarmTimeDetails;
    }

}
