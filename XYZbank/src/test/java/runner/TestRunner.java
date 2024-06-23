package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="stepdefinitions",
		features={"src/test/resources/features"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
