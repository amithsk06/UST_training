package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appiumUtilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TimerPage {
	 public AndroidDriver driver;
	    AndroidActions ac;
	    WebDriverWait wait;

	    public TimerPage(AndroidDriver driver) {
	        this.driver = driver;
	        ac = new AndroidActions(driver);
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }
	    
	    @AndroidFindBy(className="android.widget.Button")
	   List <WebElement> keyNumbers;
	    @AndroidFindBy(id="com.google.android.deskclock:id/action_bar_title")
		   WebElement timeBar;
	    @AndroidFindBy(accessibility="Start")
		   WebElement timeStartButton;
	    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout")
		   WebElement getTime;
	    @AndroidFindBy(id="com.google.android.deskclock:id/left_button")
		   WebElement deleteTimer;
	    
	    
	    public WebElement timeBarWebElement() {
	    	return timeBar;
	    }
	    
	    public void setTime() {
	    	keyNumbers.get(1).click();
	    	keyNumbers.get(2).click();
	    	keyNumbers.get(3).click();
	    	keyNumbers.get(4).click();
	    	keyNumbers.get(5).click();
	    }
	    
	    public String getTime() {
	    	return timeBar.getText();
	    }
	    public void timeStartButtonClick() {
	    	timeStartButton.click();
	    }
	    public WebElement getTimeInTimer() {
	    	return getTime;
	    }
	    public void deleteButtonClick() {
	    	deleteTimer.click();
	    }
	    
	    

		

}
