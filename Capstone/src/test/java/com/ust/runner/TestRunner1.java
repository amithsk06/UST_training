package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="classpath:stepdefinitions",
		features={"classpath:features"},
		plugin = { "pretty","html:reports/cucumber-reports/report..html"}
		)
public class TestRunner1 extends AbstractTestNGCucumberTests{

}