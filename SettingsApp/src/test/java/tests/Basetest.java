package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pom.HomePage;
import utilities.ExtentReportsListener; // Import the ExtentReportsListener class
import ust.SettingsApp.AppiumServerManager;

public class Basetest {
    public static AndroidDriver driver;
    Properties properties;
    HomePage homePage;

    @BeforeClass
    public void setup() throws MalformedURLException {
        String port = AppiumServerManager.startServer();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("RemyaPhone");
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");
        options.setPlatformName("Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:" + port), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Set the driver for ExtentReportsListener
        ExtentReportsListener.setDriver(driver);

        // Initialize the HomePage object if necessary
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void stopServer() {
        if (driver != null) {
            driver.quit();
        }
        AppiumServerManager.stopServer();
    }
}
