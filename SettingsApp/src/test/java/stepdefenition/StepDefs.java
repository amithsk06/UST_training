package stepdefenition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.ITestListener;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.NetworkPom;
import utilities.ExtentReportsListener;

public class StepDefs {

	private final AndroidDriver driver = Hooks.driver;
	NetworkPom np;
	@Given("User opens the settings App")
	public void user_opens_the_settings_app() {
		np = new NetworkPom(driver);
	}

	@When("User clicks on nework and internet")
	public void user_clicks_on_nework_and_internet() {
	   np.networkClick();
	}

	@Then("User moves to corresponding page")
	public void user_moves_to_corresponding_page() {
	   assertTrue(np.airPlaneElement().isDisplayed());
	}

	@When("User change airoplane mode")
	public void user_change_airoplane_mode() {
	    np.changeMode();
	}

	@Then("In calls & sms section {string} to be added")
	public void in_calls_sms_section_to_be_added(String string) {
	  assertEquals(np.airplaneMsgGet(),string);
	}


}
