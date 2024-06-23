package com.ust.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.base.ReusableFunctions;

public class ReviewFunctionalityPOM {
	
	WebDriver driver;
	ReusableFunctions functions;
	
	public ReviewFunctionalityPOM(WebDriver driver) {
		this.driver=driver;
		functions=new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}
	
	//locator of review stars of the product
	@FindBy(css="div[data-product-id='1006'][data-yotpo-element-id='2']")
	WebElement reviewstars;
	
	//locator of review star to be asserted
	@FindBy(xpath="(//span[@class='sr-only'])[31]")
	WebElement starvalidate;
	
	//locator of each stars
	@FindBy(xpath="(//div[@class='yotpo-star-distribution-bar-score'])[1]")
	WebElement fivestar;
	@FindBy(xpath="(//div[@class='yotpo-star-distribution-bar-score'])[2]")
	WebElement fourstar;
	@FindBy(xpath="(//div[@class='yotpo-star-distribution-bar-score'])[3]")
	WebElement threestar;
	@FindBy(xpath="(//div[@class='yotpo-star-distribution-bar-score'])[4]")
	WebElement twostar;
	@FindBy(xpath="(//div[@class='yotpo-star-distribution-bar-score'])[5]")
	WebElement onestar;
	
	@FindBy(xpath="(//span[@class='sr-only'])[18]")
	WebElement isfivestar;
	
	@FindBy(xpath="(//span[@class='yotpo-icon yotpo-icon-down-triangle'])[1]")
	WebElement filterclick;
	
	@FindBy(css="li[sort-name='5']")
	WebElement option5;
	
	@FindBy(xpath="(//div[@class='yotpo-review-stars '])[2]/span[6]")
	WebElement fivestartext;
	
	@FindBy(css="button[class='yotpo-default-button yotpo-icon-btn write-question-review-button write-button write-review-button']")
	WebElement reviewbtn;
	
	@FindBy(className="desktop-clear-btn-text")
	WebElement clear;
	
	@FindBy(xpath="(//span[@class='selected'])[1]")
	WebElement rating;
	
	@FindBy(xpath="(//h2[@class='y-label yotpo-header-title'])[1]")
	WebElement review_msg;
	
	@FindBy(css="span[data-score='5']")
	WebElement fivestarrating;
	
	@FindBy(css="input[name='review_title']")
	WebElement Title;
	
	@FindBy(xpath="(//textarea[@name='review_content'])[1]")
	WebElement Review;
	
	@FindBy(xpath="(//input[@autocomplete='nickname'])[1]")
	WebElement Name;
	
	@FindBy(xpath="(//input[@autocomplete='email'])[1]")
	WebElement Email;
	
	@FindBy(xpath="(//input[@value='Post'])[1]")
	WebElement post;
	
	@FindBy(xpath="(//div[@class='yotpo-thankyou-header text-3xl']/span[2])[1]")
	WebElement post_msg;
	//method for clicking review stars which in turn scroll to review part of the product page
	public void to_review()
	{
		functions.clickOn(reviewstars, 4);
	}
	public boolean fivestarreview()
	{
		return fivestar.isDisplayed();
	}
	public boolean fourstarreview()
	{
		return fourstar.isDisplayed();
	}
	public boolean threestarreview()
	{
		return threestar.isDisplayed();
	}
	public boolean twostarreview()
	{
		return twostar.isDisplayed();
	}
	public boolean onestarreview()
	{
		return onestar.isDisplayed();
	}
	public void filtering()
	{
		functions.delay(2);
		functions.clickOn(filterclick, 2);
		functions.delay(2);
		functions.clickOn(option5, 2);
	}
	public String fivestarclick()
	{
		String fivestarmsg=functions.getTextofElement(fivestartext);
		return fivestarmsg;	
	}
 //-----method to return array with number of likes of the review post-----//
	public List likecheck()
	{
		List<Integer> arr=new ArrayList<Integer>();
		functions.delay(2);
		for(int i=3;i<13;i=i+2)
		{
			WebElement likecount=driver.findElement(By.xpath("(//span[@class='y-label yotpo-sum vote-sum'])["+i+"]"));
			arr.add(Integer.parseInt(likecount.getText()));
		}
		return arr;
	}
	//----------method to like the review post--------------//
	public void likingthereview()
	{
		functions.delay(2);
		for(int i=2;i<7;i++)
		{
			WebElement like=driver.findElement(By.xpath("(//span[@class='yotpo-icon yotpo-icon-thumbs-up'])"+"["+i+"]"));
			functions.mouseAction(like);
		}
	}
	//-----method to return the array with number of dislikes------//
	public List dislikecheck()
	{
		functions.delay(3);
		List<Integer> arr=new ArrayList<Integer>();
		for(int i=4;i<12;i=i+2)
		{
			WebElement likecount=driver.findElement(By.xpath("(//span[@class='y-label yotpo-sum vote-sum'])["+i+"]"));
			arr.add(Integer.parseInt(likecount.getText()));
		}
		return arr;
	}
	//----------dislike the review post---------//
	public void dislikingthereview()
	{	
		functions.delay(4);
		for(int i=2;i<7;i++)
		{	
			WebElement dislike=driver.findElement(By.xpath("(//span[@class='yotpo-icon yotpo-icon-thumbs-down'])"+"["+i+"]"));
			functions.mouseAction(dislike);
		}
	}
	public String rating_msg()
	{
		String rate_msg=functions.getTextofElement(rating);
		return rate_msg;
	}
	public void clearingfilter()
	{
		functions.mouseAction(clear);
	}
	
	public void clicking_the_review_btn()
	{
		
		functions.mouseAction(reviewbtn);
	}
	public String cheking_reviewpart()
	{
		String review_message=functions.getTextofElement(review_msg);
		return review_message;
	}
	public void giving_star()
	{
		functions.clickOn(fivestarrating, 2);
	}
	public void giving_credentials(String title,String review,String name,String email)
	{
		functions.sendText(Title, title);
		functions.sendText(Review, review);
		functions.sendText(Name, name);
		functions.sendText(Email, email);
	}
	public void postreview()
	{
		functions.mouseAction(post);
		
	}
	public String post_msgcheck()
	{
		return functions.getTextofElement(post_msg); 
	}
}
