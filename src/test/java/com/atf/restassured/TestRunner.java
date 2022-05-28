package com.atf.restassured;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = { "src/test/resources/api/featurefiles" }, 
			glue = {"com.atf.restassured.steps" },
			plugin = {"html:target/execution.html"},
			dryRun = false,
			tags = "@regression")
public class TestRunner

{
}
