package productsDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesProducts;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductsAction {

	// Operational Actions



	//Validation Actions
	public static boolean validationOfProductsRelatedMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validationOfProductsRelatedMenu";
		try
		{

			if(BrowserActions.isElementPresent(driver, DirSalesProducts.buttonAddProducts) && BrowserActions.isElementPresent(driver, DirSalesProducts.buttonShowQuickFilters) && BrowserActions.isElementPresent(driver, DirSalesProducts.buttonRefresh))
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

	public static boolean validateProductsinOPTY(List<TestLog> logStream, WebDriver driver, int stepID, String productName) throws Exception 
	{
		String actionName="validateProductsinOPTY";

		int validationCounter=0;

		try
		{
			String productToBeValidated=ProductConfigurationD02.getSalesforceMappedProduct(productName);

			WebElement table = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));

			if(table.getText().toString().contains(productToBeValidated) || BrowserActions.isClickable(driver, table.findElement(By.xpath(DirSalesProducts.flagQuoteSynced))))
			{
				validationCounter++;
			}

			if(validationCounter>0)

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

	public static boolean validateMultipleProductsInOPTY(List<TestLog> logStream, WebDriver driver, int stepID, String[] productNames) throws Exception
	{
		String actionName="validateMultipleProductsInOPTY";
		
		int validationCounter=0;
		
		String productMapped;

		try
		{
			WebElement table = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
			
			List<WebElement> quoteSyncedFlags = driver.findElements(By.xpath(DirSalesProducts.flagQuoteSynced));
			
			for(String s:productNames)
			{
				productMapped = ProductConfigurationD02.getSalesforceMappedProduct(s);
				
				if(table.getText().toString().contains(productMapped))
				{
					validationCounter++;
				}
			}
			
			validationCounter=validationCounter+quoteSyncedFlags.size();
			
			
			if(validationCounter> productNames.length)
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
