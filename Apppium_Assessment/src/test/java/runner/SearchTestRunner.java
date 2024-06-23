package runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue="step_definitions",
		features={"C:\\Users\\268896\\eclipse-workspace\\Apppium_Assessment\\src\\test\\resources\\resources\\features\\Search.feature"},
		
				plugin = { "pretty", "html:cucmberReport/CucmberReport.html"  }
		)

public class SearchTestRunner extends AbstractTestNGCucumberTests{
}
