package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath="//div[@class='slds-icon-waffle']")
	private WebElement appLauncher;
	
	@FindBy(xpath="//input[@class='slds-input']")
	private WebElement searchBox;

	@FindBy(xpath="//b[contains(text(),'Leads')]")
	private WebElement objectName;

	@FindBy(xpath="//span[@class='slds-truncate'][contains(text(),'Leads')]")
	private WebElement leadObject;

	public WebElement getAppLauncher() {
		return appLauncher;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getObjectName() {
		return objectName;
	}

	public WebElement getleadObject() {
		return leadObject;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
