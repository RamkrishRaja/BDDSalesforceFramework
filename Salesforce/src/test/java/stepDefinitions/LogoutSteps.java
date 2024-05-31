package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogOut;
import utilities.Helper;

public class LogoutSteps extends BaseClass{
	
	Logger logger = LogManager.getLogger(LogoutSteps.class);

	@Given("user should login to salesforce")
	public void readyToLogout() {
		logOut = new LogOut(Helper.getDriver());
		System.out.println("Good to logout the session");
	}

	@When("user clicks profile icon")
	public void profileIcon(){
		Helper.untilElementToBeClickable(logOut.getViewProfile());
		try {
			Thread.sleep(4000);
			logOut.getViewProfile().click();
		} catch (Exception e) {
			logger.error("Interrepted Exception were occured while clickin the  profile icon");
		}
	}

	@When("user clicks logout hyper link")
	public void logoutLink() {
		try {
			Helper.untilElementToBeClickable(logOut.getLogoutButton());
			logOut.getLogoutButton().click();
			logger.info("Logged Out form salesforce");
		} catch (Exception e) {
			logger.error("Loggout button not working");
		}	
	}

	@Then("salsforce should be logged out successfully")
	public void loggedOut() {
		System.out.println("Logged out to the salesforce successfully");
		Helper.tearDown();
	}


}
