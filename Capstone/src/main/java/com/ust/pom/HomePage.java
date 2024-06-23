package com.ust.pom;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;
import com.ust.utilities.FileIO;


//Class representing the HomePage of the application//
public class HomePage {
	WebDriver driver;
	ReusableFunctions functions;
	Properties properties;
	
	//Constructor for the HomePage class
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		functions=new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
		properties=FileIO.getProperties();
	}

	//---locators of home button-----//
	@FindBy(xpath="(//img[@title='Forest Essentials'])[1]")
	WebElement home;
	
	//Element representing the close button.
	@FindBy(xpath="(//button[@class='action-close'])[2]")
	WebElement closeButton;
	
	//Element representing the search icon.
	@FindBy(css="label[class='label'][for='search']")
	WebElement searchIcon;
	
	//Element representing the search bar.
	@FindBy(xpath="(//input[@id='search'])[2]")
	WebElement searchBar;
	
	//Element representing the search button.
	@FindBy(xpath="//button[@type='submit'][@title='Search']")
    WebElement search;
	
	//Element representing the logo.
	@FindBy(xpath="//a[@class='logo']")
    WebElement logo;
	
	//Element representing the account button.
	@FindBy(xpath="//a[@class='button login']")
	WebElement account;
	
    // Element representing the price of a product.
	@FindBy(css="span#old-price-1398-widget-product-grid>span")
    WebElement price;
	
	// Locators for items for wishlisting
	// Element representing the first item
    @FindBy(css="a[title='Soundarya Radiance Cream With 24K Gold & SPF 25']")
    WebElement item1; 
    
    // Element representing the second item
    @FindBy(css="a[title='Hydrating Facial Moisturizer for Men Sandalwood & Orange Peel With SPF 25']")
    WebElement item2;
    
    // Element representing the wishlist button for item1
    @FindBy(xpath="(//a[@class='action towishlist'])[1]")
    WebElement item1_wishlist; 
    
 // Element representing the wishlist button for item2
    @FindBy(xpath="(//a[@class='action towishlist'])[3]")
    WebElement item2_wishlist; 
    
    //locators of footerlinks
    @FindBy(xpath="(//ul[@class='footer-nav mobilemenu'])[2]/li")
   List<WebElement> footerlinks;
    
  //Page Philosophy element
    @FindBy(xpath = "(//a[text()='Our Philosophy'])[6]")
    WebElement pagephilosophy;
    //Policy element
    @FindBy(xpath="//a[text()='Policies']")
    WebElement policies;
    //customize element
    @FindBy(xpath="//a[text()='Customize a Cream']")
    WebElement customize;
    
    //locator of sign out element
    @FindBy(css="a[class='header_account_link']")
    WebElement signout;
    @FindBy(xpath="//*[@id=\"maincontent\"]/div[1]/h1/span")
    WebElement verifyOnPage;
    
    //locators for checkout page
    //cart(bag)
    @FindBy(css="a[class='action showcart']")
    WebElement bag;
    @FindBy(css="a[class='action viewcart']")
    WebElement go_to_bag;
    
    //locators for accessing header links
    // face element
    @FindBy(xpath="//a[text()='Face']")
    WebElement face;
    // body element
    @FindBy(xpath="//a[text()='Bath & Body ']")
    WebElement body;
    // hair element
    @FindBy(xpath="//a[text()='Hair']")
    WebElement hair;
    // fresh element
    @FindBy(xpath="//a[text()='Fresh']")
    WebElement fresh;
    // makeup element
    @FindBy(xpath="//a[text()='Makeup']")
    WebElement makeup;
    // gift element
    @FindBy(xpath="//a[text()='Gifting']")
    WebElement gift;
    // travel element
    @FindBy(xpath="//a[text()='Travel Minis']")
    WebElement travel;
    // baby element
    @FindBy(xpath="//a[text()='Mom & Baby']")
    WebElement baby;
    // men element
    @FindBy(xpath="//a[text()='Men']")
    WebElement men;
    

    // Returns the current URL of the driver
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    // Returns true if the search icon is present
    public boolean isSearchIconPresent() {
        return searchIcon.isDisplayed();
    }

    // Returns true if the search bar is present
    public boolean isSearchBarPresent() {
        return searchBar.isDisplayed();
    }

    // Returns true if the search button is present
    public boolean actionSearch() {
        return search.isDisplayed();
    }

    // Returns true if the logo is present
    public boolean logoisPresent() {
        return logo.isDisplayed();
    }

    // Closes the Offer details that appear when opening the site
    public void closeOffers() {
        functions.clickOn(closeButton, 15);
    }

    // Clicks on the search icon
    public void clickSearchIcon() {
        functions.clickOn(searchIcon, 4);
    }

    // Enters text into the search bar
    public void enterTextToSearch(String str) {
        functions.sendText(searchBar, str);
    }

    // Clicks on the search button
    public void clickSearch() {
        functions.clickOn(search, 4);
    }

    // Searches for a product by entering its name into the search bar and clicking the search button
    public void searchProduct() {
        String product = properties.getProperty("PRODUCT");
        clickSearchIcon();
        enterTextToSearch(product);
        clickSearch();
    }

    // Returns the price of the product
    public String priceofProduct() {
        return price.getText();
    }

    // Clicks on the account button and navigates to the login page
    public LoginPage clickAccount() {
        functions.clickOn(account, 2);
        return new LoginPage(driver);
    }

    // Clicks on the home button
    public void to_home() {
        functions.clickOn(home, 1);
    }

    // Returns the title of item1
    public String item1_name() {
        String name = item1.getAttribute("title");
        return name;
    }

    // Adds item1 to wishlist
    public void adding_item1_wishlist() {
        functions.delay(3);
        functions.mouseAction(item1_wishlist);
    }

    // Returns the title of item2
    public String item2_name() {
    	functions.delay(3);
        String name = item2.getAttribute("title");
        return name;
    }

    // Adds item2 to wishlist
    public void adding_item2_wishlist() {
        functions.delay(3);
        functions.mouseAction(item2_wishlist);
    }
  //To check functionality of our philosophy element
  	public void clickPagePhilosophy() throws Exception {
  		functions.delay(3);
  		functions.mouseAction(pagephilosophy);
  		
  	}
  	
  	//To check functionality of our policies element
  	public void clickPolicies() throws Exception {
  		functions.delay(3);
        functions.mouseAction(policies);
      }
  	
  	//To check functionality of our policies element
  	public void clickCustomize() throws Exception {
  		functions.delay(3);
        functions.mouseAction(customize);
      }
  	//to sign out
  	public void signing_out()
  	{
  		functions.clickOn(signout, 2);
  	}
  	public String sign_out_check()
  	{
  		return functions.getTextofElement(verifyOnPage);	
  	}
  	public void clickBag()
  	{
  		functions.delay(3);
  		functions.clickOn(bag,2);
  		functions.clickOn(go_to_bag,2);
  	}
  	public void clickFace() throws Exception {
	    functions.clickJS(face);
	   }
	
	public void clickBody() throws Exception {
	    functions.clickJS(body);
	   }
	
	public void clickHair() throws Exception {
	    functions.clickJS(hair);
	   }
	
	public void clickFresh() throws Exception {
	    functions.clickJS(fresh);
	   }
	
	public void clickMakeup() throws Exception {
	    functions.clickJS(makeup);
	   }
	
	public void clickGift() throws Exception {
	    functions.clickJS(gift);
	   }
	
	public void clickTravel() throws Exception {
	    functions.clickJS(travel);
	   }
	
	public void clickBaby() throws Exception {
	    functions.clickJS(baby);
	   }
	
	public void clickMen() throws Exception {
	    functions.clickJS(men);
	   }
}