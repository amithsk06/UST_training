package browserSetup;

	import com.microsoft.playwright.Browser;
	import com.microsoft.playwright.BrowserType;
	import com.microsoft.playwright.Page;
	import com.microsoft.playwright.Playwright;
	public class BrowserConfig {
		private Playwright playwright;
		private Browser browser;
		
		public BrowserConfig() {
	        this.playwright = Playwright.create();
		}
		
		public Browser getBrowser() {
			if(browser==null) {
				browser= playwright.chromium()
						.launch(new BrowserType.LaunchOptions()
								.setHeadless(false)
								.setChannel("chrome"));
			}
			return browser;
			
		}
		
		public Page createPage() {
			return getBrowser().newPage();
		}
		
		public void closeBrowser() {
			if(browser!=null) {
				browser.close();
			}
			if(playwright!=null) {
	            playwright.close();
	        }
		}
		
	}

