package ust.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ust.base.BaseTest;
import ust.pom.AppTimer;

public class ApptimerTest extends BaseTest {
	AppTimer timer;
	
	@Test(priority=0)
	public void starttest()
	{
		timer=new AppTimer(driver);
		//asserting the title
		assertEquals(timer.title(),"Settings");
		timer.app_opening();
	}
	
	@Test(priority=1)
    public void appTest()
    {
		timer=new AppTimer(driver);
		timer.unusedapps();
		//asserting the titlte 
		assertEquals(timer.dashboard(),"Dashboard");
    }
	@Test(priority=2)	
	public void generalstoreTest()
	{
		timer=new AppTimer(driver);
        timer.generalstore_clickOn();
        //asserting the title
        assertEquals(timer.generalstore(),"GeneralStore");
	}
	@Test(priority=3)	
	public void timerTest()
	{
		timer=new AppTimer(driver);
		timer.timersetting();
	}

}
