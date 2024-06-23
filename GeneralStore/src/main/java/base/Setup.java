package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.AndroidActions;

public class Setup {	
	public static AndroidDriver driver;
	
	@BeforeTest
	public static AndroidDriver beforeTestSetup() throws MalformedURLException {
//		utils.AndroidActions.startServer();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel_6");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:"+AndroidActions.getPort()+"/") ,options);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
}
