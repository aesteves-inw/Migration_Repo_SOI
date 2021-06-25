package agreementDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesAgreement;
import testDataFiles.TestDataFiles;
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
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesAgreement.buttonGenerateProposalDocument)));

			driver.findElement(By.xpath(DirSalesAgreement.buttonGenerateProposalDocument)).click();
			
			for(int i=0;i<50;i++)
			{
					Thread.sleep(1000);
			}
			
			System.out.println("Debug of generateDocumentProposal - Passes Here");
			
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
	
	public static void generateDocumentProposalOnly(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="generateDocumentProposal";


		try
		{
			driver.findElement(By.xpath(DirSalesAgreement.buttonGenerateProposalDocument)).click();
			
			for(int i=0;i<30;i++)
			{
					Thread.sleep(1000);
			}
			
			System.out.println("Debug of generateDocumentProposal - Passes Here");
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	//Add File To Agreement
	public static void addFileToAgreement(List<TestLog> logStream, WebDriver driver, int stepID, String fileName) throws Exception 
	{
		String actionName="addFileToAgreement";


		try
		{
			WebElement inputFile = driver.findElement(By.xpath("//input[contains(@class,'slds-file-selector__input slds-assistive-text')]"));
			
			inputFile.sendKeys(fileName);
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesAgreement.titleUploadFiles)));
			
			Thread.sleep(3000);
			
			WebElement doneButton = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesAgreement.buttonDoneUploadFiles)));
			
			BrowserActions.jsClick(driver, doneButton);
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DirSalesAgreement.buttonDoneUploadFiles)));
			


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
			//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesAgreement.detailsAgreement)));
			
			//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(DirSalesAgreement.detailsAgreement)));
			
			//if(BrowserActions.isElementPresent(driver, DirSalesAgreement.headerAgreementPage)&&BrowserActions.isElementPresent(driver, DirSalesAgreement.detailsAgreement))
				if(BrowserActions.isElementPresent(driver, DirSalesAgreement.headerAgreementPage))
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
			BrowserActions.refreshPageUntilElementPresent(driver, DirSalesAgreement.generatedDocument);

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

	public static boolean validationOfFileAddedToAgreement(List<TestLog> logStream, WebDriver driver, int stepID,
			String fileName) throws Exception 
	{
		String actionName="validationOfFileAddedToAgreement";
		
		String finalFileName=TestDataFiles.fileFinalNameD01;
     	try
				{
     		
     				List<WebElement> filesInAgreement=driver.findElements(By.xpath("//*[@title='"+finalFileName+"']"));
     				    				
					if(filesInAgreement.size()>0)
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

	public static boolean validationOfFilesRelatedListView(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validationOfFilesRelatedListView";
     	try
				{
					if(BrowserActions.isElementPresent(driver, DirSalesAgreement.addFilesButton) && BrowserActions.isElementPresent(driver, DirSalesAgreement.filesTitle))
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
