package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AndroidDriver driver;

	
	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		//setting the device
		options.setDeviceName("Pixel_6");
		options.setPlatformName("Android");
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		//setting the apk path
		//options.setApp("C:\\Users\\268896\\eclipse-workspace\\Appiumdemos\\src\\test\\resources\\APK\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	

}
