package ust.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import ust.example.utilities.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class BaseTest {
	public static AndroidDriver driver;


	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		//setting the device
		options.setDeviceName("Pixel 6");
		//setting the apk path
		options.setAppPackage("com.android.settings");
		options.setAppActivity("com.android.settings.Settings");
		options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

}
