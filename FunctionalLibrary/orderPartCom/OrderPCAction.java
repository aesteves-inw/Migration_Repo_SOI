package orderPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfPartnersCommunity.PartComOrder;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderPCAction {

	// Operational Actions

	public static void submitOrder(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
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


	// Validation Actions

	public static boolean validateOrderScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateOrderScreen";
		try
		{
			if(
					BrowserActions.isElementPresent(driver, PartComOrder.filesContainer) &&
					BrowserActions.isElementPresent(driver, PartComOrder.servicesContainer) &&
					BrowserActions.isElementPresent(driver, PartComOrder.orderDetailsFrame)
					)
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


	public static boolean orderSubmissionPositiveValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="orderSubmissionPositiveValidation";

		String orderStatusValidation;

		try
		{
			if(BrowserActions.isElementPresent(driver, PartComOrder.successMessage))
			{							
				Thread.sleep(3000);

				BrowserActions.refreshPage(driver);

				orderStatusValidation=driver.findElement(By.xpath(PartComOrder.orderStatusLabel)).getText().toString();

				System.out.println("Debug of submitOrderPositiveValidationValidation: "+orderStatusValidation);

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


	public static boolean orderSubmissionNegativeValBillingAddress(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="orderSubmissionNegativeValBillingAddress";
		try
		{
			if(BrowserActions.isElementPresent(driver, PartComOrder.submitOrderBillingAccountErrorMessage))
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
