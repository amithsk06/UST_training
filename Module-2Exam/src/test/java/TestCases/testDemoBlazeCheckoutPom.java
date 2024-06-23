package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ReusableFunctions;
import pom.DemoBlazeCheckoutPom;
import utilities.ConvertToArray;

public class testDemoBlazeCheckoutPom {
public WebDriver driver;
public ReusableFunctions functions;
public DemoBlazeCheckoutPom blaze;
@BeforeClass
public void setup() {
	driver = ReusableFunctions.invokeBrowser();
	blaze = new DemoBlazeCheckoutPom(driver);
	functions= new ReusableFunctions(driver);
	functions.openWebsite(driver);
}
@DataProvider(name="items")
public String[] getdata() {
	File f = new File(System.getProperty("user.dir")+"\\TestData\\Listoflitems.xlsx");
	String sheet = "Sheet1";
	return ConvertToArray.getarray(f,sheet);
}

@Test(priority=0)
public void testclicklogin() throws InterruptedException {
	blaze.clicklogin();
	Thread.sleep(2000);
	assertTrue(blaze.loginmodalelement.isDisplayed());
}
@Test(priority=1)
public void testEnter_loginUsernameandPassword() throws InterruptedException {
	blaze.Enter_loginUsername("Akshay101");
	blaze.Enter_loginPassword("apple12345");
	blaze.Click_LoginButton();
	Thread.sleep(3000);
	assertEquals(blaze.nameofuser.getText(),"Welcome Akshay101");
}

@Test(dataProvider = "items", priority=2)
public void testaddtocart(String items) throws InterruptedException {
	Thread.sleep(1000);
	blaze.clickLaptop();
	Thread.sleep(2000);
	blaze.clickitem(items);
	Thread.sleep(2000);
	blaze.clickaddtocart();
	assertEquals(blaze.Clickalert(),"Product added.");
	Thread.sleep(1000);
	blaze.clickhome();
}
}
