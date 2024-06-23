package ust.com.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ust.com.basetest.BaseTest;

import ust.com.pom.Contact;
import ust.com.pom.CreateContact;
import ust.com.pom.HomePage;
import ust.com.utils.DataProviders;

@Listeners(ust.com.utils.ExtentReportsListener.class)
public class ContactsTest extends BaseTest{
	HomePage home;
	CreateContact create;
	Contact contacts;
	
@Test(priority=0)
public void startTest()
{
	home=new HomePage(driver);
	home.clickSkip();
	home.clickAllow();
	home.clickAdd();
	create=new CreateContact(driver);
	create.enterFirstName("Tex");
	create.enterLastName("Pyper");
	create.enterCompany("Ust");
	create.enterNumber("6238383072");
	create.enterEmail("ask@gmail.com");
	create.clickSave();
	contacts=new Contact(driver);
	assertEquals(contacts.validateContactName().equals("Tex Pyper"), true);
}



@Test( priority =1 ,dataProviderClass = DataProviders.class,dataProvider = "Jsondata")
public void testenterData(HashMap<String,String> map) throws IOException, InterruptedException {
	home=new HomePage(driver);
	home.clickSkip();
	home.clickAllow();
	home.clickSearch();
	String name=map.get("First_name");
	home.enterSearchInput(name);
}

}
