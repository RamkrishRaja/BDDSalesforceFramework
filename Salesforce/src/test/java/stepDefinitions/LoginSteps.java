package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogIn;
import utilities.Helper;

public class LoginSteps extends BaseClass{
	
	Logger logger = LogManager.getLogger(LoginSteps.class);
	
	@Given("Chrome or any desier brower should be launched")
	public void launcheBrowser() {

		loginPage = new LogIn(Helper.getDriver());

		String browserName = Helper.getBrowserName();
		String browserVersion = Helper.getBrowserVersion();
		String platform = Helper.getPlatform();
		System.out.println("BDD Cucumber test automation running in: "+platform+" platform."+
				"Current browser name:"+browserName+" and its version - "+browserVersion);
	}

	@When("Salesforce login page opend {string}")
	public void openSalesfore(String url) {
		try{
		Helper.openPage(url);
		logger.info("Salesforce URL launched" + url);
		}catch(Exception e){
			System.out.println(e.getMessage());
			logger.error("Invalid URL or URL not launched");
		}
		
	}

	@Then("User should see the text box to enter login credentials {string}")
	public void loginTitle(String string) {
		try{
			String loginPgTitle = Helper.getTitle();
			Assert.assertEquals(string, loginPgTitle);
			System.out.println("Login page title verified successfully: "+loginPgTitle);
		}catch(Exception e){
			System.out.println(e.getMessage());
			logger.error("Page Not Found");
		}
	}

	@When("enter Username as {string} and Password as {string}")
	public void loginCerdentials(String userName, String password) {
		if(userName.equalsIgnoreCase("Valid") && password.equalsIgnoreCase("Valid"))
		{
			userName= Helper.GetUserName();
			password= Helper.GetPassword();
		}
		loginPage.setUsername(userName);
		loginPage.setPassword(password); 

		System.out.println("Username: "+ userName);
		System.out.println("Password: "+ password);
	}

	@Then("clicks on Login button with expected status as {string}")
	public void clickLoginButton(String expectedStatus) {
		
		loginPage.setLoginButton();

		if (expectedStatus == "Missing Password")
		{		
			String passwordErrorMessage = loginPage.getMissingPasswordERMSG();

			Assert.assertEquals("Please enter your password.", passwordErrorMessage);
			System.out.println("Error message on missing login cerdentials: "+loginPage.getMissingPasswordERMSG());
			return;
		}
		else if (expectedStatus == "Both Fail")
		{
			String commonMSG =loginPage.getIncorrectUsernameorPasswordERMSG();
			Assert.assertEquals("Please check your username and password. If you still can't log in, contact your Salesforce administrator.",commonMSG);
			System.out.println("Error message on incorrect cerdentials: "+commonMSG);
			return;
		}
	}

	@Then("User should see the Salesforce Home page on successful login status {string}")
	public void homePageTitle(String status) { 

		if (status.equalsIgnoreCase("Pass"))
		{
			String actualMessage = loginPage.getHomePageTitle();
			Assert.assertEquals(loginPage.getHomePageTitle(), actualMessage);
			System.out.println("Home page title verified successfully: "+actualMessage);
			String actualMessageIntext = "Home | Salesforce";
			Assert.assertEquals(Helper.getTitle(), actualMessageIntext);
			System.out.println("Home page title verified successfully: "+actualMessageIntext+"@22###2222");
		} 	  
	}
}