package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserEnvironment {

	protected static WebDriver driver;
	public final static int TIMEOUT = 2;
	
	public enum BrowsersName {
		FIREFOX, CHROME, EDGE, SAFARI;
	}

	public static WebDriver initializeDriver(BrowsersName driverType) {
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			switch (driverType) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case EDGE:	
				driver = new EdgeDriver();
				break;
			case SAFARI:	
				driver = new SafariDriver();
				break;
			default:
				break;
			}
		}else if (os.contains("Linux")) {
			switch (driverType) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case EDGE:	
				driver = new EdgeDriver();
				break;
			case SAFARI:	
				driver = new SafariDriver();
				break;
			default:
				break;
			}
		}else if (os.contains("macOS")) {
			switch (driverType) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case EDGE:	
				driver = new EdgeDriver();
				break;
			case SAFARI:	
				driver = new SafariDriver();
				break;
			default:
				break;
			}
		}
		return driver;
	}
	public static WebDriver launchDriver() {
		ConfigProperties.loadConfig();
		String newDriverName = ConfigProperties.getProperties().getProperty("Browser");
		try {
			initializeDriver(BrowsersName.valueOf(newDriverName));
		} catch (Exception e) {
			System.out.println("Browser : " + newDriverName + " is invalid, launch CHROME, FIREFOX, EDGE or SAFARI as a choice of browser..");
		
		}
		return driver;
	}
		public static WebDriver launchURL() {
			ConfigProperties.loadConfig();
		try {
			driver.manage().window().maximize();
			new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
			driver.get(ConfigProperties.getProperties().getProperty("URL"));
		} catch (Exception e) {
			System.out.println("Browser maximization and URL enter failed....!");
		}	
		return driver;
	}

}
