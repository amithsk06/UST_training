package testCases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import browserSetup.BrowserConfig;

public class MyContactFormTest {
	private static BrowserConfig browserConfig;
	private static Browser browser;
	
	@BeforeClass
	public void beforeClass() {
		browserConfig = new BrowserConfig();
		browser = browserConfig.getBrowser();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		browser.newPage().setViewportSize(width, height);
	}
	
	@AfterClass
	public void afterClass() {
		if (browser != null) {
			browser.close();
		}
	}
	
	@Test
	public void mycontactform() {
		Page page = browser.newPage();
		page.navigate("https://www.mycontactform.com");
		Locator locator = page.locator("text=Sample Forms");
		locator.click();
		//using id
		Locator subject = page.locator("#subject");
		subject.fill("roshan");
		//using name
		Locator nameLocator = page.locator("[name='email']");
		nameLocator.fill("roshan");
		//using css
		Locator cssLocator = page.locator("css=input#q1");
		cssLocator.fill("Roshan");
		//using xpath
		Locator xpathLocator = page.locator("xpath=//input[@id='q2']");
		xpathLocator.fill("Roshan");
		//using attribute
		Locator attributeLocator = page.locator("[id='q3']");
		attributeLocator.fill("Roshan");
		//using Role
		Locator roleLocator = page.locator("role=button");
		roleLocator.click();
		
		//list of elements
		List<Locator> elements = page.locator("role=button").all();
		System.out.println(elements.size());
	}
}
