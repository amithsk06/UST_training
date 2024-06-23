package com.ust.pom;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;

public class SearchPage {
    WebDriver driver;
	ReusableFunctions functions;
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		functions=new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='product-item-link'])[1]")
	WebElement product;
	@FindBy(xpath="//li[@class='select_items']")
	WebElement sortBy;
	@FindBy(xpath="//*[@id='price-asc']")
    WebElement asc;
	@FindBy(id="price-desc")
    WebElement desc;
	@FindBy(className ="price")
    List<WebElement> pricetxt;
	@FindBy(xpath="//div[@class='message notice']/div")
    WebElement notFoundMessage;
	@FindBy(xpath ="(//button[@title='Add to Cart'])[1]")
	WebElement add2;
	@FindBy(xpath ="(//button[@title='Add to Cart'])[2]")
	WebElement add1;
	@FindBy(css="a[class='action showcart']>span>span")
	WebElement bag;
	@FindBy(xpath="//span[@class='count']")
    WebElement count;
	@FindBy(css = "a.action.viewcart")
	WebElement addToBag;
	@FindBy(css="span[class='base']")
	WebElement head;
	
	
	   
	
	
	
	/**
	 * Checks if the sort by button is present on the page.
	 *
	 * @return true if the sort by button is present, false otherwise
	 */
	public boolean isSortByPresent() {
	    return sortBy.isDisplayed();
	}

	/**
	 * Retrieves the text of the product name.
	 *
	 * @return the text of the product name
	 */
	public String getProductName() {
	    return product.getText();
	}

	/**
	 * Retrieves the text of the not found message.
	 *
	 * @return the text of the not found message
	 */
	public String notFound() {
	    return notFoundMessage.getText();
	}

	/**
	 * Retrieves the current URL of the web page.
	 *
	 * @return the current URL of the web page
	 */
	public String getUrl() {
	    return driver.getCurrentUrl();
	}

	/**
	 * Clicks on the sort by button.
	 *
	 */
	public void sortBy() {
       
		functions.clickOn(sortBy, 5);
	}
	
	/**
	 * Sorts the products by price in ascending order.
	 *
	 * @return a list of prices in ascending order
	 */
	public List sortByLowToHigh() {
          functions.clickOn(asc,5);
          return printprices();
	}
	
	/**
	 * Prints the prices of the products.
	 *
	 * @return a list of prices
	 */
	public List printprices() {
		List<Integer> prices = new ArrayList<Integer>();
		for(WebElement element:pricetxt) {
			prices.add(Integer.parseInt(element.getText().substring(1)));
		}
		return prices;
	}
	
	/**
     * Sorts the products by price in descending order.
     *
     * @return a list of prices in descending order
     */
	public List sortByHighToLow() {
	
		functions.clickOn(desc, 5);
		return printprices();
		
	}

	/**
     * Checks if the add to cart button is present on the page.
     *
     * @return true if the add to cart button is present, false otherwise
     */
	public boolean addToCartButtonFound() {
		Actions actions = new Actions(driver);
		actions.moveToElement(add1).build().perform();
		return add1.isDisplayed();
	}
	
	/**
     * Clicks on the add to cart button.
     *
     */
	public void clickaddToCart() {
		functions.delay(3);
		functions.clickOn(add1, 2);
		functions.clickOn(add2, 2);
	}


    /**
    * Checks if the page is sorted in descending order.
    *
    * @return true if the page is sorted in descending order, false otherwise
    */
	public boolean isSortedDesc() {
		List<Integer> original=printprices();
		List<Integer> desc=sortByLowToHigh();
		Collections.sort(original);
		return original.equals(desc);
	}

	/**
	 * Checks if the page is sorted in ascending order.
	 *
	 * @return true if the page is sorted in ascending order, false otherwise
	 */
	public boolean isSortedAsc() {
		List<Integer> original=printprices();
		List<Integer> asc=sortByLowToHigh();
		Collections.sort(original);
		return original.equals(asc);
	}
	
	/**
	 * Checks if the bag button is clickable.
	 *
	 * @return true if the bag button is clickable, false otherwise
	 */
   public boolean isBagClickable() {
	   return bag.isDisplayed();
   }
   
   /**
    * Clicks on the bag button.
    *
    */
   
   public void clickOnBag() {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", head);
       functions.delay(8);
       bag.click();
   }
   
   /**
    * Retrieves the count of items in the bag.
    *
    * @return the count of items in the bag
    */
   public int getCount() {
       return Integer.parseInt(count.getText());
   }
    
   /**
    * Adds the product to the bag.
    */
   public void clickAddToBag() {
     JavascriptExecutor jxe=(JavascriptExecutor) driver;
     jxe.executeScript("arguments[0].click", addToBag);
   }
   
}
