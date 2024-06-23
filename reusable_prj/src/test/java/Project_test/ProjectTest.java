package Project_test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExcelHandling;
import base.ReusableFunction;
import pom.loginPOM;
import stepDefinition.Hooks;
import utilities.ExtentReportsListener;

@Listeners(utilities.ExtentReportsListener.class)
public class ProjectTest implements ITestListener {

	ExtentReportsListener extentReportsListener = new ExtentReportsListener();
	WebDriver driver;
	public ReusableFunction reusableFunctions;
	public loginPOM login;
	
		
		@BeforeClass(groups={"valid","cart"})
		public void before() {
			// Initialize reusable functions and browser invocation before the test class
			reusableFunctions=new ReusableFunction(driver);
			driver = ReusableFunction.invokeBrowser();
		}
		
		@BeforeMethod(groups={"valid","cart"})
		public void getsite() {
			// Open the test site before each test method
			reusableFunctions.openBrowser("testSiteURL");
		}
		
//		Data provider method to provide valid login details
		@DataProvider(name="validLogin")
		public String[][] getLoginData1() throws IOException{
			String path=System.getProperty("user.dir")+"\\TestData\\Logindetails.xlsx";
			String sheetName="Sheet1";
			return ExcelHandling.excelHandling(path,sheetName);
		}
		
//		Test method to validate successful login with valid credentials.
		@Test(dataProvider="validLogin",groups={"valid","cart"},priority=1)
		public void testValidLogin(String phoneNumber) throws InterruptedException {
			login=new loginPOM(driver);
			login.loginIcon();
			login.loginphnumber(phoneNumber);
			login.btnclick();
			Thread.sleep(20000);
			login.loginIcon();
			Assert.assertEquals(driver.getCurrentUrl(), "https://supertails.com/account");
		}
		
		
//		@Test(groups={"valid","cart"},priority=2)
//		public void testSearch() {
//			// Test for valid search functionality
//			login=new loginPOM(driver);
//			home=new HomePagePOM(driver);
//			home.searchElement();	// Enters search query
//			home.clickSearchbtn();	// Clicks search button
//			Assert.assertTrue(driver.getCurrentUrl().contains("dog") && driver.getCurrentUrl().contains("food"));
//		}
//		
//		@Test(dependsOnMethods="testSearch",groups={"valid","cart"},priority=3)
//		public void testProductPage() {
//			// Test for product page functionalities after valid search
//			login=new LoginPOM(driver);
//			home=new HomePagePOM(driver);
//			home.searchElement();
//			home.clickSearchbtn();
//			product=new ProductPOM(driver);
//			
//			// Select brand filter (Pedigree)
//			product.selectBrandPedigree();	
//			
//			// Select flavor filter (Milk)
//			product.selectFlavorMilk();
//			
////			// Click on dropdown and select 'What's New'
////			product.clickSort();
////			product.selectWhatsNew();
//			
//			// Add product 1 to cart
//			product.product1AddtoCart();
//
//			// View product 2 details
//			product.viewProduct();
//			
//			// Assert URL contains product name
//			Assert.assertTrue(driver.getCurrentUrl().contains(product.getProductName().replace(" ", "-")));
//			// Add product 2 to cart
//			product.product2AddtoCart();
//
//			product.clickPopupCart();
//			
//			// Assert cart page URL and title
//			Assert.assertEquals(driver.getCurrentUrl(), "https://supertails.com/cart");
//			Assert.assertEquals(driver.getTitle(), "Your Shopping Cart | Supertails");
//			
//		}
//		
//		@Test(dependsOnMethods="testProductPage",groups="valid",priority=4)
//		public void testCartPage() throws InterruptedException {
//			login=new LoginPOM(driver);
//			home=new HomePagePOM(driver);
//			product=new ProductPOM(driver);
//			product.clickCart();
//			cart=new CartpagePOM(driver);
//			
//			// Click on remove from cart
//			cart.clickRemoveFromCart();
//			
//			// Assert cart item count is not 0
//			Assert.assertNotEquals(cart.checkCartItemCount(), "0");
//			Thread.sleep(1000);
//			
//			// Click on checkout button
//			cart.clickCheckoutbtn();
//			Thread.sleep(1000);
//			
//			// Assert checkout page title and URL
//			
//			Assert.assertEquals(driver.getTitle(), "Information - Supertails - Checkout");
//			Assert.assertTrue(driver.getCurrentUrl().contains("checkouts"));
//
//		}
//		
//		@Test(dependsOnMethods="testCartPage",groups="valid")
//		public void testCheckout() {
//			login=new LoginPOM(driver);
//			home=new HomePagePOM(driver);
//			product=new ProductPOM(driver);
//			// Click on the cart to proceed to checkout
//			product.clickCart();
//			cart=new CartpagePOM(driver);
//			// Proceed to checkout
//			cart.clickCheckoutbtn();
//			checkout=new CheckoutPOM(driver);
//			// Fill in checkout details
////			checkout.email();
//			checkout.selectCountry();
////			checkout.entername();
//			checkout.address();
//			checkout.pincode();
//			checkout.city();
//			checkout.mobile();
//			// Click continue button to proceed with shipping
//			checkout.clickContinuebtn();
//			// Validate that the page title is as expected after clicking continue
//			Assert.assertEquals(driver.getTitle(), "Shipping - Supertails - Checkout");
//		
//		}
//		
//		// Test to ensure that the cart is emptied successfully
//		@Test(dependsOnMethods="testProductPage",groups="cart",priority=4)
//		public void testCartEmpty() throws InterruptedException {
//			home=new HomePagePOM(driver);
//			product=new ProductPOM(driver);
//			
//			// Click on the cart
//			product.clickCart();
//			cart=new CartpagePOM(driver);
//			
//			// Wait for cart item count to be visible and get its initial count
//			Thread.sleep(1000);
//			// Get cart item count as integer
//			int num=Integer.parseInt(cart.checkCartItemCount());
////			System.out.println(num);
//			
//			// Loop to remove items from the cart until it's empty
//			while(num!=0) {
////				 Click on remove from cart
//				cart.clickRemoveFromCart();
//				Thread.sleep(1000);
//				num--;
//			}
//			
////			Assert if the cart empty message is displayed
//			Assert.assertEquals(cart.cartEmptymsg(),"Oops, your cart is feeling a bit light. Time to give it some love and add some goodies!");
////			 Assert that the cart item count is 0
//			Assert.assertEquals(Integer.parseInt(cart.checkCartItemCount()), 0);
//		}
		
		// Method to capture screenshot in case of test failure
		@AfterMethod(groups={"valid","cart"})
		public void captureScreenshotOfFail(ITestResult result) {
			if(result.getStatus() == ITestResult.FAILURE) {
				try {
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					Date d1 = new Date();
					FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"/screenshots/"+ d1.getTime()+ "ss.jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
}

