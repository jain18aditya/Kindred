package com.kindred.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/cucumber.html", "json:target/html/cucumber.json",},
		features = {"src/test/resources/features/kindred.feature" }, 
		glue = {"com.kindred.stepdefinition", "com.kindred.hooks" },
		monochrome = true)

public class TestRunner {

}
