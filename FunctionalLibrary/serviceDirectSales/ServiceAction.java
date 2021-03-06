package serviceDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import companyContactPersonDirectSales.CompanyContactPersonAction;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import objectMap.sfDirectSales.DirSalesService;
import testFrameworkLibrary.GeneralTestingFramework;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ServiceAction {

	// Operational Actions
	
	public static void navigateToInternetECS(List<TestLog> logStream, WebDriver driver, int stepID,
			String product, String testName) throws Exception 
	{
		String actionName="navigateToInternetECS";


		try
		{
//			driver.findElement(By.xpath("//span[contains(text(),'"+product+"')]")).click();
			BrowserActions.jsClick(driver, driver.findElement(By.xpath("//span[contains(text(),'"+product+"')]")));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	public static void navigateToInternetECS_PC(List<TestLog> logStream, WebDriver driver, int stepID,
			String product, String testName) throws Exception 
	{
		String actionName="navigateToInternetECS_PC";


		try
		{
			driver.findElement(By.xpath("//a[contains(text(),'"+product+"')]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

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
			WebElement buttonSave = driver.findElement(By.xpath(DirSalesService.buttonSave));
			
			BrowserActions.jsClick(driver, buttonSave);

			//new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DirSalesService.buttonSave)));

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

	public static void editProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson) throws Exception 
	{
		String actionName="editProvisioningContactPerson";


		try
		{

			//driver.findElement(By.xpath(DirSalesService.buttonEditProvContact)).click();

			WebElement inputEditProvContact = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputProvisioningContactPerson)));

			inputEditProvContact.sendKeys(provContactPerson);

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.searchResult)));

			driver.findElement(By.xpath(DirSalesService.searchValueToInput)).click();

			Thread.sleep(1000);


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

	public static void fillProvisioningContactPersonSingleAction(List<TestLog> logStream, WebDriver driver, int stepID,
			String provContactPerson) throws Exception 
	{
		String actionName="fillProvisioningContactPersonSingleAction";


		try
		{
			//driver.findElement(By.xpath(DirSalesService.buttonEditProvContact)).click();

			WebElement inputEditProvContact = driver.findElement(By.xpath(DirSalesService.inputProvisioningContactPerson));

			inputEditProvContact.sendKeys(provContactPerson);

			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.searchResult)));

			driver.findElement(By.xpath(DirSalesService.searchValueToInput)).click();

			Thread.sleep(1000);
			
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

	public static void fillBillingAccountIDSingleAction(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="fillBillingAccountIDSingleAction";

		try
		{
			WebElement inputBillingAccountID = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputBillingAccountID)));

			inputBillingAccountID.click();
			
			inputBillingAccountID.clear();
			
			inputBillingAccountID.sendKeys(textExistingBillingAccountIdField);
			

			Thread.sleep(1000);
			
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
	
	public static void fillNewBillingAccountSingleAction(List<TestLog> logStream, WebDriver driver, int stepID,
			String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="fillNewBillingAccountSingleAction";

		try
		{
			WebElement inputNewBillingAccount = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.inputNewBillingAccount)));

			inputNewBillingAccount.click();
			
			inputNewBillingAccount.clear();
			
			inputNewBillingAccount.sendKeys(textExistingBillingAccountIdField);
			

			Thread.sleep(1000);
			
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

	public static void newContactForProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="newContactForProvisioningContactPerson";



		try
		{
			//driver.findElement(By.xpath(DirSalesService.buttonEditProvContact)).click();

			WebElement inputEditProvContact = driver.findElement(By.xpath(DirSalesService.inputProvisioningContactPerson));

			inputEditProvContact.click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.searchResult)));

			driver.findElement(By.xpath(DirSalesService.newCompanyContactPersonLink)).click();

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

	public static void createNewProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="createNewProvisioningContactPerson";


		try
		{
			driver.findElement(By.xpath(DirSalesService.buttonEditProvContact)).click();

			WebElement inputEditProvContact = driver.findElement(By.xpath(DirSalesService.inputProvisioningContactPerson));

			inputEditProvContact.sendKeys(" ");

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesService.searchResult)));

			driver.findElement(By.xpath(DirSalesService.newCompanyContactPersonLink)).click();

			Thread.sleep(1000);

			CompanyContactPersonAction.createNewProvisioningContactPersonFromService(logStream, driver, stepID);

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
			
			WebElement buttonSave=driver.findElement(By.xpath(DirSalesService.buttonSave));
			
			BrowserActions.jsClick(driver, buttonSave);
			
			Thread.sleep(1000);
			
			
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


	// Validation Actions
	public static boolean validateServiceScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateServiceScreen";

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesService.headerServicesPage) && 
					BrowserActions.isElementPresent(driver, DirSalesService.secundaryHeaderFields))
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
		
		String elementToValidate="//input[@placeholder='"+provContactPerson+"']";

		try
		{

			if(BrowserActions.isElementPresent(driver, elementToValidate))
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
			String fieldBillingAccountIDValidation=driver.findElement(By.xpath(DirSalesService.fieldBillingAccountID)).getAttribute("value");

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
	
	public static boolean validateBillingAccountIDAfterSavingNegative(List<TestLog> logStream, WebDriver driver,
			int stepID, String textExistingBillingAccountIdField) throws Exception 
	{
		String actionName="validateBillingAccountIDAfterSaving";

		try
		{
			WebElement billingIDNewBillingError=driver.findElement(By.xpath("//*[@id=\"one\"]/div/form/lightning-messages/div/div"));			


			if(billingIDNewBillingError.isDisplayed())
			{
				driver.findElement(By.xpath(DirSalesService.fieldNewBillingAccount)).clear();
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
	
	public static boolean validateNewBillingAccountAfterSaving(List<TestLog> logStream, WebDriver driver,
			int stepID, String textExistingNewBillingAccountField) throws Exception 
	{
		String actionName="validateNewBillingAccountAfterSaving";
		
		try
		{
			
			String fieldNewBillingAccountValidation=driver.findElement(By.xpath(DirSalesService.fieldNewBillingAccount)).getAttribute("value");
			
			System.out.println(fieldNewBillingAccountValidation);

			if(fieldNewBillingAccountValidation.contains(textExistingNewBillingAccountField))
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

	public static boolean validateNewProvisioningContactPersonAfterSaving(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="validateNewProvisioningContactPersonAfterSaving";

		try
		{

			String fieldProvisioningContactPersonValidation=driver.findElement(By.xpath(DirSalesService.fieldProvisioningContactPerson)).getText().toString();

			//System.out.println("debug of fieldProvisioningContactPersonValidation: "+fieldProvisioningContactPersonValidation);

			if(fieldProvisioningContactPersonValidation.contains("Tomated"))
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

	public static boolean valContractType(List<TestLog> logStream, WebDriver driver, int stepID,
			String contractType) throws Exception
	{
		String actionName="valContractType";
		
		try
		{
			WebElement weSelectContractType=driver.findElement(By.name("contractTypePicklist"));
						
			String valueToValidate=weSelectContractType.getAttribute("value");
			
			//System.out.println("Debug of valueToValidate: "+valueToValidate);
			
			if(valueToValidate.contains(contractType))
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
	
	public static boolean valServiceInternetECS(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="valServiceInternetECS";
		
		try
		{
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@data-row-key-value='ECS Pack Contract Type']//th[1]")));
			
			if(driver.findElement(By.xpath("//tr[@data-row-key-value='ECS Pack Contract Type']//th[1]")).isDisplayed() || driver.findElement(By.xpath("//tr[@data-row-key-value='ECS Pack Contract Type']//td[1]")).isDisplayed())
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
	
	public static boolean valServiceInternetECS_PC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="valServiceInternetECS_PC";
		
		try
		{
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr[@data-row-key-value='ECS Pack Contract Type']//span)[1]")));
			
			if(driver.findElement(By.xpath("(//tr[@data-row-key-value='ECS Pack Contract Type']//span)[1]")).isDisplayed() || driver.findElement(By.xpath("(//tr[@data-row-key-value='ECS Pack Contract Type']//span)21]")).isDisplayed())
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

	public static boolean validateServiceRequestDateFromProductConfig(List<TestLog> logStream, WebDriver driver, int stepID,
			String validSRDServiceFormat, String requestInstallDateFormat) throws Exception
		{
			String actionName="validateServiceRequestDateFromProductConfig";
			
			try
			{
				
				String fieldServiceRequestDate=driver.findElement(By.xpath(DirSalesService.fieldfilledServiceRequestDate)).getAttribute("value").trim();
				
				System.out.println("Debug of fieldServiceRequestDate: "+fieldServiceRequestDate);
				
				String fieldRequestInstallationDate =driver.findElement(By.xpath(DirSalesService.fieldRequestInstallationDateValue)).getText().trim();
				
				System.out.println("Debug of fieldRequestInstallationDate: "+ fieldRequestInstallationDate);

				System.out.println("fieldServiceRequestDate.contains(validSRDServiceFormat): " + validSRDServiceFormat + "Boolean: " + fieldServiceRequestDate.contains(validSRDServiceFormat));
				
				System.out.println("fieldRequestInstallationDate.contains(requestInstallDateFormat): " + requestInstallDateFormat + "Boolean: " + fieldRequestInstallationDate.contains(requestInstallDateFormat));

				
				
				if(fieldServiceRequestDate.contains(validSRDServiceFormat)==true && fieldRequestInstallationDate.contains(requestInstallDateFormat) == true)
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

	public static boolean validateServiceRequestDateFromProductBasket(List<TestLog> logStream, WebDriver driver, int stepID,
		String validSRDServiceFormat) throws Exception
	{
		String actionName="validateServiceRequestDateFromProductBasket";
		
		try
		{
			
			String fieldServiceRequestDate=driver.findElement(By.xpath(DirSalesService.fieldfilledServiceRequestDate)).getAttribute("value");
			
			System.out.println("Debug of fieldServiceRequestDate value: "+fieldServiceRequestDate);
			
			Boolean validation = BrowserActions.isElementPresent(driver, DirSalesService.fieldRequestInstallationDateValue);
			
			System.out.println("Debug of fieldRequestInstallationDate presence: "+ validation);
	
			if(fieldServiceRequestDate.contains(validSRDServiceFormat) && validation==false)
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

	public static void fillServiceRequestDateAction(List<TestLog> logStream, WebDriver driver, int stepID,
			String SRD) throws Exception 
	{
		String actionName="fillServiceRequestDateAction";
	
		try
		{
			
			BrowserActions.setValueInputField(driver, By.xpath(DirSalesService.fieldfilledServiceRequestDate), SRD);
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
	
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static boolean validateServiceRequestDateAfterSaving(List<TestLog> logStream, WebDriver driver,
			int stepID, String SRD) throws Exception 
	{
		String actionName="validateBillingAccountIDAfterSaving";
	
		try
		{

			Thread.sleep(1000);
			
			saveServiceChanges(logStream, driver, stepID);
			
			Thread.sleep(1000);

			String fieldServiceRequestDate=driver.findElement(By.xpath(DirSalesService.fieldfilledServiceRequestDate)).getAttribute("value");
			
			System.out.println("Debug of fieldServiceRequestDate: "+fieldServiceRequestDate);
	
			if(fieldServiceRequestDate.contains(SRD))
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

	public static boolean validateServiceRequestDateAfterSavingNegative(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="validateServiceRequestDateAfterSavingNegative";
	
		try
		{
			Thread.sleep(1000);
			
			saveServiceChanges(logStream, driver, stepID);
	
			WebElement serviceRequestDateError=driver.findElement(By.xpath("//*[contains(text(),'Service Request Date')]/parent::div/following-sibling::div[contains(@id,'error-message')]"));			
	

			if(serviceRequestDateError.isDisplayed())
			{
				driver.findElement(By.xpath(DirSalesService.fieldfilledServiceRequestDate)).clear();
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


	public static boolean serviceRequestDateNegativeValidation(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="serviceRequestDateNegativeValidation";
	
		try
		{

			Boolean fieldServiceRequestDate =driver.findElement(By.xpath(DirSalesService.fieldfilledServiceRequestDate)).getAttribute("value").isEmpty();
			
			System.out.println("Debug of fieldServiceRequestDate.isEmpty: "+ fieldServiceRequestDate);
						
			Boolean fieldRequestInstallationDate = BrowserActions.isElementPresent(driver, "xpath", DirSalesService.fieldRequestInstallationDateValue);

			
			System.out.println("Debug of fieldRequestInstallationDate presence: "+ fieldRequestInstallationDate);

			
			if(fieldServiceRequestDate==true && fieldRequestInstallationDate == false)
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
