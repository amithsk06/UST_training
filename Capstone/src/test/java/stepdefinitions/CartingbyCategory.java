package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.base.ReusableFunctions;
import com.ust.pom.CartItembyCategory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.FileIO;

public class CartingbyCategory {
	public WebDriver driver = Hooks.driver;
	CartItembyCategory cart1;
	ReusableFunctions functions;
	Properties prop=FileIO.getProperties();

	@Given("User already on Forest Essential India website and hover over Men Option")
	public void user_already_on_forest_essential_india_website_and_hover_over_men_option() {
	    cart1=new CartItembyCategory(driver);
	    cart1.menoption();
	}

	

	@When("Selects Hair Care link")
	public void selects_hair_care_link() {
		cart1=new CartItembyCategory(driver);
		cart1.haircare();
	    
	}

	@Then("Validate if the user is navigated to destined Hair Care page")
	public void validate_if_the_user_is_navigated_to_destined_hair_care_page() {
		String current_url=driver.getCurrentUrl();
		String target_url=prop.getProperty("HAIRCARE_URL");
	    assertEquals(current_url,target_url);
	}

	@When("User apply sort\\(Lowest first)")
	public void user_apply_sort_lowest_first() {
		cart1=new CartItembyCategory(driver);
		cart1.searching();
		cart1.sorting();	    
	}
	@Then("Validates if the items are sorted in ascending")
	public void validates_if_the_items_are_sorted_in_ascending() {
		String target_url=prop.getProperty("SORTED_URL");
		String current_url=driver.getCurrentUrl();
		assertEquals(current_url,target_url);
	}

	@Then("User clicks the first item")
	public void user_clicks_the_first_item() {
		cart1=new CartItembyCategory(driver);
		String item_name=cart1.get_item_name();
		cart1.item_click();
		String current_item=cart1.getCurrent_ItemName();
		assertEquals(item_name,current_item);
	}
	@Then("User check for the delivery time")
	public void user_check_for_the_delivery_time() {
	    cart1=new CartItembyCategory(driver);
	    cart1.deliverycheck();
	}

	@Then("Validate possibility of delivery")
	public void validate_possibility_of_delivery() {
	    String msg=cart1.deliveryresult();
	    String expected_msg="Delivery";
	    assertTrue(msg.contains(expected_msg));
	}

	@When("User Increse the size and number")
	public void user_increse_the_size_and_number() {
		 cart1=new CartItembyCategory(driver);
		 cart1.item_size_and_number();
	}

	@When("User Carts the item")
	public void user_carts_the_item() {
		cart1=new CartItembyCategory(driver);
		cart1.addingtobag();
	}
	
	@Then("Validate item has been added")
	public void validate_item_has_been_added() {
	    String count_number=cart1.bag_count_number();
	    assertEquals(count_number,"2");
	}

}
