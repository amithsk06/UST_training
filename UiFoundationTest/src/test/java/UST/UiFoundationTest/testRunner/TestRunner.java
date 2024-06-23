package UST.UiFoundationTest.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue={"classpath:UiFoundationTest.stepDefinitions"},
		tags ="@",
		features={"classpath:features/ll.feature",},
		plugin= {"pretty","html:target/site/cucumber-report.html"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
