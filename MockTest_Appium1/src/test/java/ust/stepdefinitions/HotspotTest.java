package ust.stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ust.example.utilities.ExtentReportsListener;
import ust.pom.AppTimer;

@Listeners(ExtentReportsListener.class)
public class HotspotTest{
	AndroidDriver driver;
	AppTimer timer;
	@Given("open Settings")
	public void open_settings() throws MalformedURLException {
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

	@When("Click Network and internet")
	public void click_network_and_internet() {
	    timer=new AppTimer(driver);
	    timer.network();

	  
	}

	@When("Click Hotspot")
	public void click_hotspot() {
	    timer.hotspot();
	}

	@When("Click WifiHotspot")
	public void click_wifi_hotspot() {
	    timer.click_hotspot_tethering();
	}

	@Then("Switch on the hostpot")
	public void switch_on_the_hostpot() {
	    timer.hotspot_confirm();
	}

}
