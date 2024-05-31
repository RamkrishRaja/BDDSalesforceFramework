package testPackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.Updations;
import stepDefinitions.BaseClass;
import stepDefinitions.UpdationSteps;
import utilities.Helper;

public class Sample extends BaseClass {
	
	static Logger logger = LogManager.getLogger(UpdationSteps.class);

	static String parentWindow;
	static List<String> windID;
	
	
	
	static Updations updations;
	
	public static void main(String[] args) throws Exception {
		updations = new Updations(Helper.getDriver());
		parentWindow = Helper.getDriver().getWindowHandle();
		Set<String> allOpenWindows = Helper.getDriver().getWindowHandles();	
		//		windID = new ArrayList<String>();
		//		windID.addAll(allOpenWindows);
		//		System.out.println(windID.get(0));
		//		System.out.println(windID.get(1));
		//		System.out.println(windID.get(2));
		//		System.out.println(windID.get(3));
		Iterator<String> itr= allOpenWindows.iterator();
		while(itr.hasNext()){
			String childWindow=itr.next();		
			if(!parentWindow.equals(childWindow)){
				Helper.getDriver().switchTo().window(childWindow);
				String currentUrl = Helper.getDriver().getCurrentUrl();
				Thread.sleep(5000);
				if (currentUrl.contains("lightning/r/Opportunity")) {
					Thread.sleep(4000);
					System.out.println("Opportunity url --> "+Helper.getDriver().getCurrentUrl());
					updations.getEditOppNameIcon().click();
					Helper.highLights(updations.getOppNameBox());
					updations.getOppNameBox().sendKeys("Opportunity");
					updations.getOppStage();
					Thread.sleep(4000);
					updations.getOppStageValue();
					updations.getSaveButton().click(); 
					System.out.println("awefgaerger");
				}else if(currentUrl.contains("lightning/r/Account")) {
					Thread.sleep(4000);
					System.out.println("Account url --> "+Helper.getDriver().getCurrentUrl());
					updations.getEditAccountNumberIcon().click();
					Helper.highLights(updations.getAccountNumberBox());
					updations.getAccountNumberBox().sendKeys("AC-001");
					updations.getSaveButton().click();
					logger.info("Window successfully switch to Account Window");
				}else if (currentUrl.contains("lightning/r/Contact")) {
					System.out.println("Contact url --> "+Helper.getDriver().getCurrentUrl());
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
				}else {
					System.out.println("No in desier window........!");
				}
				Thread.sleep(4000);
				Helper.getDriver().close();
			}
		}
		Helper.getDriver().switchTo().window(parentWindow);
	}

	}
