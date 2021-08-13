package orderDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesAgreement;
import objectMap.sfDirectSales.DirSalesCase;
import objectMap.sfDirectSales.DirSalesOrder;
import objectMap.sfPartnersCommunity.PartComOrder;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderAction 
{
	// Operational Actions

	public static void submitOrder(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="submitOrder";


		try
		{
			driver.findElement(By.xpath(DirSalesOrder.submitOrderButton)).click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesOrder.submitOrderButton)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	public static void submitOrderPC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="submitOrder";


		try
		{
			driver.findElement(By.xpath(PartComOrder.submitOrderBtn)).click();

			new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(PartComOrder.submitOrderBtn)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}


	public static void addFileToOrder(List<TestLog> logStream, WebDriver driver, int stepID, String filePath) throws Exception 
	{
		String actionName="addFileToOrder";

		try
		{
			WebElement inputFile = driver.findElement(By.xpath("//input[contains(@class,'slds-file-selector__input slds-assistive-text')]"));

			inputFile.sendKeys(filePath);

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

	// Validation Actions

	public static boolean orderScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="orderScreenValidation";
		try
		{
			new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DirSalesOrder.orderDetails)));

			if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderDetails))
			{
				//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOrder.orderDetails)));
				
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOrder.orderDetails)));

				//new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Services']")));

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

	public static boolean submitOrderPositiveValidationValidation(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="submitOrderPositiveValidationValidation";

		String orderStatusValidation;

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderSubmittedSuccess))
			{							
				Thread.sleep(3000);
				
				orderStatusValidation=driver.findElement(By.xpath(DirSalesOrder.orderStatusLabel)).getText().toString();

				if(orderStatusValidation.equalsIgnoreCase("submitted")==false) {
					
					BrowserActions.refreshPageUntilElementPresent(driver, DirSalesOrder.orderStatusLabel);
					
					orderStatusValidation=driver.findElement(By.xpath(DirSalesOrder.orderStatusLabel)).getText().toString();
					
				}
//				System.out.println("Debug of submitOrderPositiveValidationValidation: "+orderStatusValidation);
//				System.out.println(orderStatusValidation.equalsIgnoreCase("submitted"));
//				System.out.println(orderStatusValidation.contains("Submitted"));

				
				if(orderStatusValidation.equalsIgnoreCase("submitted"))
				{
					TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
					return true;
				}
				else
				{
					return false;
				}

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

	public static boolean submitOrderNegativeValBillingAddress(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="submitOrderNegativeValBillingAddress";

		try
		{			
			if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderSubmitionErrorBillingAccount))
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

	public static boolean submitOrderNegativeValProvisioningContact(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="submitOrderNegativeValProvisioningContact";

		try
		{			
			if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderSubmitionErrorProvisioningContact))
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


	public static boolean validateContractTypeColumn(List<TestLog> logStream, WebDriver driver, int stepID, String contractType) throws Exception 
	{
		String actionName="validateContractTypeColumn";

		try
		{
			
			String contractTypeColumnToValidate="//th[text()='Contract Type']";
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contractTypeColumnToValidate)));
			
			String contractTypeElementToValidate="//td[text()='"+contractType+"']";
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contractTypeElementToValidate)));

			if(BrowserActions.isElementPresent(driver, contractTypeElementToValidate) || BrowserActions.isElementPresent(driver, contractTypeColumnToValidate))
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
	
	public static boolean validateContractTypeColumnPC(List<TestLog> logStream, WebDriver driver, int stepID, String contractType) throws Exception 
	{
		String actionName="validateContractTypeColumn";

		try
		{
			
			String contractTypeColumnToValidate="//th[text()='Contract Type']";
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contractTypeColumnToValidate)));
			
			String contractTypeElementToValidate="//td[text()='"+contractType+"']";
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(contractTypeElementToValidate)));

			if(BrowserActions.isElementPresent(driver, contractTypeElementToValidate) || BrowserActions.isElementPresent(driver, contractTypeColumnToValidate))
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
	
	public static boolean validateFilesInOrderScreen(List<TestLog> logStream, WebDriver driver, int stepID, String fileName) throws Exception 
	{
		String actionName="validateFilesInOrderScreen";

		try
		{
			String fileElementToValidate="//a[@title='"+fileName+"']";

			if(BrowserActions.isElementPresent(driver, fileElementToValidate))
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


	public static boolean submitOrderNegativeValContractType(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="submitOrderNegativeValContractType";

		try
		{
			if(BrowserActions.isElementPresent(driver, "//*[starts-with(.,'Missing Contract Type on Service(s):')]"))
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
	
	public static boolean submitOrderNegativeVal(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="submitOrderNegativeVal";

		try
		{
			//if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderSubmitErrorGeneral))
				if(driver.findElement(By.xpath(DirSalesOrder.orderSubmitErrorGeneral)).isDisplayed())
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
	
	public static boolean submitOrderNegativeValPC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="submitOrderNegativeVal";

		try
		{
			//if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderSubmitErrorGeneral))
				if(driver.findElement(By.xpath(DirSalesOrder.orderSubmitErrorGeneral)).isDisplayed())
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
