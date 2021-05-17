package servicePartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import companyContactPersonPartCom.CompanyContactPersonPCAction;
import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesOrder;
import objectMap.sfDirectSales.DirSalesService;
import objectMap.sfPartnersCommunity.PartComOrder;
import objectMap.sfPartnersCommunity.PartComService;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

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
			
			
			saveChangesOnServiceDetails(logStream, driver, stepID);
			

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
			WebElement inputBillingAccountID=driver.findElement(By.xpath("//input[@name='PRX_SOI_Billing_Account_ID__c']"));
			
			inputBillingAccountID.click();
			
			inputBillingAccountID.clear();
			
			inputBillingAccountID.sendKeys(billingAccountID);
			
			
			saveChangesOnServiceDetails(logStream, driver, stepID);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	public static void fillNewBillingAccount(List<TestLog> logStream, WebDriver driver, int stepID,
			String billingAccountID) throws Exception 
	{
		String actionName="fillNewBillingAccount";


		try
		{
			WebElement inputNewBillingAccount=driver.findElement(By.xpath("//input[@name='PRX_SOI_NewBillingAccountAddress__c']"));
			
			inputNewBillingAccount.click();
			
			inputNewBillingAccount.clear();
			
			inputNewBillingAccount.sendKeys(billingAccountID);
			
			
			saveChangesOnServiceDetails(logStream, driver, stepID);


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

	public static void fillContractTypeServiceLevel(List<TestLog> logStream, WebDriver driver, int stepID,
			String contractType) throws Exception
	{
		String actionName="fillContractTypeServiceLevel";

		try
		{
			Select selectContractType = new Select(driver.findElement(By.name("contractTypePicklist")));

			selectContractType.selectByValue(contractType);
			
			WebElement buttonSave=driver.findElement(By.xpath(PartComService.saveDetailsButton));
			
			BrowserActions.jsClick(driver, buttonSave);
			
			Thread.sleep(1000);
			
			
			saveChangesOnServiceDetails(logStream, driver, stepID);

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
	
	public static boolean validateNewBillingAccount(List<TestLog> logStream, WebDriver driver, int  stepID,
			String newBillingAccount) throws Exception 
	{
		String actionName="validateNewBillingAccount";
		try
		{
			String valBillingAccountID = driver.findElement(By.xpath("//input[@name='PRX_SOI_NewBillingAccountAddress__c']")).getAttribute("value");

			if(valBillingAccountID.contains(newBillingAccount))
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

	public static void navigateToOrderPC(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productBasketName) throws Exception 
	{
		String actionName="navigateToOrderPC";

		boolean validation = false;

		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Navigate to Order (PC)";

		String stepNameMin="navigateToOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

		try
		{

			WebElement orderLink = driver.findElement(By.xpath("//a[contains(.,'"+productBasketName+"')]"));

			orderLink.click();

			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComOrder.headerOrder)));

			Thread.sleep(1000);
			
			validation = driver.findElement(By.xpath(PartComOrder.headerOrder)).isDisplayed();

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	

	

}
