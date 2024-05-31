package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features"},
		glue = {"stepDefinitions"},
		//dryRun = false,
		monochrome=true	,	
		//publish = true,
		plugin = {"rerun:Failed scenarios/failed_scenario.txt","pretty",
				"html:target/cucumber-report.html",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunner {

}
