package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class LogOut extends BaseClass{
	
	@FindBy(xpath = "//span[@class='uiImage']//img[@title='User']//parent::span[@class='uiImage']")
	private WebElement viewProfile;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutButton;

	public WebElement getViewProfile() {
		return viewProfile;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public LogOut(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
