package opportunityDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesOpportunity;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OpportunityAction {
	
	//Operational Actions
	public static void createProductBasket(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
        String actionName="createProductBasket";


				try
				{
					goToProductBasketRelatedMenu(logStream, driver, stepID);
					
					clickNewProductBasketLink(logStream, driver, stepID);

					TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

				}
				catch(Exception e)
				{
					System.out.println(e);
					TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}
	}
	
	private static void clickNewProductBasketLink(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="clickNewProductBasketLink";


		try
		{
			driver.findElement(By.linkText("New Product Basket")).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void goToProductBasketRelatedMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToProductBasketRelatedMenu";


		try
		{
			String optyRecordID=BrowserActions.getRecordIDByURL(driver);
			
			String productBasketRelatedMenuURL="https://proximus--prxitt.lightning.force.com/lightning/r/cscfga__Product_Basket__c/"+optyRecordID+"/related/cscfga__Product_Baskets__r/view";
			
			BrowserActions.goToByURL(driver, productBasketRelatedMenuURL);
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}	
	}


	//Validation Actions
	public static boolean opportunityScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Opportunity: Opportunity Page validation";
		
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, DirSalesOpportunity.optyDetails))
			{
				new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOpportunity.optyDetails)));
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
