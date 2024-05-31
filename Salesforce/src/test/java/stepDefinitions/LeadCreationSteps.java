package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FieldElements;
import pageObjects.LeadCreation;
import utilities.Helper;

public class LeadCreationSteps extends BaseClass{

	Logger logger = LogManager.getLogger(LeadCreationSteps.class);

	@Given("user should be in salesforce lead list view page")
	public void listViewPage() {
		leadCreation = new LeadCreation(Helper.getDriver());
		String currentUrl = Helper.getDriver().getCurrentUrl();
		Helper.getScreenshot("Lead");
		if (currentUrl.contains("/lightning/o/Lead/list")) {
			System.out.println("Lead page verified successfully @2: "+currentUrl);
			logger.info("Lead page visible");
		} else {
			System.out.println("Umm! Hmm!! this is not our desier Lead list view page.");
			logger.warn("Lead page not visiable");
		}
	}

	@When("user click New button")
	public void clickNew() {
		Helper.untilElementToBeClickable(leadCreation.getNewButton());
		leadCreation.getNewButton().click();
	}

	@Then("New Lead popup should get open")
	public void openPopup() {
		Helper.waitForVisibility(leadCreation.getSaveAndNewButton());
		Helper.getScreenshot("Leadcreation");
		if (leadCreation.getSaveAndNewButton().isDisplayed()) {
			System.out.println("Lead creation pop opned and "+leadCreation.getSaveAndNewButton().getSize()+" is the Save & New button size.");
			logger.info("Lead record creation page opend");
		}else {
			System.out.println("Lead creation pop was not opend.");
			logger.error("New button in Lead not working");
		}
	}

	@Then("user enters values in all required fields")
	public void requiredFields() throws Exception {

		fieldElements = new FieldElements(Helper.getDriver());

		//Lead Information

		//fieldElements.getSalutationName().click();
		//fieldElements.getSalutationValue().click();

		Thread.sleep(1000);
		fieldElements.getFirstName().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","First Name"));
		fieldElements.getLastName().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Last Name"));
		fieldElements.getPhoneNumber().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Phone"));
		fieldElements.getMobileNumber().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Mobile"));
		fieldElements.getCompanyName().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Company"));
		fieldElements.getFax().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Fax"));
		fieldElements.getEmail().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Email"));
		fieldElements.getWebsite().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Website"));
		fieldElements.getNumberOfEmployees().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","No. of Employee"));
		fieldElements.getTitle().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Title"));
		fieldElements.getAnnualRevenue().sendKeys(Helper.dbInputs("TextFieldValues","LeadInformation","Annual Revenue"));

		//fieldElements.getLeadSource().click();
		//fieldElements.getIndustry().click();
		//fieldElements.getLeadStatus().click();
		//fieldElements.getRating().click();

		//Address Information
		fieldElements.getStreet().sendKeys(Helper.dbInputs("TextFieldValues","AddressInformation","Street"));
		fieldElements.getCity().sendKeys(Helper.dbInputs("TextFieldValues","AddressInformation","City"));
		fieldElements.getZipPostalCode().sendKeys(Helper.dbInputs("TextFieldValues","AddressInformation","Zip/Postal Code"));
		fieldElements.getStateProvince().sendKeys(Helper.dbInputs("TextFieldValues","AddressInformation","State/Province"));
		fieldElements.getCountry().sendKeys(Helper.dbInputs("TextFieldValues","AddressInformation","Country"));

		//Additional Information
		fieldElements.getSicCode().sendKeys(Helper.dbInputs("TextFieldValues","AdditionalInformation","SIC Code"));
		fieldElements.getNumberofLocations().sendKeys(Helper.dbInputs("TextFieldValues","AdditionalInformation","Number of Locations"));
		fieldElements.getCurrentGenerators().sendKeys(Helper.dbInputs("TextFieldValues","AdditionalInformation","Current Generator(s)"));

		//fieldElements.getPrimary().click();
		//fieldElements.getProductInterest().click();

		//Description Information
		fieldElements.getDescription().sendKeys(Helper.dbInputs("TextFieldValues","DescriptionInformation","Description"));

	}

	@Then("clicks Save button")
	public void clickSave() {
		leadCreation.getSaveButton().click();
	}

	@Then("new lead should be created")
	public void leadCreated() {
		Helper.getScreenshot("Leadrecord");
		System.out.println("Lead Created");
		logger.info("Lead record saved");
	}

	@When("user click the conver button")
	public void clickConvert(){
		Helper.untilElementToBeClickable(leadCreation.getConvertButton());
		leadCreation.getConvertButton().click();
	}

	@When("Convert Lead popup should open")
	public void convertPopup(){
		Helper.getScreenshot("Leadtext");
		Helper.waitTillTextToBePresent(leadCreation.getConvertLeadText(), "Convert Lead");
		if (leadCreation.getConvertLeadText().isDisplayed()) {
			System.out.println("Lead convert popup opend");
		} else {
			System.out.println("Convert button not working");
		}
	}

	@When("user clicks Convert button")
	public void clickConvertButton() throws Exception {
		Helper.untilElementToBeClickable(leadCreation.getLayoutConvertButton());
		Thread.sleep(2000);
		leadCreation.getLayoutConvertButton().click();

		Helper.untilElementToBeClickable(leadCreation.getAccName());
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		leadCreation.getAccName().sendKeys(selectLinkOpeninNewTab);

		Helper.untilElementToBeClickable(leadCreation.getContName());
		leadCreation.getContName().sendKeys(selectLinkOpeninNewTab);

		Helper.untilElementToBeClickable(leadCreation.getOppName());
		leadCreation.getOppName().sendKeys(selectLinkOpeninNewTab);
	}

	@Then("succes message diolouge box")
	public void succesDiolougeBox()  {
		Helper.waitTillTextToBePresent(leadCreation.getSuccessMessage1(), "Your lead has been converted");
		if (leadCreation.getSuccessMessage().contains("Your lead has been converted")) {
			System.out.println("Lead has been converted");
			logger.info("Lead has been converted");
		} else {
			System.out.println("Lead has been not converted");
			logger.error("Lead was not coverted");
		}
	}

	@Then("click Go To Leads")
	public void goLeads(){
		leadCreation.getGoToLeads().click();
	}
}
