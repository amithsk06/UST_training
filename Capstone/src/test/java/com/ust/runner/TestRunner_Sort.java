package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="classpath:stepdefinitions",
		features={"classpath:features"},
		tags="@Sort",
		plugin = { "pretty","html:reports/cucumber-reports/sort.html"}
		)
public class TestRunner_Sort extends AbstractTestNGCucumberTests{

}