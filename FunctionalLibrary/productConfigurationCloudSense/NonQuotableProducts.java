package productConfigurationCloudSense;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import testExecutionData.ProductConfigurationD03;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class NonQuotableProducts 
{
	static String getNonQuotableProduct(String product)
	{
		return ProductConfigurationD03.getNonQuotableProduct(product);
	}
	
	// OVERALL CONFIGURATION OF PRODUCT
	public static void configurationOfNonQuotableProduct(List<TestLog> logStream, WebDriver driver, int stepID, String productName) throws Exception
	{
		String actionName="configurationOfNonQuotableProduct";
		
		String configurationProductForExecution=getNonQuotableProduct(productName);
		
		try
		{
			productConfiguration(logStream, driver, stepID, configurationProductForExecution);
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	private static void productConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="NQP: Configuration of "+productName;
		
		try
		{
			WebElement selectProductSelection= new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("s2id_Product_Selection:Product_Configuration:PriceItem_0")));
			
			selectProductSelection.click();
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-results-1")));			
			
			WebElement productToPick= driver.findElement(By.xpath("//div[@title='"+productName+"']"));
			
			productToPick.click();
			
			
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	public static boolean validationOfNQPConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String configurationProduct) throws Exception 
	{
		String actionName = "Validation of NonQuotable Product: "+configurationProduct;
		
		int i=0;

		try
		{
			WebElement editProductConfigScreenVal = driver.findElement(By.xpath(DirSalesEditProductConfiguration.editProductScreenContainer));

			String editProductConfigScreenValText=editProductConfigScreenVal.getText().toString();

				if(editProductConfigScreenValText.contains(configurationProduct))
				{
					++i;
				}

			if(i >= 0)
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
