package agreementPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfPartnersCommunity.PartComAgreements;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementPCAction {

	// Operational Actions
	public static boolean agreementScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="agreementScreenValidation";
		try
		{
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComAgreements.agreementsDetails)));

			if(BrowserActions.isElementPresent(driver, PartComAgreements.agreementsDetails) && BrowserActions.isElementPresent(driver, PartComAgreements.agreementsDetails))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

	public static void generateDocument(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="generateDocument";


		try
		{
			driver.findElement(By.xpath(PartComAgreements.buttonGenerateProposalDocument)).click();

			for(int i=0;i<30;i++)
			{
				Thread.sleep(1000);
			}

			BrowserActions.refreshPage(driver);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}


	
	// Validation Actions
	

}
