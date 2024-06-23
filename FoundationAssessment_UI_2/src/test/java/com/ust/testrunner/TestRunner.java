package com.ust.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue={"classpath:com.ust.stepdefinitions"},
		features={"classpath:features/Cart.feature"},
				plugin ={"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
