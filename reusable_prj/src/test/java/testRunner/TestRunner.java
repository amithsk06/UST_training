package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = "stepDefinition",
		features = "C:\\Users\\268852\\eclipse-workspace\\MP\\reusable_prj\\src\\test\\resources\\features"
		
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
