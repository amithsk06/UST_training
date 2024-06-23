package UST.UiFoundationTest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driversetup {

private static WebDriver driver;
	
	public static WebDriver invokeChromeBrowser() {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
	    options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
	    return driver;
	}
	public static WebDriver invokeEdgeBrowser() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("guest");
		driver = new EdgeDriver(options);
		return driver;
	}
}
