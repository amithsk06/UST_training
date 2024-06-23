package com.ust.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseTest;
import com.ust.utilities.ExtentReportsListener;

@Listeners(ExtentReportsListener.class)
public class HeaderTest {
	public class HeaderLink extends BaseTest {
		
		
		@Test(priority=1)
		public void moveToFacialPage() throws Exception {
				homePage.clickFace();
				assertTrue(driver.getCurrentUrl().contains("facial"));
				driver.navigate().back();
			}
		
		@Test(priority=2)
		public void moveToBodyPage() throws Exception {
			
				homePage.clickBody();
				assertTrue(driver.getCurrentUrl().contains("body"));
				driver.navigate().back();
			}
		
		@Test(priority=3)
		public void moveToHairPage() throws Exception {
			
				homePage.clickHair();
				assertTrue(driver.getCurrentUrl().contains("hair"));
				driver.navigate().back();
			}
		
		@Test(priority=4)
		public void moveToFreshPage() throws Exception {
			
				homePage.clickFresh();
				assertTrue(driver.getCurrentUrl().contains("fresh"));
				driver.navigate().back();
			}
		
		@Test(priority=5)
		public void moveToMakeupPage() throws Exception {
			
				homePage.clickFresh();
				assertTrue(driver.getCurrentUrl().contains("fresh"));
				driver.navigate().back();
			}
		
		@Test(priority=6)
		public void moveToGiftPage() throws Exception {
			
				homePage.clickGift();
				assertTrue(driver.getCurrentUrl().contains("gifting"));
				driver.navigate().back();
			}
		
		@Test(priority=7)
		public void moveToTravelPage() throws Exception {
			
				homePage.clickTravel();
				assertTrue(driver.getCurrentUrl().contains("travel"));
				driver.navigate().back();
			}
		
		@Test(priority=8)
		public void moveToBabyPage() throws Exception {
			
				homePage.clickBaby();
				assertTrue(driver.getCurrentUrl().contains("baby"));
				driver.navigate().back();
			}
		
		@Test(priority=9)
		public void moveToMenPage() throws Exception {
			
				homePage.clickMen();
				assertTrue(driver.getCurrentUrl().contains("men"));
				driver.navigate().back();
			}
		
		
	}

}
