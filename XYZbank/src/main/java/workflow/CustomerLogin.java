package workflow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ReusableFunctions;

public class CustomerLogin {
	public static WebDriver driver;
	public ReusableFunctions reuse;

	public CustomerLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='amount']")
	WebElement amount_textarea;

	public void cust_login() {
		reuse.clickOn(By.cssSelector("button[ng-click='customer()']"), Duration.ofSeconds(5));

	}

	public void nameselection() {
		reuse.clickOn(By.id("userSelect"), Duration.ofSeconds(5));
		reuse.clickOn(By.cssSelector("option[value='2']"), Duration.ofSeconds(5));
		reuse.clickOn(By.xpath("//button[@type='submit']"), Duration.ofSeconds(5));
	}

	public void deposit_money() {
		reuse.clickOn(By.cssSelector("button[ng-class='btnClass2']"), Duration.ofSeconds(5));
		reuse.sendText(amount_textarea, "1000");
		reuse.clickOn(By.cssSelector("button[type='submit']"), Duration.ofSeconds(5));

	}

	public String money_deposited() {
		String success = reuse.getText(By.xpath("//span[@ng-show='message']"));
		// String
		// success=driver.findElement(By.cssSelector("//span[@ng-show='message']"))
		System.out.println(success);
		return success;
	}

}
