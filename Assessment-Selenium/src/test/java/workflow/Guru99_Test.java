package workflow;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ExcelHandling;
import base.ReusableFunctions;
import workflows.Telecom_Project;

public class Guru99_Test 
{
		WebDriver driver;
		ReusableFunctions reuse;
		Telecom_Project t_project;

	
	@BeforeClass
	public void openBrowser()
	//opening the browser
	{
		driver = ReusableFunctions.invokeBrowser();
		reuse = new ReusableFunctions(driver);
		reuse.openBrowser("test_url");
		t_project=new Telecom_Project(driver);
//		t_project.setup();
	}
	
	@Test(priority = 1)
	public void telecom_project_page()
	{
		t_project=new Telecom_Project(driver);
		//accessing telecome page
		t_project.accessingTelecom();
		//adding a customer
		t_project.addingCustomer();
	}
	
	@DataProvider(name = "ValidData")
	public String[][] getValidData() throws Exception {
		String[][] data= ExcelHandling.excelHandling(System.getProperty("user.dir")+"/excel.xlsx","Sheet1");
		return data;
	}
	
	@Test(priority = 2 ,dataProvider="ValidData")
	public void add_Customer(String data1,String data2,String data3,String data4) throws Exception
	{
		t_project=new Telecom_Project(driver);
		t_project.cust_data(data1, data2, data3, data4);
		
		
		
	}
}
