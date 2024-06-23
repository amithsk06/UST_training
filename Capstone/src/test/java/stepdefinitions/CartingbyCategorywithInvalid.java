package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ust.pom.CartItembyCategory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartingbyCategorywithInvalid {
	  	CartItembyCategory cart1;
	  	WebDriver driver=Hooks.driver;
	@Then("User check for the delivery time with invalid pincode")
	public void user_check_for_the_delivery_time_with_invalid_pincode() {
		cart1=new CartItembyCategory(driver);
		cart1.deliverycheckInvalid();
	    
	}

	@Then("Validate the error message")
	public void validate_the_error_message() {
		 String msg=cart1.deliveryresultInvalid();
		 String expected_msg="Delivery";
		 assertTrue(msg.contains(expected_msg));
	}

	@When("User Increse the size and number with invalid data")
	public void user_increse_the_size_and_number_with_invalid_data() {
		cart1=new CartItembyCategory(driver);
		cart1.item_size_and_number_Invalid();
	}
	@Then("Validate number item has been added")
	public void validate_number_item_has_been_added() {
		String count_number=cart1.bag_count_number();
	    assertEquals(count_number,"1");
	}

}
