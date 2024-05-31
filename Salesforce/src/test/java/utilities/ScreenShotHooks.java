package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ScreenShotHooks {
	protected WebDriver driver;
	public ScreenShotHooks(WebDriver driver) {
		this.driver = driver;
	}
	@After
	private void takeScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshotAs, "image/png", "FailedScreenshot");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
