package ust.GeneralStore;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Reuseable;
import base.Setup;
import pom.ContactsPom;

@Listeners(utils.ExtentReportsListener.class)
public class testContacts extends Setup{
	ContactsPom contact;
	Reuseable reuse;
	
	@BeforeClass
	public void set() {
		contact = new ContactsPom(driver);
		reuse = new Reuseable(driver);
	}
	
	@Test(priority = 1)
	public void testCreateContact() {
		contact.setupForContact();
		contact.clickAdd();
		contact.enterValues();
		contact.clickSave();
	}
	
	@Test(priority = 2)
	public void testEditContact() {
		contact.editContact();
		contact.clickSave();
	}
	
	@Test(priority = 3)
	public void deleteTest() {
		contact.deleteContact();
	}
	
//	@Test(priority = 4)
//	public void searchTest(){
//		contact.setupForContact();
//		contact.selectContact();
//		contact.enterSearchInput("ebin");
//	}	
}
