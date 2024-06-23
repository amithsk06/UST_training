package ust.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ust.example.utilities.AndroidActions;

public class AppTimer {
	public AndroidDriver driver;
	AndroidActions actions=new AndroidActions(driver);
	
	public AppTimer(AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	@FindBy(xpath="//android.widget.TextView")
	List<WebElement> apps;
	@FindBy(id="com.android.settings:id/homepage_title")
	WebElement settings_title;
	@FindBy(xpath="//android.widget.RelativeLayout")
	List<WebElement> unused_apps;
	@AndroidFindBy(accessibility="Dashboard")
	WebElement dashboardtitle;
	@FindBy(xpath="//android.widget.LinearLayout")
	List<WebElement> generalstore;
	@AndroidFindBy(accessibility="GeneralStore")
	WebElement generalstoretitle;
	@FindBy(id="com.google.android.apps.wellbeing:id/limit_button")
	WebElement timer;
	@FindBy(id="android:id/button1")
	WebElement ok;
	@FindBy(id="com.google.android.apps.wellbeing:id/delete_limit_button")
	WebElement delete;
	@FindBy(xpath="//android.widget.Switch")
	List<WebElement> switches;
	@AndroidFindBy(accessibility="Network & internet")
	WebElement title;
	
	
	
	
	
	//returning the title of the page
	public String title()
	{
		return actions.getTextofElement(settings_title,"text");
	}
	//clicking the apps option
	public void app_opening()
	{
		apps.get(7).click();
	}
	//clicking unused apps
	public void unusedapps()
	{
		unused_apps.get(4).click();
	}
	
	//title asserting
	public String dashboard()
	{
		return actions.getTextofElement(dashboardtitle,"content-desc");
	}
	//clicking generalstore
	public void generalstore_clickOn()
	{
		generalstore.get(13).click();
	}
	public String generalstore()
	{
		return actions.getTextofElement(generalstoretitle,"content-desc");
	}
	//clicking generalstore
	public void timersetting()
		{
			timer.click();
			ok.click();
			delete.click();
		}
	
	public void network()
	{
		unused_apps.get(0).click();
	}
	public void hotspot()
	{
		unused_apps.get(4).click();
	}
	public void click_hotspot_tethering()
	{
		unused_apps.get(0).click();
	}
	public void hotspot_confirm()
	{
		switches.get(0);
	}
	
	public String titlecheck()
	{
		return actions.getTextofElement(title, "content-desc");
	}
	

}
