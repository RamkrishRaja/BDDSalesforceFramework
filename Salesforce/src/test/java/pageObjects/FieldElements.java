package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class FieldElements extends BaseClass {

	@FindBy(xpath="//button[@name='salutation']")
	private WebElement salutationName;

	@FindBy(xpath="//button[@data-value='Mr.']")
	private WebElement salutationValue;

	@FindBy(xpath="//input[@name = 'Phone']")
	private WebElement phoneNumber;

	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName;

	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName;

	@FindBy(xpath="//input[@name='MobilePhone']")
	private WebElement mobileNumber;

	@FindBy(xpath="//input[@name='Company']")
	private WebElement companyName;

	@FindBy(xpath="//input[@name='Fax']")
	private WebElement fax;

	@FindBy(xpath="//input[@name='Email']")
	private WebElement email;

	@FindBy(xpath="//input[@name='Website']")
	private WebElement website;

	@FindBy(xpath="//input[@name='NumberOfEmployees']")
	private WebElement numberOfEmployees;

	@FindBy(xpath="//input[@name='Title']")
	private WebElement title;

	@FindBy(xpath="//input[@name='AnnualRevenue']")
	private WebElement annualRevenue;

	@FindBy(xpath="//button[@id='combobox-button-229']")
	private WebElement leadSource;

	@FindBy(xpath="//button[@id='combobox-button-241']")
	private WebElement industry;

	@FindBy(xpath="//button[@id='combobox-button-249']")
	private WebElement leadStatus;

	@FindBy(xpath="//button[@id='combobox-button-262']")
	private WebElement rating;

	@FindBy(xpath="//textarea[@name='street']")
	private WebElement street;

	@FindBy(xpath="//input[@name='city']")
	private WebElement city;

	@FindBy(xpath="//input[@name='postalCode']")
	private WebElement zipPostalCode;

	@FindBy(xpath="//input[@name='province']")
	private WebElement stateProvince;

	@FindBy(xpath="//input[@name='country']")
	private WebElement country;

	@FindBy(xpath="//input[@name='SICCode__c']")
	private WebElement sicCode;

	@FindBy(xpath="	combobox-button-292")
	private WebElement productInterest;

	@FindBy(xpath="//input[@name='NumberofLocations__c']")
	private WebElement numberofLocations;

	@FindBy(xpath="//input[@name='CurrentGenerators__c']")
	private WebElement currentGenerators;

	@FindBy(xpath="//button[@id='combobox-button-309']")
	private WebElement primary;

	@FindBy(xpath="(//div[@class='slds-form-element__control slds-grow textarea-container']//textarea[@class='slds-textarea'])[2]")
	private WebElement description;

	public WebElement getSalutationName() {
		return salutationName;
	}

	public WebElement getSalutationValue() {
		return salutationValue;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}


	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}


	public WebElement getMobileNumber() {
		return mobileNumber;
	}


	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getAnnualRevenue() {
		return annualRevenue;
	}

	public WebElement getLeadSource() {
		return leadSource;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getLeadStatus() {
		return leadStatus;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getZipPostalCode() {
		return zipPostalCode;
	}

	public WebElement getStateProvince() {
		return stateProvince;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getSicCode() {
		return sicCode;
	}
	
	public WebElement getProductInterest() {
		return productInterest;
	}

	public WebElement getNumberofLocations() {
		return numberofLocations;
	}

	public WebElement getCurrentGenerators() {
		return currentGenerators;
	}

	public WebElement getPrimary() {
		return primary;
	}

	public WebElement getDescription() {
		return description;
	}

	public FieldElements(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
}
