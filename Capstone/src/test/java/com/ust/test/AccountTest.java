package com.ust.test;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.BaseLoginTest;
import com.ust.pom.AccountPage;
import com.ust.utilities.DataProviders;
import com.ust.utilities.ExtentReportsListener;
import com.ust.utilities.FileIO;

@Listeners(ExtentReportsListener.class)
public class AccountTest extends BaseLoginTest {
	AccountPage account;
	Properties prop=FileIO.getProperties();
	
	//----navigate to edit information page----//
	@Test(priority=0)
	public void account_dashboard()
	{
		account=new AccountPage(driver);
		assertEquals(prop.getProperty("DASHBOARD_URL"),driver.getCurrentUrl());
		account.dashboard();
		assertEquals(prop.getProperty("EDIT_INFO_URL"),driver.getCurrentUrl());		
	}
	
	//----providing credentials to edit_info page-------//
	@Test(priority=1)
	public void edit_info()
	{
		account.edit_information();
		assertEquals(prop.getProperty("DASHBOARD_URL"),driver.getCurrentUrl());
	}
	//-----address page-----//
	@Test(priority=2)
	public void address()
	{
		//--to address page---//
		account.to_addresspage();
		assertEquals(prop.getProperty("ADDRESSES"),driver.getCurrentUrl());
		
		//---set up new address---//
		account.new_address();
		assertEquals(prop.getProperty("ADDRESSES")+"new/",driver.getCurrentUrl());
	}
	
	
	@Test(priority=3,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void adding_new_address(String data1,String data2,String data3,String data4,String data5)
	{
		account.new_address_details(data1, data2, data3, data4, data5);
	}
	@Test(priority=4)
	public void saving_the_address()
	{
		account.save();
		assertEquals(prop.getProperty("SAVE_ADDRESS_URL"),driver.getCurrentUrl());
	}
	
	@Test(priority=5)
	public void order()
	{
		account.to_order();
		String heading=account.orderhistory();
		assertEquals(prop.getProperty("ORDER_HEADING"),heading);
		assertEquals(prop.getProperty("ORDERS_URL"),driver.getCurrentUrl());
	}
	@Test(priority=6)
	public void wishlist()
	{
		account.to_wishlist();
		String heading=account.wishlist();
		assertEquals(prop.getProperty("WISHLIST_HEADING"),heading);
		assertEquals(prop.getProperty("WISHLIST_URL"),driver.getCurrentUrl());
		
	}	
	@Test(priority=7)
	public void newsletter()
	{
		account.to_newsletter();
		String heading=account.subscription();
		assertEquals(prop.getProperty("NEWSLETTER_HEADING"),heading);
		assertEquals(prop.getProperty("NEWSLETTER_URL"),driver.getCurrentUrl());
		account.clicking_general_subscription();
		//asserting if the dashboard page is loaded//
		assertEquals(prop.getProperty("DASHBOARD_URL"),driver.getCurrentUrl());
	}
	
	@Test(priority=8)
	public void newPassword()
	{
		account.to_changePassword();
		String heading=account.password_validation();
		assertEquals(prop.getProperty("PASSWORD_HEADING"),heading);
		account.changePassword();
	}
}
