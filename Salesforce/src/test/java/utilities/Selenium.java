package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * @author  Ramakrishnan Raja
 * Created date: Nov 27, 2023
 * Last Edited by: Ramakrishnan Raja
 * Last Edited date: 
 * Description: This Interface contain similar Selenium based functions.
 */
public interface Selenium {
	
	/**
	 * Description - This method will send the values in the text box.
	 * @param element - Locate the exact WebElement.
	 * @param values - Pass the values to the associated element.
	 * @throws IllegalArgumentException if keysToSend is null.
	 */
	void sendKeys(WebElement element, String values);

	/**
	 * Description - This method will get the currently opened browser.
	 * @return - The resulting String value.
	 */
	String getBrowserName();

	/**
	 * Description - This method will get the currently opened browser's version.
	 * @return - The resulting String value.
	 */
	String getBrowserVersion();

	/**
	 * Description - This method will get the currently opened browser's platform.
	 * @return - The resulting String value.
	 */
	String getPlatform();

	/**
	 * This method will perform click actions to the WebElements.
	 * It is from WebElement Interface.
	 * There are some preconditions for an element to be clicked such that element must be visible, and it must have a height and width greater than 0.
	 * @param element - click the desirer WebElement.
	 * @throws StaleElementReferenceException If the element no longer exists as initially defined
	 */
	void click(WebElement element);

	/** 
	 * This method will get the title of the web page.
	 * Get a string representing the current URL that the browser is looking at.
	 * @return The URL of the page currently loaded in the browser
	 */
	String getPageUrl();

	/**
	 * This method will get the title of the web page.
	 * @return The title of the current page
	 */
	String getTitle();

	/**
	 * This method will get the text from WebElement.
	 * @return A WebElement text as an String value.
	 */
	void getText(WebElement element);

	//TODO; This function is under build status.
	void jsExecutor(WebElement element);

	/**
	 * This method will perform close the current browser.
	 * Close the current window, quitting the browser if it's the last window currently open.
	 * This close() method is from webDriver interface.
	 */
	void close();

	/**
	 * This method will perform close all the windows.
	 * Quits this driver, closing every associated window.
	 */
	void quit();

	//Action
	/**
	 * This method will scroll the window.
	 * @param element - To mentioned the WebElement location.
	 * @param driver - 
	 */
	void scroll(WebElement element, WebDriver driver);

	/**
	 * This method will scroll up the window.
	 * @param element - To mentioned the WebElement location.
	 * @param driver - 
	 */
	void scrollup(WebDriver driver);

	/**
	 * This method will scroll down the window.
	 * @param element - To mentioned the WebElement location.
	 * @param driver - 
	 */
	void scrollDown(WebDriver driver);

	//Alert
	/**
	 * This method is used to accept or click the alart pop-up box.
	 * @param driver
	 */
	void alertAccept(WebDriver driver);

	//Frames
	/**
	 * This method is navigate into current window to frame.
	 * @param i - Frame index
	 * @param driver - 
	 */
	void frameSwitch(int i, WebDriver driver);

	/**
	 * This method is navigate into current window to frame by using the locators. 
	 * @param element - To mentioned the WebElement location.
	 * @param driver - 
	 */
	void frameSwitchusingxpath(String element, WebDriver driver);

	/**
	 * This method will navigate back to the default frame or main frame.
	 * @param driver - 
	 */
	void switchToDefaultcontent(WebDriver driver);

	/**
	 * This method is navigate into current window to frame.
	 * @param driver - 
	 * @param frame - To mentioned the WebElement location.
	 */
	void switchToFrame(WebDriver driver, WebElement frame);

	//Navigation
	/**
	 * This method will refresh the current window.
	 * @param driver - 
	 */
	void refresh(WebDriver driver);

	//Screen Shot	

	/**
	 * It will going to capture the particular WebElement.
	 * Capture the screenshot and store it in the specified location. 
	 * @param element - To mentioned the WebElement location.
	 * @param args - Location to store the screen shot in specified folder.
	 */
	void screenShortForWebElement(WebElement element, String screenshotName);
	
	/**
	 * It will going to capture the entire web page.
	 * @param args -Location to store the screen shot in specified folder.
	 * @return IOException
	 */
	String getScreenshot(String screenshotName) throws Exception;

	//Select
	/**
	 * This function is used to select the dropdown with the given value.
	 * @param element - To mentioned the WebElement location.
	 * @param salutationValue - Dropdown value name. 
	 */
	void dropDownbyValue(WebElement element, String salutationValue);

	/**
	 * This function is used to select the dropdown with the given index.
	 * @param element - To mentioned the WebElement location.
	 * @param salutationIndex - 
	 */
	void dropDownbyIndex(WebElement element, int salutationIndex);

	/**
	 * This function is used to select the dropdown with the given multi select values.
	 * @param preferredColleges - Exact order number of the desier drop down value.
	 * @param selectionArea - To mentioned the WebElement location.
	 * @param readData - 
	 */
	void multiPicklist(WebElement preferredColleges, WebElement selectionArea, String readData);

	//Wait
	// Method for explicit wait (ElementToBeClickable)
	/**
	 * 
	 * @param element - To mentioned the WebElement location.
	 * @param driver -
	 */
	void untilElementToBeClickable(WebElement element, WebDriver driver);
	
	void customWait(int a);

	/**
	 * 
	 * @param driver - 
	 * @param by - artibute value
	 * @return
	 */
	WebElement presenceOfElement(WebDriver driver, By by);

	/**
	 * 
	 * @param driver
	 * @param by - artibute
	 * @return
	 */
	WebElement elementToBeClickable(WebDriver driver, By by);

	//WindowHandiling
	/**
	 * This method is used to switch to specific window
	 * @param i - window id
	 */
	void switchToWindow(int i);

	/**
	 * This method is used to switch to specific tab.
	 * @param driver - 
	 */
	void switchToTab(WebDriver driver);

	/**
	 * This method is used to switch to current window.
	 * @param driver - 
	 */
	void switchToCurrentWindow(WebDriver driver);
}
