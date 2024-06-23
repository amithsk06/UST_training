package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import base.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.FileIO;
import workflow.CustomerLogin;


public class CustomerLogin_Test {
	public WebDriver driver=Hooks.driver;
	ReusableFunctions reuse;
	CustomerLogin c_login;
	Properties prop=FileIO.getProperties();
	
	@Given("User already open the XYZ Bank site and goes to login page")
	public void user_already_open_the_xyz_bank_site_and_goes_to_login_page() 
	{
		c_login =new CustomerLogin(driver);
		c_login.cust_login();
	}
	
	@When("User input customer name to login")
	public void user_input_customer_name_to_login() 
	{
	    c_login=new CustomerLogin(driver);
	    c_login.nameselection();
	}
	
	@Then("User navigates to accounts page")
	public void user_navigates_to_accounts_page() 
	{
		assertEquals(driver.getCurrentUrl(),prop.getProperty("login_url"));
	    
	}
	@When("User deposits money")
	public void user_deposits_money() {
	    c_login=new CustomerLogin(driver);
	    c_login.deposit_money();
	}
	@Then("Check whether the money has been credited")
	public void check_whether_the_money_has_been_credited() {
		c_login=new CustomerLogin(driver);
		String success=c_login.money_deposited();
		assertEquals(success,"Deposit Successful");
		
	    
	}



}
