package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class LeadCreation extends BaseClass{

	@FindBy(xpath="//div[contains(text(),'New')]")
	private WebElement newButton;
	
	@FindBy(xpath="//button[@name='SaveAndNew']")
	private WebElement saveAndNewButton;

	@FindBy(xpath="//button[@class='slds-button slds-button_brand']")
	private WebElement saveButton;

	@FindBy(xpath="//button[@class='slds-button slds-button_brand'][contains(text(),'Convert')]")
	private WebElement layoutConvertButton;

	@FindBy(xpath="//button[contains(text(),'Convert')]//parent::button[@type='button']")
	private WebElement convertButton;

	@FindBy(xpath="//h2[@class='title slds-text-heading--medium slds-hyphenate'][contains(text(),'Convert Lead ')]")
	private WebElement convertLeadText;

	@FindBy(xpath="//h2[contains(text(),'Your lead has been converted')]//parent::div[@class='title']//parent::div[@class='header']")
	private WebElement successMessage;

	@FindBy(xpath="//div[@class='containerBody']")
	private WebElement leadCreationSuccessfully;

	@FindBy(xpath="(//a[@title ='VerTech'][contains(text(),'VerTech')])[1]")
	private WebElement accName;

	@FindBy(xpath="(//a[@title ='Ram Krishna'][contains(text(),'Ram Krishna')])[1]")
	private WebElement contName;	
	
	@FindBy(xpath="(//a[@title ='VerTech-'][contains(text(),'VerTech-')])[1]")
	private WebElement oppName;	
	
	@FindBy(xpath="//button[contains(text(),'Go to Leads')]")
	private WebElement goToLeads;

	public WebElement getNewButton() {
		newButton.click();
		return newButton;
	}

	public WebElement getSaveAndNewButton() {
		return saveAndNewButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLayoutConvertButton() {
		return layoutConvertButton;
	}

	public WebElement getConvertLeadText() {
		return convertLeadText;
	}

	public WebElement getConvertButton() {
		return convertButton;
	}

	public WebElement getSuccessMessage1() {
		return successMessage;
	}
	
	public String getSuccessMessage() {
		return successMessage.getText();
	}

	public WebElement getAccName() {
		return accName;
	}
	
	public WebElement getContName() {
		return contName;
	}
	
	public WebElement getOppName() {
		return oppName;
	}
	
	public WebElement getGoToLeads() {
		return goToLeads;
	}

	public WebElement getLeadCreationSuccessfully() {
		return leadCreationSuccessfully;
	}

	public LeadCreation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
