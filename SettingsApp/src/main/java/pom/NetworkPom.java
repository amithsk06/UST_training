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

public class NetworkPom {
	public AndroidDriver driver;
	AndroidActions ac;
	WebDriverWait wait;

	public NetworkPom(AndroidDriver driver) {
		this.driver = driver;
		ac=new AndroidActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		
	}
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]")
	WebElement netWorkOpt;
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]")
	WebElement airPlaneMsg;
	@AndroidFindBy(id="android:id/switch_widget")
	WebElement modeChanger;
	public void networkClick() {
		netWorkOpt.click();		
		}
	public WebElement airPlaneElement() {
		return 	modeChanger;
		}
	public void changeMode() {
	modeChanger.click();
		
	}
	
	public  String  airplaneMsgGet() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		wait.until(ExpectedConditions.visibilityOf(airPlaneMsg));
	return airPlaneMsg.getText();
		
	}

}
