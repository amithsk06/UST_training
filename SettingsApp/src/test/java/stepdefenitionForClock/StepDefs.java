package stepdefenitionForClock;

import static org.testng.Assert.assertTrue;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.AlarmPage;
import pom.NetworkPom;
import stepdefenition.Hooks;

public class StepDefs {
	private final AndroidDriver driver = ClockHooks.driver;
	AlarmPage ap;

	@Given("I am in the clock app")
	public void i_am_in_the_clock_app() {

		ap=new AlarmPage(driver);

	}

	@Given("I click the alarm option")
	public void i_click_the_alarm_option() {
		ap.alarmOptionClick();
		assertTrue(ap.addNewAlarmWebElement().isDisplayed());

	}

	@Given("I click the plus button")
	public void i_click_the_plus_button() {
		ap.addNewAlarmClick();
		assertTrue(ap.okButtonWebElement().isDisplayed());
		
	}

	@Given("I set the time")
	public void i_set_the_time() {
		ap.setupAlarm();

	}

	@When("the user clicks OK")
	public void the_user_clicks_ok() {
ap.okButtonClick();
	}

	@Then("the corresponding details should be displayed")
	public void the_corresponding_details_should_be_displayed() {
		System.out.println("dddddddddddddddddddddddddddd");
ap.alarmTimeDetailsWebElement().getText();
	}



}
