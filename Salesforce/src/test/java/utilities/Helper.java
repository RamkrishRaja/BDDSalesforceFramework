package utilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptionHandling.CustomException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {

	private static Helper Helper;    
	protected static WebDriver driver ;
	protected static Actions act;
	protected static Robot copyPaste;
	public final static int TIMEOUT = 2;
	protected static WebDriverWait w;

	private Helper(){

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

	}
	public static void openPage(String url) {
		driver.get(url);
	}

	public static String getTitle() {
		return driver.getTitle();
	}
	public static void NavBack() {
		driver.navigate().back();
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setUpDriver() {
		if (Helper==null) {
			Helper = new Helper();
		}
	}
	public static void tearDown() {
		//		if(driver!=null) {
		//			driver.close();
		//			driver.quit();
		//		}
		//		Helper = null;
		driver.quit();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();

	}

	public static void screenShortForWebElement(WebElement element, String args) {
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		File file = new File (args);
		try {
			FileHandler.copy(screenshotFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String GetUserName() {
		return "username";
	}

	public static void getCurrentPageURL() {
		driver.getCurrentUrl();
	}

	public static String GetPassword() {
		return "Salesforce";
	}

	public static String getBrowserName() {
		RemoteWebDriver webDriver = (RemoteWebDriver) driver;
		return webDriver.getCapabilities().getBrowserName();
	}

	public static String getBrowserVersion() {
		RemoteWebDriver webDriver = (RemoteWebDriver) driver;
		return webDriver.getCapabilities().getBrowserVersion();
	}

	public static String getPlatform() {
		RemoteWebDriver webDriver = (RemoteWebDriver) driver;
		return webDriver.getCapabilities().getPlatformName().name();
	}

	//	public static void highLights(WebElement args) throws Exception {
	//	JavascriptExecutor jse = (JavascriptExecutor) driver;
	//		jse.executeScript("arguments[0].setAttribute('style','background: red; border: 2px solid black;');", args);
	//
	//	}

	public static void highLights(WebElement args) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');", args);

	}

	public static void highLight(WebElement args) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i <2; i++) {
			jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid green;');", args);
			TimeUnit.MILLISECONDS.sleep(200);
			jse.executeScript("arguments[0].setAttribute('style','background: white; border: 2px solid black;');", args);
			TimeUnit.MILLISECONDS.sleep(200);
		}
	}

	public static String getScreenshot(String screenshotName){	
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Snapshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

	public static void jsExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click()", element);		
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("window.scrollBy(0,1000)");
	}

	public static void jsClick(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}


	public static void clickAction(WebElement element){
		act = new Actions(driver);
		act.moveToElement(element).perform();
		//act.moveToElement(element).doubleClick(element).perform();
		//act.moveToElement(element).clickAndHold(element).perform();
		//act.moveToElement(element).contextClick(element).perform();
	}

	public static void  keyUp(){
		act = new Actions(driver);
		Action action = act.keyDown(Keys.CONTROL).build();
		action.perform();
	}

	public static void  keyDown(){
		act = new Actions(driver);
		Action action = act.keyUp(Keys.CONTROL).build();
		action.perform();
	}

	public static void  keyPress() throws Exception{
		copyPaste = new Robot();
		copyPaste.keyPress(KeyEvent.VK_CONTROL);
	}

	public static void  keyRelease() throws Exception{
		copyPaste = new Robot();
		copyPaste.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static String dbInputs(String tableName ,String location, String name) throws Exception {
		String value = null;
		String tablevalue = "jdbc:mysql://localhost:3307/"+tableName;
		Connection connection = DriverManager.getConnection(tablevalue, "root", "7708");
		Statement statement = connection.createStatement();
		String query = "select * from "+location+";";
		ResultSet executeQuery = statement.executeQuery(query);
		while(executeQuery.next()) {
			if(executeQuery.getString("Fieldnames").contains(name)) {
				value = executeQuery.getString("Filedvalues");
				break;
			}
		}
		return value;
	}

	//	Implicit Wait	
	public void implicitWait(int a) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));		

	}
	//	Explicit Wait
	//	Fluent Wait
	
	public static WebElement presenceOfElement(By element) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			throw new CustomException("Element not available");
		}
	}

	public static WebElement elementToBeClickable(By by) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			throw new CustomException("Element not clickable");

		}
	}

	public static WebElement presenceOfElement1(By element) {
		w = new WebDriverWait(driver,Duration.ofSeconds(30));
		return w.until(ExpectedConditions.presenceOfElementLocated (element));

	}

	public static void waitForVisibility(WebElement element){
		w =  new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.visibilityOf(element));
	}

	public static void untilElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//	Waits until the specified element is selected.
	public static void waitForElementToBeSelected(WebElement element){
		w =  new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.elementToBeSelected(element));
	} 

	//Waits until the specified element is invisible.
	public static void waitForInvisibility(WebElement element){
		w =  new WebDriverWait(driver, Duration.ofSeconds(30));
		w.until(ExpectedConditions.invisibilityOf(element));
	} 
	 
	//	Waits until the specified element contains the given text.
		public static void waitTillTextToBePresent(WebElement element, String text){
			w =  new WebDriverWait(driver, Duration.ofSeconds(30));
			w.until(ExpectedConditions.textToBePresentInElement(element, text));
		} 
}

