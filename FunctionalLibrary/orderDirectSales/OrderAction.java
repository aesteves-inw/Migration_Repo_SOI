package orderDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesOrder;
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




	// Validation Actions

	public static boolean orderScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="orderScreenValidation";
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderDetails))
			{
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

				BrowserActions.refreshPage(driver);

				orderStatusValidation=driver.findElement(By.xpath(DirSalesOrder.orderDetails)).getText().toString();

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


}
