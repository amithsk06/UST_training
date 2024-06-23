package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pom.ClockHomePage;
import pom.TimerPage;
@Listeners(utilities.ExtentReportsListener.class)
public class ClockAppTest extends Basetest {
    ClockHomePage homePage;
    TimerPage timerPage;

    @BeforeClass
    public void init() {
        try {
            setup(); // Call setup method from Basetest
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        homePage = new ClockHomePage(driver);
        timerPage = new TimerPage(driver);
    }

    @Test(priority = 1)
    public void plusIconTest() {
        homePage.plusIconClick();
        assertTrue(homePage.getStartedWebElement().isDisplayed(), "Get Started button is not displayed.");
        homePage.getStartedClick();
        
    }

    @Test(priority = 2)
    public void regularAlarmTest() {
    	String beforeTime=homePage.getIncreasedtime();
    	homePage.increaseTime();
    	String afterTime=homePage.getIncreasedtime();
    	assertNotEquals(beforeTime,afterTime);
    	homePage.nextButtonClick();
    	homePage.doneButtonClick();
    	assertTrue(homePage.bedTimeWebElement().isDisplayed());
    	
    }
    @Test(priority=3)
    public void timerTest() {
    	homePage.timerClick();
    	assertTrue(timerPage.timeBarWebElement().isDisplayed());
    	timerPage.setTime();
    	timerPage.timeStartButtonClick();
    	assertTrue(timerPage.getTimeInTimer().isDisplayed());
    	
    }
    @Test(priority=4)
    public void deleteTimerTest() {
    	timerPage.deleteButtonClick();
    	assertTrue(timerPage.timeBarWebElement().isDisplayed());
    }
}
