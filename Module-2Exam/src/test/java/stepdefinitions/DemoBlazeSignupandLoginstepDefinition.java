package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.core.CombinableMatcher.CombinableEitherMatcher;
import org.openqa.selenium.WebDriver;

import base.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.DemoBlazeSignupandLoginPom;

public class DemoBlazeSignupandLoginstepDefinition {
	public WebDriver driver =  Hooks.driver;
	DemoBlazeSignupandLoginPom blaze = new DemoBlazeSignupandLoginPom(driver);
	
	@Given("User is already on the demo blaze website")
	public void user_is_already_on_the_demo_blaze_website() {
	    assertEquals(blaze.getUrl(),"https://www.demoblaze.com/");
	}

	@When("User clicks Signup icon")
	public void user_clicks_signup_icon() throws InterruptedException {
	    blaze.Click_Signup();
	    Thread.sleep(2000);
	}

	@Then("User checks if signup Modal is displayed")
	public void user_checks_if_modal_is_displayed() {
	   assertTrue(blaze.signupmodalelement.isDisplayed());
	}

	@When("User enter {string} as username and {string} as password")
	public void user_enter_as_username_and_as_password(String username, String password) throws InterruptedException {
	   blaze.Enter_Username(username);
	   Thread.sleep(1000);
	   blaze.Enter_Password(password);
	   Thread.sleep(1000);
	}

	@When("User clicks signup button")
	public void user_clicks_signup_button() {
	   blaze.Click_SignupButton();
	}
	
	@Then("User checks is {string} is displayed as alert")
	public void user_checks_message_is_displayed_as_alert(String message) {
	   assertEquals(blaze.Clickalert(), message);  
	}
	
	

	@When("User clicks Login icon")
	public void user_clicks_login_icon() throws InterruptedException {
	   blaze.clicklogin();
	   Thread.sleep(1000);
	}
	
	@Then("User checks if login Modal is displayed")
	public void user_checks_if_login_modal_is_displayed() {
	   assertTrue(blaze.loginmodalelement.isDisplayed());
	}
	
	@When("User enter {string} as username and {string} as password in the login fields")
	public void user_enter_as_username_and_as_password_in_the_login_fields(String username, String password) throws InterruptedException {
	   blaze.Enter_loginUsername(username);
	   Thread.sleep(1000);
	   blaze.Enter_loginPassword(password);
	   Thread.sleep(1000);
	}
	
	@When("User clicks login button")
	public void user_clicks_login_button() throws InterruptedException {
		blaze.Click_LoginButton();
		Thread.sleep(1000);
	}

	@Then("User checks is {string} is displayed on the site")
	public void user_checks_is_is_displayed_on_the_site(String string) throws InterruptedException {
		Thread.sleep(3000);
		assertEquals(blaze.nameofuser.getText(),string);
	}
	@Then("Take Screenshot")
	public void takesscreenshot() throws InterruptedException {
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filepath=System.getProperty("user.dir")+"\\Cucumberscreenshots\\failed-"+timestamp+".png";
		ReusableFunctions.takeScreenshot(filepath);
	}
}
