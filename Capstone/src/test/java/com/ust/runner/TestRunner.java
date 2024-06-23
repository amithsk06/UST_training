package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="classpath:stepdefinitions",
		features={"classpath:features/"},
		plugin ={"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
