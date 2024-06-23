package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.pom.ReviewFunctionalityPOM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.FileIO;

public class ReviewFunctionality {
		WebDriver driver=Hooks.driver;
		ReviewFunctionalityPOM review;
		Properties prop=FileIO.getProperties();
	
	@When("User clicks review stars of the product it scrolls to review part")
	public void user_clicks_review_stars_of_the_product_it_scrolls_to_review_part() {
		review=new ReviewFunctionalityPOM(driver);
	    review.to_review();
	}
	
	@Then("Validate if each review stars are present")
	public void validate_if_each_review_stars_are_present() {
		Boolean star5=review.fivestarreview();
		Boolean star4=review.fourstarreview();
		Boolean star3=review.threestarreview();
		Boolean star2=review.twostarreview();
		Boolean star1=review.onestarreview();
		assertTrue(star5);
		assertTrue(star4);
		assertTrue(star3);
		assertTrue(star2);
		assertTrue(star1);
	}
	@And("Apply filter directly")
	public void apply_filter_directly() {
	    review.filtering();   
	}

	@And("Check if filter is applied or not")
	public void check_if_filter_is_applied_or_not() {
		 String msg=review.fivestarclick();
	    assertEquals(msg,"5.0 star rating");
	}
	
	@Then("Like the review posts and validate")
	public void like_the_review_posts_and_validate() {
		//---logic to assert like counts before liking the post and after liking the post---//
	    List arr=review.likecheck();
	    System.out.println("Like Count before Liking the Post : "+arr);
	    review.likingthereview();
	    List liked_arr=review.likecheck();
	    System.out.println("Like Count after Liking the Post : "+liked_arr);
	    for(int i=0;i<arr.size();i++) {
	    	assertEquals(((int) arr.get(i)+1),liked_arr.get(i));
	    }
	}

	@Then("Validate if clicking Clear All is working")
	public void validate_if_clicking_clear_all_is_working() {
	    review.clearingfilter();
	    String rate_msg=review.rating_msg();
	    assertEquals(rate_msg,"Rating");
	}
	
	@Then("Dislike the review posts and validate")
	public void dislike_the_review_posts_and_validate() {
		 //---logic to assert dislike counts before liking the post and after disliking the post---//
	    List arr1=review.dislikecheck();
	    System.out.println("Like Count before Disliking the Post : "+arr1);
	    review.dislikingthereview();
	    List disliked_arr1=review.dislikecheck();
	    System.out.println("Like Count after Disliking the Post : "+disliked_arr1);
	    for(int i=0;i<arr1.size();i++) {
	    	assertEquals(((int) arr1.get(i)+1),disliked_arr1.get(i));
	    }
	}
	
	@When("User clicks Write a Review button")
	public void user_clicks_write_a_review_button() {
	    review.clicking_the_review_btn();
	}

	@Then("Validate if the Write a Review part is loaded")
	public void validate_if_the_write_a_review_part_is_loaded() {
	    String message=review.cheking_reviewpart();
	    assertEquals(message,prop.getProperty("REVIEW_MSG"));
	}

	@When("Gives a Rating to the product")
	public void gives_a_rating_to_the_product() {
	    review.giving_star();
	}

	@When("Provide data to {string},{string},{string},{string}")
	public void provide_data_to(String string1, String string2, String string3, String string4) {
	    review.giving_credentials(string1, string2, string3, string4);
	}

	@When("Post the review")
	public void post_the_review() {
	    review.postreview();
	    
	}
	@Then("Validate the post")
	public void validate_the_post() {
		String message=review.post_msgcheck();
		assertEquals(message,prop.getProperty("POST_MSG"));
	}
}

	

