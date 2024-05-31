package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class LogIn extends BaseClass {
	@FindBy(id="username")
	@CacheLookup
	private WebElement username;

	@FindBy(id="password")
	@CacheLookup
	private WebElement password;

	@FindBy(id="Login")
	@CacheLookup
	private WebElement loginButton;

	@FindBy(xpath="//title[contains(text(),'Home | Salesforce')]")
	@CacheLookup
	private WebElement homePageTitle;

	@FindBy(xpath="//div[contains(text(),'Please enter your password.')]")
	@CacheLookup
	private WebElement missingPasswordERMSG;

	@FindBy(xpath="//div[@id='error']")
	@CacheLookup
	private WebElement incorrectUsernameorPasswordERMSG;

	public void setUsername(String uName) {
		username.clear();
		username.sendKeys(uName);
	}

	public void setPassword(String passwordS) {
		password.clear();
		password.sendKeys(passwordS);
	}

	public void setLoginButton() {
		loginButton.click();
	}

	public String getHomePageTitle() {
		return homePageTitle.getText();
	}

	public String getMissingPasswordERMSG() {
		return missingPasswordERMSG.getText();  
	}

	public String getIncorrectUsernameorPasswordERMSG() {
		return incorrectUsernameorPasswordERMSG.getText();  
	}

	public LogIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
