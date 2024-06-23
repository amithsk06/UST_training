package pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ReusableFunctions;

public class DemoBlazeCheckoutPom {
	public WebDriver driver;
	public WebDriverWait wait;
	public ReusableFunctions functions;
	
	@FindBy(linkText = "Log in")
	public WebElement login;
	
	@FindBy(xpath = "//div[@id='logInModal']/div/div")
	public WebElement loginmodalelement;
	
	@FindBy(id = "loginusername")
	public WebElement username1;
	
	@FindBy(id = "loginpassword")
	public WebElement password1;
	
	@FindBy(css = "button[onclick='logIn()']")
	public WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class='list-group']/a[3]")
	public WebElement laptop;
	
	@FindBy(className = "btn-success")
	public WebElement addtocart;
	//alert->//Product added.
	
	@FindBy(xpath = "//div[@id='navbarExample']/ul/li[1]/a")
	public WebElement home;
	
	@FindBy(css = "li[class='nav-item']>a[id='cartur']")
	public WebElement cart;
	
	@FindBy(xpath = "//tbody[@id='tbodyid']/tr[1]/td[4]/a")
	public WebElement delete;
	
	@FindBy(id = "nameofuser")
	public WebElement nameofuser;
	
	public DemoBlazeCheckoutPom(WebDriver driver) {
		this.driver = driver;
		functions = new ReusableFunctions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	public void clicklogin() {
		functions.clickOnElement(login);
	}
	
	public void Enter_loginUsername(String string) {
		functions.setTextToInputField(username1, string);
	}
	public void Enter_loginPassword(String string) {
		functions.setTextToInputField(password1, string);
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
	
	public void clickLaptop() {
		functions.clickOnElement(laptop);
	}
	public void clickitem(String item) {
		functions.clickOnElement(driver.findElement(By.linkText(item)));
	}
	public void clickaddtocart() {
		functions.clickOnElement(addtocart);
	}
	public void clickhome() {
		functions.clickOnElement(home);
	}
}
