package serviceDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import objectMap.sfDirectSales.DirSalesService;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ServiceAction {

	// Operational Actions

	public static void fillDetailsSection(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson, String textExistingBillingAccountIdField, String testName) throws Exception 
	{
		String actionName="fillDetailsSection";


		try
		{
			editProvisioningContactPerson(logStream, driver, stepID, provContactPerson);

			editInternalComments(logStream, driver, stepID, testName);

			editBillingAccountID(logStream, driver, stepID, textExistingBillingAccountIdField);

			saveServiceChanges(logStream, driver, stepID);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void saveServiceChanges(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="saveServiceChanges";


		try
		{
			driver.findElement(By.xpath(DirSalesService.buttonSave)).click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DirSalesService.buttonSave)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void editBillingAccountID(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="editBillingAccountID";


		try
		{
			//driver.findElement(By.xpath(DirSalesService.buttonEditBillingAccountID)).click();

			WebElement inputBillingAccountID = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputBillingAccountID)));

			inputBillingAccountID.sendKeys(textExistingBillingAccountIdField);

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

	public static void editInternalComments(List<TestLog> logStream, WebDriver driver, int stepID,
			String testName) throws Exception 
	{
		String actionName="editInternalComments";

		String executionString = ExecStructure.getTestExecutionString(testName);

		try
		{			
			//driver.findElement(By.xpath(DirSalesService.buttonEditInternalComments)).click();

			WebElement inputInternalComments = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputInternalComments)));

			inputInternalComments.sendKeys(executionString);

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

	public static void editProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson) throws Exception 
	{
		String actionName="editProvisioningContactPerson";


		try
		{

			driver.findElement(By.xpath(DirSalesService.buttonEditProvContact)).click();

			WebElement inputEditProvContact = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputProvisioningContactPerson)));

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

	public static void fillProvisioningContactPersonSingleAction(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson) throws Exception 
	{
		String actionName="fillProvisioningContactPersonSingleAction";


		try
		{
			driver.findElement(By.xpath(DirSalesService.buttonEditProvContact)).click();

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

	public static void fillBillingAccountIDSingleAction(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="fillBillingAccountIDSingleAction";

		try
		{
			WebElement inputBillingAccountID = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputBillingAccountID)));

			inputBillingAccountID.sendKeys(textExistingBillingAccountIdField);

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
	public static boolean validateServiceScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateServiceScreen";

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesService.headerServicesPage) && 
					BrowserActions.isElementPresent(driver, DirSalesService.buttonDetails) && 
					BrowserActions.isElementPresent(driver, DirSalesService.buttonEditProvContact) && 
					BrowserActions.isElementPresent(driver, DirSalesService.buttonEditInternalComments) && 
					BrowserActions.isElementPresent(driver, DirSalesService.buttonEditBillingAccountID))
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

	public static boolean serviceDetailsScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson, String textExistingBillingAccountIdField, String testName) throws Exception 
	{
		String actionName="serviceDetailsScreenValidation";

		try
		{

			String fieldProvisioningContactPersonValidation=driver.findElement(By.xpath(DirSalesService.fieldProvisioningContactPerson)).getText().toString();

			String fieldInternalCommentsValidation=driver.findElement(By.xpath(DirSalesService.fieldInternalComments)).getText().toString();

			String fieldBillingAccountIDValidation=driver.findElement(By.xpath(DirSalesService.fieldBillingAccountID)).getText().toString();


			if(fieldProvisioningContactPersonValidation.contains(provContactPerson) && fieldInternalCommentsValidation.contains(ExecStructure.getTestExecutionString(testName)) && fieldBillingAccountIDValidation.contains(textExistingBillingAccountIdField))
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
		String actionName="validateProvisioningContactPersonAfterSaving";

		try
		{

			String fieldProvisioningContactPersonValidation=driver.findElement(By.xpath(DirSalesService.fieldProvisioningContactPerson)).getText().toString();

			System.out.println("debug of fieldProvisioningContactPersonValidation: "+fieldProvisioningContactPersonValidation);

			if(fieldProvisioningContactPersonValidation.contains(provContactPerson))
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

	public static boolean validateBillingAccountIDAfterSaving(List<TestLog> logStream, WebDriver driver,
			int stepID, String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="validateBillingAccountIDAfterSaving";

		try
		{
			String fieldBillingAccountIDValidation=driver.findElement(By.xpath(DirSalesService.fieldBillingAccountID)).getText().toString();			


			if(fieldBillingAccountIDValidation.contains(textExistingBillingAccountIdField))
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

	public static boolean caseLinkOnServicePageValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="caseLinkOnServicePageValidation";
		
		try
		{
			WebElement caseFieldOnServiceScreen = driver.findElement(By.xpath("//*[contains(@id, 'brandBand')]/div/div/div[5]/div/one-record-home-flexipage2/forcegenerated-adgrollup_component___forcegenerated__flexipage_recordpage___d02_service_layout___csord__service__c___view/forcegenerated-flexipage_d02_service_layout_csord__service__c__view_js/record_flexipage-record-page-decorator/div[1]/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_csord__service__c___0123m0000000fbfqae___compact___view___recordlayout2/force-highlights2/div[1]/div[2]/slot/slot/force-highlights-details-item[3]/div/p[2]/slot/force-lookup/div/force-hoverable-link/div/a"));
			
			if(caseFieldOnServiceScreen != null)
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
