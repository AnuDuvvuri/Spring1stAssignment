package com.example.demo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java"}
		,glue={"com.example.demo.stepdefinitions"},
				plugin = {"pretty","html:target/cucumber-report.html"},
				dryRun = false
		)
public class TestRunner {

}
