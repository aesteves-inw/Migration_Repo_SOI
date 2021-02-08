package productsPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import executionTools.BrowserActions;
import objectMap.sfPartnersCommunity.PartComOpportunity;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductsPCAction 
{
	public static boolean productsListViewScreenValidationInPC(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="productsListViewScreenValidationInPC";
		try
		{
			if(BrowserActions.isElementPresent(driver, PartComOpportunity.titleProducts) && BrowserActions.isElementPresent(driver, PartComOpportunity.addProductBtn))
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

	public static boolean productsAddedBySyncProcessInPC(List<TestLog> logStream, WebDriver driver, int stepID, String[] productList) throws Exception
	{
		String actionName="productsAddedBySyncProcessInPC";
		
		int ctr=0;
		
		try
		{
			WebElement productTable=driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']"));
			
			for(int i=0;i<productList.length;i++)
			{
				if(productTable.getText().contains(ProductConfigurationD02.getSalesforceMappedProduct(productList[i])))
				{
					ctr++;
				}
			}
			
			if(ctr >= productList.length)
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


