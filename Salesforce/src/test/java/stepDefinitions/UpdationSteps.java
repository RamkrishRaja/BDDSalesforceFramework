package stepDefinitions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.Updations;
import utilities.Helper;

public class UpdationSteps extends BaseClass{

	Logger logger = LogManager.getLogger(UpdationSteps.class);

	@Given("lead should be created and converted")
	public void accountObject() throws Exception{
		updations = new Updations(Helper.getDriver());

	}

	@Then("open newly created Account and update the filed")
	public void accountUpdation() throws Exception {

		Thread.sleep(2000);
		updations.getAccounts();
		updations.getAccountName().click();
		updations.getEditAccountNumberIcon().click();
		Helper.highLights(updations.getAccountNumberBox());
		updations.getAccountNumberBox().sendKeys("AC-001");
		updations.getSaveButton().click();
		logger.info("Window successfully switch to Account Window");

	}

	@Then("Open contact and upload file")
	public void contactUpdation() throws Exception {

		Thread.sleep(2000);
		updations.getContactTab();
		updations.getContactName().click();
		Thread.sleep(2000);
		updations.getContactFileUploads();
		StringSelection stringFileToFormate = new StringSelection("C:\\Users\\Ramak1501278\\Downloads\\Thank+you+PDF.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringFileToFormate,null);
		Thread.sleep(4000);
		Robot copyPaste = new Robot();	
		Thread.sleep(4000);
		copyPaste.keyPress(KeyEvent.VK_CONTROL);
		copyPaste.keyPress(KeyEvent.VK_V);
		copyPaste.keyRelease(KeyEvent.VK_CONTROL);
		copyPaste.keyRelease(KeyEvent.VK_V);
		Thread.sleep(4000);
		copyPaste.keyPress(KeyEvent.VK_ENTER);
		copyPaste.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		updations.getContactPopUpDone().click();

	}

	@Then("Open Opportunity and update the field")
	public void opportunityUpdation() throws Exception {

		Thread.sleep(2000);
		updations.getOpportunityObject();
		updations.getOpportunityName().click();
		updations.getEditOppNameIcon().click();
		Helper.highLights(updations.getOppNameBox());
		updations.getOppNameBox().sendKeys("Opportunity");
		updations.getOppStage();
		updations.getOppStageValue();
		updations.getSaveButton().click();
	}
}

