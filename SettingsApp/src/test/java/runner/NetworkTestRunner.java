package runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue="stepdefenition",
		features={"classpath:features"},
//		tags="network",
				plugin = { "pretty", "html:target/cucumber-reports.html" },
				monochrome = true
		)
@Listeners(utilities.ExtentReportsListener.class)
public class NetworkTestRunner extends AbstractTestNGCucumberTests{
}
