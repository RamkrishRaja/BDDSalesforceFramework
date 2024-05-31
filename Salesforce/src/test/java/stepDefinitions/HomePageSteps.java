package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.Helper;

public class HomePageSteps extends BaseClass{
	
	Logger logger = LogManager.getLogger(HomePageSteps.class);

	@Given("user should be in salesforce home page")
	public void salesforceHomePage(){
		logger.info("Logged in to Salesforce Successfully");
		homePage = new HomePage(Helper.getDriver());
		String currentUrl = Helper.getDriver().getCurrentUrl();
		if (currentUrl.contains("lightning/setup/SetupOneHome/home")) {
			System.out.println("Home page verified successfully @2: "+currentUrl);
			logger.info("User in SF home page");
		} else {
			System.out.println("Umm! Hmm!! this is not our desier HomePage");
			
			logger.error("Salesforce Home page validation failed");
		}
	}

	@When("user clicks the applauncher")
	public void clicksApplauncher() {
		Helper.untilElementToBeClickable(homePage.getAppLauncher());
	    homePage.getAppLauncher().click();
	    
	}

	@When("user should enter leads object name in the applauncer search box")
	public void enterLeadSearch() throws Exception {
		Thread.sleep(1000);
		Helper.highLight(homePage.getSearchBox());
		Helper.getScreenshot("Applauncher");
		homePage.getSearchBox().sendKeys("Leads");
	}

	@When("clicks object name or press Enter key")
	public void clickObject() {
		homePage.getObjectName().click();
	    
	}

	@Then("system should navigate to the Lead records list view page")
	public void navigateLeadPage() {
		String leadName = homePage.getleadObject().getText();
		if (leadName.contains("Leads")) {
			System.out.println("System navigated to "+leadName+" successfully.");
		} else {
			System.out.println("System navigated to wrong page.");
			
		}
	   
	}
}
