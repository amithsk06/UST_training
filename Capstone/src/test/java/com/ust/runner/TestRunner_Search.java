package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="classpath:stepdefinitions",
		features={"classpath:features"},
		tags="@Search",
		plugin = { "pretty",
	    					"html:reports/cucumber-reports/search.html"}






		)
public class TestRunner_Search extends AbstractTestNGCucumberTests{

}
