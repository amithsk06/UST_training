package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	public AndroidDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		//setting the device
		options.setDeviceName("Pixel 6");
		//setting the apk path		
		options.setAppPackage("com.androidsample.generalstore");
		options.setAppActivity("com.androidsample.generalstore.MainActivity");
		options.setPlatformName("Android");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	
}
