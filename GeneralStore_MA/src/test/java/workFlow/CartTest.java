package workFlow;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pom.HomePage;

public class CartTest extends BaseTest {
	HomePage home;
	
	@Test
	public void start()
	{
		home=new HomePage(driver);
	//	String title=home.titlecheck();
		home.titlecheck();
		//assertEquals(title,"General Store");
	}

}
