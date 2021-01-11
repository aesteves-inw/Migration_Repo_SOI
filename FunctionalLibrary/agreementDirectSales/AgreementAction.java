package agreementDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesAgreement;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementAction 
{
	//OPERATIONAL ACTIONS
	public static void generateDocumentProposal(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="generateDocumentProposal";


		try
		{
			driver.findElement(By.xpath(DirSalesAgreement.buttonGenerateProposalDocument)).click();
			
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


	// VALIDATION ACTIONS
	public static boolean agreementScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="agreementScreenValidation";
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesAgreement.headerAgreementPage)&&BrowserActions.isElementPresent(driver, DirSalesAgreement.detailsAgreement))
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

	public static boolean generateDocumentProposalValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="generateDocumentProposalValidation";

		try
		{

			if(BrowserActions.isElementPresent(driver, DirSalesAgreement.generatedDocument))
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

}
