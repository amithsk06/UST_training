package workflow;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExcelHandling;
import base.ReusableFunctions;
import utilities.ExtentReportsListener;
import utilities.FileIO;

@Listeners(ExtentReportsListener.class)
public class XYZTest // implements ITestListener 
{
	
//	ExtentReportsListener extentReportsListener = new ExtentReportsListener();
	WebDriver driver;
	ReusableFunctions reuse;
	BankManagerLogin m_login;
	Properties prop=FileIO.getProperties();
	int i=0;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = ReusableFunctions.invokeBrowser();
		reuse = new ReusableFunctions(driver);
		reuse.openBrowser("test_url");
		assertEquals(driver.getCurrentUrl(),prop.getProperty("test_url"));
	}
	
	
	@Test(priority=1)
	public void bankManager()
	{
		m_login=new BankManagerLogin(driver);
		m_login.clickLoginbutton();
		m_login.addCustomer();
	}
	
	@DataProvider(name = "Data")
	public String[][] getValidData() throws Exception 
	{
		String[][] data= ExcelHandling.excelHandling(System.getProperty("user.dir")+"/excel.xlsx","Sheet1");
		return data;
	}
	
	@Test(priority=2,dataProvider = "Data")
	public void addingdetails(String data1,String data2,String data3)
	{
		m_login=new BankManagerLogin(driver);
		m_login.cust_Details(data1, data2, data3);
	}
//	@Test(priority=3)
//	public void checkingCust()
//	{
//		m_login=new BankManagerLogin(driver);
//		//m_login.checking_Added_cust();
//	}
	
	@Test(priority=3)
	public void opening_Account()
	{
		m_login=new BankManagerLogin(driver);
		String name=m_login.cust_Name();
		assertEquals(name,"Tex Pyper");
		String currency=m_login.cust_Currency();
		assertEquals(currency,"Rupee");
		m_login.addingaccount();
		m_login.backtoHome();
		assertEquals(driver.getCurrentUrl(),"https://globalsqa.com/angularJs-protractor/BankingProject/#/login");
		
	}

			
		
	
}
