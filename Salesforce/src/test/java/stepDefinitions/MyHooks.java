package stepDefinitions;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.Helper;

public class MyHooks {

	//public static Logger logger = LogManager.getLogger(MyHooks.class);

	@Before
	public static void setUp() {
		//logger.info("Success");
		Helper.setUpDriver();
	}

	@After
	public static void tearDown(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Helper.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot"); 
			Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
		}   	
	}
}