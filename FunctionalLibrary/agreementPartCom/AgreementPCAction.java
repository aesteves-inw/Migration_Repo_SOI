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
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComAgreements.buttonGenerateProposalDocument)));

			
			driver.findElement(By.xpath(PartComAgreements.buttonGenerateProposalDocument)).click();

			for(int i=0;i<50;i++)
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

	public static void changeLanguageOnDetailsForAgreementDocument(List<TestLog> logStream, WebDriver driver,
			int stepID, String language) throws Exception {
		String actionName = "changeLanguageOnDetailsForAgreementDocument";
	
		try {
			
			WebElement langDetails = new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(.,'Language')]/parent::div/following-sibling::div/span/span")));

			System.out.println("changeLanguageOnDetailsForAgreementDocument - Current language selecetd on details: " + langDetails.getText());
			
			if(langDetails.getText().contains(language)==false) {
				
				BrowserActions.jsClick(driver, By.xpath("//button[@title='Edit Language']"));				
				new WebDriverWait(driver, 15).until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[contains(.,'Language')]/parent::span/following-sibling::div//a"))).click();
				
				new WebDriverWait(driver, 15).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//li/a[@title='"+language+"']"))).click();;
				
				Thread.sleep(2000);
				
				BrowserActions.jsClick(driver, By.xpath(PartComAgreements.saveButton));
				
			}
	
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step " + stepID);
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	
	}

	public static boolean validationOfLanguageOnDetailsForAgreementDocument(List<TestLog> logStream, WebDriver driver,
			int stepID, String language) throws Exception {
		String actionName = "validationOfLanguageOnDetailsForAgreementDocument";
	
		try {
	
			WebElement langDetails = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(.,'Language')]/parent::div/following-sibling::div/span/span")));

			System.out.println("validationOfLanguageOnDetailsForAgreementDocument - Language validation: " + langDetails.getText());
	
			
			if (langDetails.getText().contains(language)== true) {
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: " + stepID);
				return true;
			} else {
				return false;
			}
	
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step " + stepID, e.toString());
			throw new Exception(actionName + " - Failed in Step " + stepID, e);
		}
	
	}

}
