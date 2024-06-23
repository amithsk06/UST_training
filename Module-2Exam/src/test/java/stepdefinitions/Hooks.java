package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import base.ReusableFunctions;

public class Hooks{

    public static WebDriver driver;
    @Before
    public void setup(){
    	driver= ReusableFunctions.invokeBrowser();
    	ReusableFunctions function = new ReusableFunctions(driver);
    	function.openWebsite(driver);
        driver.manage().window().maximize();
    }
    @After
    public void cleanup() throws InterruptedException {
    	Thread.sleep(3000);
    	driver.quit();
    }


}