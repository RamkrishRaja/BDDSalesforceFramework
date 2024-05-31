package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@Failed scenarios/failed_scenario.txt"},
		glue = {"stepDefinitions"},
		dryRun = false,
		monochrome=true)
public class ExecuteFailedTC {

}
