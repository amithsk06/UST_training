package base;

import static org.testng.Assert.assertEquals;

import org.aeonbits.owner.ConfigCache;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Driver_Setup {
	public static WebDriver driver;
	
	 

	//-----method for invoking the edge browser-----//
	public static WebDriver invokeEdgebrowser() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--guest");
		driver = new EdgeDriver(options);
		return driver;
	}
}
