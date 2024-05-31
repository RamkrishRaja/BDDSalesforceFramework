package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptionHandling.CustomException;
import staticLocations.FilesPath;

public class SeleniumUtiles implements Selenium{

	protected WebDriver driver;

	public void sendKeys(WebElement element, String values) {
		element.sendKeys(values);

	}

	public String getBrowserName() {
		RemoteWebDriver webDriver = (RemoteWebDriver) driver;
		return webDriver.getCapabilities().getBrowserName();
	}

	public String getBrowserVersion() {
		RemoteWebDriver webDriver = (RemoteWebDriver) driver;
		return webDriver.getCapabilities().getBrowserVersion();
	}

	public String getPlatform() {
		RemoteWebDriver webDriver = (RemoteWebDriver) driver;
		return webDriver.getCapabilities().getPlatformName().name();
	}

	public void click(WebElement element) {
		element.click();

	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void getText(WebElement element) {
		element.getText();

	}

	public void jsExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);	

	}

	public void close() {
		driver.close();	
	}

	public void quit() {
		driver.quit();

	}

	public void scroll(WebElement element, WebDriver driver) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
		} catch (Exception e) {
			throw new CustomException(FilesPath.MOUSE_HOVER_NOT_PERFORMED);
		}
	}

	public void scrollup(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, -250);");
		} catch (Exception e) {
			throw new CustomException(FilesPath.MOUSE_HOVER_NOT_PERFORMED);
		}

	}

	public void scrollDown(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,400)", "");
		} catch (Exception e) {
			throw new CustomException(FilesPath.MOUSE_HOVER_NOT_PERFORMED);
		}

	}


	public void alertAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	@Override
	public void frameSwitch(int i, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void frameSwitchusingxpath(String element, WebDriver driver) {
		try {

			driver.switchTo().frame(driver.findElement(By.xpath(element)));
		} catch (Exception e) {
			throw new CustomException(FilesPath.EXPECTED_FRAME_NOT_FOUND);
		}
	}

	public void switchToDefaultcontent(WebDriver driver) {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new CustomException("Default content not switched");
		}
	}

	public void switchToFrame(WebDriver driver, WebElement frame) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driverWait.until(ExpectedConditions.visibilityOf(frame));
			driver.switchTo().frame(frame);
		} catch (Exception e) {
			throw new CustomException(FilesPath.EXPECTED_FRAME_NOT_FOUND);
		}

	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();

	}

	public void screenShortForWebElement(WebElement element, String args) {
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		File file = new File (args);
			try {
				FileHandler.copy(screenshotFile, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public String getScreenshot(String screenshotName){	
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

	public void dropDownbyValue(WebElement element, String value) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(value);
		} catch (Exception e) {
			throw new CustomException("Dropdown element not found");
		}

	}

	public void dropDownbyIndex(WebElement element, int index) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(index);
		} catch (Exception e) {
			throw new CustomException("Dropdown element not found");
		}

	}

	public void multiPicklist(WebElement preferredColleges, WebElement selectionArea, String readData) {
		String[] multiSelectValues = readData.split(",");

		for (String valuesToBeSelected : multiSelectValues) {
			dropDownbyValue(preferredColleges, valuesToBeSelected);
			selectionArea.click();
		}

	}

	public void untilElementToBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement presenceOfElement(WebDriver driver, By element) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			throw new CustomException("Element not available");
		}
	}

	public WebElement elementToBeClickable(WebDriver driver, By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			throw new CustomException("Element not clickable");

		}
	}

	@Override
	public void switchToWindow(int i) {
		// TODO Auto-generated method stub

	}

	public void switchToTab(WebDriver driver) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
		} catch (Exception e) {
			throw new CustomException(FilesPath.TAB_NOT_FOUND);
		}

	}

	public void switchToCurrentWindow(WebDriver driver) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		} catch (Exception e) {
			throw new CustomException(FilesPath.TAB_NOT_FOUND);
		}
	}

	public void customWait(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));		

	}
}