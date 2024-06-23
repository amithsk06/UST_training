package stepDefenition;

import base.Setup;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.ContactsPom;

public class Contacts{
	AndroidDriver driver;
	ContactsPom contact;
	public Contacts() {
		driver = Hooks.driver;
		contact = new ContactsPom(driver);
	}
	
	@Given("User already on contacts page")
	public void user_already_on_contacts_page() {
		contact.setupForContact();
	}

	@When("User adds a new contact")
	public void user_adds_a_new_contact() {
		contact.clickAdd();
		contact.enterValues();
		contact.clickSave();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		System.out.println("Hai");
	}
}
