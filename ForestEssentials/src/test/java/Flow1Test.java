import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Driver_Setup;
import base.ReusableFunctions;
import utilities.FileIO;
import workflow.Flow1;


public class Flow1Test {
	WebDriver driver;
	Flow1 f1;
	ReusableFunctions reuse;
	

	@BeforeTest
	public void openBrowser() {
		reuse=new ReusableFunctions(driver);
		driver=Driver_Setup.invokEdgeBrowser();
		reuse.openBrowser();
		
	}
	
	@Test(priority=1)
	public void adclose()
	{
		f1=new Flow1(driver);
		f1.adHandling();
		f1.fragrance();
		
		//assertTrue(arr.contains(prop.getProperty("item1")));
	}
	
	@Test(priority=2)
	public void item()
	{
		f1.frag_list();
	}
}
