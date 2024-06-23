package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class HomePage {
	AndroidDriver driver;
	AndroidActions actions=new AndroidActions(driver);
	public HomePage(AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	@FindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	WebElement title;
	
	
	
	public void titlecheck()
	{
		String pagetitle= actions.getTextofElement(title);
		System.out.println(pagetitle+"asfgh");
		//return pagetitle;
	}
}
