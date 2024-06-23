package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue="classpath:com.stepdefinitions",
		features={"classpath:features"},
				plugin= { "pretty",
								"html:cucumber-reports/cart.html"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
