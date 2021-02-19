package agreementPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesAgreement;
import objectMap.sfPartnersCommunity.PartComAgreements;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementPCAction {

	// Operational Actions
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

	public static void generateDocumentOnly(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="generateDocument";


		try
		{
			driver.findElement(By.xpath(PartComAgreements.buttonGenerateProposalDocument)).click();

			for(int i=0;i<20;i++)
			{
				Thread.sleep(1000);
			}

			//BrowserActions.refreshPage(driver);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	public static void addFileToAgreement(List<TestLog> logStream, WebDriver driver, int stepID, String filePath) throws Exception 
	{
		String actionName="addFileToAgreement";


		try
		{
			driver.findElement(By.xpath(PartComAgreements.inputUploadFiles)).sendKeys(filePath);
			
			Thread.sleep(5000);
			
			WebElement buttonDone =driver.findElement(By.xpath(PartComAgreements.buttonDone));
			
			Thread.sleep(1000);
			
			BrowserActions.jsClick(driver, buttonDone);
			
			Thread.sleep(1000);
			

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

	public static boolean addFileToAgreementValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String fileName) throws Exception 
	{
        String actionName="addFileToAgreementValidation";
        
        
	     	try
					{
						if(BrowserActions.isElementPresent(driver, "//a[contains(.,'"+fileName+"')]"))
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
