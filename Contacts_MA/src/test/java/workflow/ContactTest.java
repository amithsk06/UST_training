package workflow;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pom.ContactPage;

public class ContactTest extends BaseTest{
	ContactPage contact;
	
	@Test(priority=0)
	public void startTest()
	{
		contact=new ContactPage(driver);
		contact.skipsign_in();
	}
	
	@Test(priority=1)
	public void newcontactTest()
	{
		contact=new ContactPage(driver);
		contact.new_account();
		assertEquals(contact.getContacttitle(),"Create contact");
		
		contact.setContactDetails();
	}
	@Test(priority=2)
	public void contactcheckTest()
	{
		contact=new ContactPage(driver);
		String[] arr=contact.contactname();
		assertEquals(contact.conatctcheck(),arr[0]+" "+arr[1]);
	}
	@Test(priority=3)
	public void editcontactTest()
	{
		contact=new ContactPage(driver);
		contact.edit_contact();
	}
	

}
