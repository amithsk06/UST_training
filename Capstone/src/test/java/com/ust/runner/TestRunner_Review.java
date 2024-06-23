package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="classpath:stepdefinitions",
		features={"classpath:features"},
		tags="@ReviewFunctionality",
		plugin = { "pretty","html:reports/cucumber-reports/review.html"}
		)
public class TestRunner_Review extends AbstractTestNGCucumberTests{

}