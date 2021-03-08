package servicePartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import companyContactPersonPartCom.CompanyContactPersonPCAction;
import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesService;
import objectMap.sfPartnersCommunity.PartComService;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ServicePCAction {

	// Operational Actions

	public static void fillProvisioningContactPersonInPC(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson) throws Exception 
	{
		String actionName="fillProvisioningContactPersonInPC";


		try
		{
			WebElement inputEditProvContact = driver.findElement(By.xpath(DirSalesService.inputProvisioningContactPerson));

			inputEditProvContact.sendKeys(provContactPerson);

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.searchResult)));

			driver.findElement(By.xpath(DirSalesService.searchValueToInput)).click();

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

	public static void saveChangesOnServiceDetails(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="saveChangesOnServiceDetails";


		try
		{
			driver.findElement(By.xpath(PartComService.saveDetailsButton)).click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComService.saveServiceSuccessMessage)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void fillBillingAccountID(List<TestLog> logStream, WebDriver driver, int stepID,
			String billingAccountID) throws Exception 
	{
		String actionName="fillBillingAccountID";


		try
		{
			driver.findElement(By.xpath("//input[@name='PRX_SOI_Billing_Account_ID__c']")).clear();

			driver.findElement(By.xpath("//input[@name='PRX_SOI_Billing_Account_ID__c']")).sendKeys(billingAccountID);



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void createNewProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="createNewProvisioningContactPerson";

		try
		{
			driver.findElement(By.xpath(PartComService.buttonNewCompanyContactPerson)).click();

			CompanyContactPersonPCAction.fillNewProvisioningContactPerson(logStream, driver, stepID);

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

	public static boolean serviceScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="serviceScreenValidation";
		try
		{
			if(BrowserActions.isElementPresent(driver, PartComService.filesContainer) &&
					BrowserActions.isElementPresent(driver, PartComService.headerServicesPage) &&
					BrowserActions.isElementPresent(driver, PartComService.detailsServicePage))
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

	public static boolean caseValidationAfterOrderSubmit(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="caseValidationAfterOrderSubmit";

		try
		{

			if(BrowserActions.isElementPresent(driver, PartComService.caseLink))
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

	public static boolean validateBillingAccountID(List<TestLog> logStream, WebDriver driver, int  stepID,
			String billingAccountID) throws Exception 
	{
		String actionName="validateBillingAccountID";
		try
		{
			String valBillingAccountID = driver.findElement(By.xpath("//input[@name='PRX_SOI_Billing_Account_ID__c']")).getAttribute("value");

			if(valBillingAccountID.contains(billingAccountID))
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

	public static boolean validateNewProvisioningContactPersonAfterSaving(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="validateNewProvisioningContactPersonAfterSaving";

		try
		{			
			if(BrowserActions.isElementPresent(driver, "//input[contains(@placeholder,'Tomated')]"))
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

	public static boolean validateProvisioningContactPersonAfterSaving(List<TestLog> logStream, WebDriver driver,
			int stepID, String provContactPerson) throws Exception 
	{
		String actionName="validateNewProvisioningContactPersonAfterSaving";

		try
		{			
			if(BrowserActions.isElementPresent(driver, "//input[contains(@placeholder,'"+provContactPerson+"')]"))
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
