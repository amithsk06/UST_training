package com.ust.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseTest;
import com.ust.pom.HomePage;
import com.ust.pom.SearchPage;

import com.ust.utilities.ExtentReportsListener;


/**
 * This class extends the BaseTest class and contains tests related to adding products to the cart.
 *
 */
@Listeners(ExtentReportsListener.class)
public class AddToCart extends BaseTest {
	   HomePage homePage;
	   SearchPage searchPage;
	
	/**
     * This method tests the search functionality of the application and navigates to the search page.
     *
     * @throws InterruptedException if any thread is interrupted
     */
	@Test(priority=0)	
	public void searchPageTest() throws InterruptedException {
		// Create a new instance of the HomePage class
		homePage=new HomePage(driver);
		// Search for a product
		homePage.searchProduct();
		// Create a new instance of the SearchPage class
	    searchPage=new SearchPage(driver);
	    // Assert that the add to cart button is found
	    assertTrue(searchPage.addToCartButtonFound());
	    // Click the add to cart button
	    searchPage.clickaddToCart();
	    
}
	
	/**
     * This method tests the add to cart functionality of the application.
     *
     * @throws InterruptedException if any thread is interrupted
     */
	@Test(priority=1)
	public void addToCartTest() throws InterruptedException {
		// Assert that the bag is clickable
		assertTrue(searchPage.isBagClickable());
		// Click on the bag
		searchPage.clickOnBag();
			
	}
	

    /**
     * This method tests the bag count functionality of the application.
     *
     * @throws InterruptedException if any thread is interrupted
     */
	@Test(priority=2)
    public void bagCountTest() throws InterruptedException {
		// Create a new instance of the SearchPage class
		searchPage=new SearchPage(driver);
		// Assert that the count is 2
		int n=searchPage.getCount();
        assertEquals(2,searchPage.getCount());
	}
	
}
