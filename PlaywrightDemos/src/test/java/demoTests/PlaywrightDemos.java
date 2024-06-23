package demoTests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightDemos {

	@Test
	public void testChrome() {
		// Disable SSL certificate validation
		System.setProperty("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
		System.out.println("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD: " + System.getProperty("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD"));
		final Playwright playwright = Playwright.create();
		final Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		final Page page = browser.newPage();
		page.navigate("https://www.google.com/");
		String pageTitle = page.title();
		page.close();
		browser.close();
		playwright.close();
	}

}



