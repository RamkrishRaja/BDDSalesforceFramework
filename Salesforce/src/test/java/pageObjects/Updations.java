package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;
import utilities.Helper;

public class Updations extends BaseClass {


	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Accounts')]")
	private WebElement accounts;

	@FindBy(xpath = "//a[@title='VerTech'][contains(text(),'VerTech')]")
	private WebElement accountName;

	@FindBy(xpath = "//a[@id='detailTab__item'][contains(text(),'Details')]")
	private WebElement detailsTabAccount;

	@FindBy(xpath = "//button[@title='Edit Account Number']")
	private WebElement editAccountNumberIcon;

	@FindBy(xpath = "//input[@name='AccountNumber']")
	private WebElement accountNumberBox;

	@FindBy(xpath = "//a[@id='relatedListsTab__item']")
	private WebElement accountRealtedTab;

	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Contacts')]")
	private WebElement  contactTab;	

	@FindBy(xpath = "//a[@title='Ram Krishna']")
	private WebElement contactName;

	@FindBy(xpath = "//span[contains(text(),'Upload Files')]")
	private WebElement contactFileUploads;

	@FindBy(xpath = "//span[contains(text(),'Done')]")
	private WebElement contactPopup;

	@FindBy(xpath = "//button[@name='SaveEdit'][contains(text(),'Save')]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@title='Thank+you+PDF']")
	private WebElement pdfFile;

	@FindBy(xpath = "//span[@class='slds-truncate'][contains(text(),'Opportunities')]")
	private WebElement opportunityObject;

	@FindBy(xpath = "//a[@title='VerTech-'][contains(text(),'VerTech-')]")
	private WebElement opportunityName;

	@FindBy(xpath = "(//a[@id='detailTab__item'][contains(text(),'Details')])[2]")
	private WebElement detailsTabOpportunity;

	@FindBy(xpath = "//button[@title='Edit Opportunity Name']")
	private WebElement editOppNameIcon;

	@FindBy(xpath = "//input[@name='Name']")
	private WebElement oppNameBox;

	@FindBy(xpath = "(//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value'])[2]")
	private WebElement oppStage;
	
	@FindBy(xpath = "(//span[@class='slds-truncate'][contains(text(),'Closed Won')])[2]")
	private WebElement oppStageValue;

	@FindBy(xpath = "//a[@title='Closed']")
	private WebElement stageClosed;

	@FindBy(xpath = "//span[@class='uiOutputText'][contains(text(),'Select Closed Stage')]")
	private WebElement stageClosedButton;

	@FindBy(xpath = "//button[@title='Edit Stage']")
	private WebElement stageEditIcon;

	@FindBy(xpath = "//button[@id='combobox-button-683']")
	private WebElement stageDropDown;

	@FindBy(xpath = "//button[@id='combobox-button-683']//span[@class='slds-truncate'][contains(text(),'Closed Won')]")
	private WebElement stageClose;

	public WebElement getAccounts() {	
		Helper.jsExecutor(accounts);	
		return accounts;
	}

	public WebElement getAccountName() {
		return accountName;
	}

	public WebElement getDetailsTabAccount() {
		//Helper.jsExecutor(detailsTabAccount);
		return detailsTabAccount;
	}

	public WebElement getEditAccountNumberIcon() {
		return editAccountNumberIcon;
	}

	public WebElement getAccountNumberBox() {
		return accountNumberBox;
	}

	public WebElement getAccountRealtedTab() {
		return accountRealtedTab;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getContactTab() {
		Helper.jsExecutor(contactTab);
		return contactTab;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getContactFileUploads() {
		Helper.jsExecutor(contactFileUploads);
		return contactFileUploads;
	}

	public WebElement getContactPopUpDone() {
		Helper.jsExecutor(contactPopup);
		return contactPopup;
	}

	public WebElement getPdfFile() {
		return pdfFile;
	}
	
	public WebElement getOpportunityObject() {
		Helper.jsExecutor(opportunityObject);
		return opportunityObject;
	}

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getDetailsTabOpportunity() {
		return detailsTabOpportunity;
	}

	public WebElement getEditOppNameIcon() {
		return editOppNameIcon;
	}

	public WebElement getOppNameBox() {
		return oppNameBox;
	}

	public WebElement getStageClosed() {
		return stageClosed;
	}

	public WebElement getStageClosedButton() {
		return stageClosedButton;
	}

	public WebElement getStageEditIcon() {
		return stageEditIcon;
	}

	public WebElement getStageDropDown() {
		return stageDropDown;
	}

	public WebElement getStageClose() {
		return stageClose;
	}
	
	public WebElement getOppStage() {
		Helper.jsExecutor(oppStage);
		return oppStage;
	}
	
	public WebElement getOppStageValue() {
		Helper.scrollIntoView(oppStageValue);
		Helper.jsExecutor(oppStageValue);
		return oppStageValue;
	}

	public Updations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
