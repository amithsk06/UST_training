package pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ReusableFunctions;
import io.reactivex.rxjava3.functions.Action;

public class DemoBlazeSignupandLoginPom {
public WebDriver driver;
public WebDriverWait wait;
public ReusableFunctions functions;

	@FindBy(linkText = "Sign up")
	public WebElement signup;
	
	@FindBy(linkText = "Log in")
	public WebElement login;
	
	@FindBy(xpath = "//div[@id='signInModal']/div/div")
	public WebElement signupmodalelement;
	
	@FindBy(xpath = "//div[@id='logInModal']/div/div")
	public WebElement loginmodalelement;
	
	@FindBy(id = "sign-username")
	public WebElement username;
	
	@FindBy(id = "loginusername")
	public WebElement username1;
	
	@FindBy(id = "sign-password")
	public WebElement password;
	
	@FindBy(id = "loginpassword")
	public WebElement password1;
	
	@FindBy(css = "button[onclick='register()']")
	public WebElement signupbtn;
	
	@FindBy(css = "button[onclick='logIn()']")
	public WebElement loginbtn;
	
	@FindBy(id = "nameofuser")
	public WebElement nameofuser;
	
	public DemoBlazeSignupandLoginPom(WebDriver driver) {
		this.driver = driver;
		functions = new ReusableFunctions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	public void Click_Signup() {
		functions.clickOnElement(signup);
	}
	public void Enter_Username(String string) {
		functions.setTextToInputField(username, string);
	}
	public void Enter_Password(String string) {
		functions.setTextToInputField(password, string);
	}
	public void Enter_loginUsername(String string) {
		functions.setTextToInputField(username1, string);
	}
	public void Enter_loginPassword(String string) {
		functions.setTextToInputField(password1, string);
	}
	public void Click_SignupButton() {
		functions.clickOnElement(signupbtn);
	}
	public void clicklogin() {
		functions.clickOnElement(login);
	}
	
	public void Click_LoginButton() {
		functions.clickOnElement(loginbtn);
	}
	public String Clickalert() {
		wait.until(ExpectedConditions.alertIsPresent());
		Alert al = driver.switchTo().alert();
		String text =al.getText();
		al.accept();
		return text;
	}
	public String getUrl() {
		return functions.geturl(driver);
	}
}
