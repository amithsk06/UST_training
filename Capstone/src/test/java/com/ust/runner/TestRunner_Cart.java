package com.ust.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		glue="classpath:stepdefinitions",
		features={"classpath:features"},
		tags="@PurchaseItemByCategory",
	    plugin = { "pretty","html:reports/cucumber-reports/cart.html"}
		)
public class TestRunner_Cart extends AbstractTestNGCucumberTests{

}
