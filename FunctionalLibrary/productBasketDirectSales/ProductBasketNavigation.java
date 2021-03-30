package productBasketDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesProductBasket;
import testExecutionData.TestCasesData;

import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketNavigation 
{

	private static boolean validateProductBasketScreenURL(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Validate Product Basket URL";
		
		String productBasketURL;
		
		boolean validation;

		try
		{
			productBasketURL=driver.getCurrentUrl();
			
			if (productBasketURL.contains("cscfga__Product_Basket__c"))
			{
				validation=true;
			}
			else
			{
				validation=false;
			}
			
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			
			
			return validation;

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void goToAgreement(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		
		String actionName="Product Basket: Go To Agreement (After Sync)";


		try
		{
			WebElement buttonGoToAgreement = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.buttonGoToAgreement)));

			//buttonGoToAgreement.click();
			
			BrowserActions.jsClick(driver, buttonGoToAgreement);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepID);
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void goToDiscountConsoleByID(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Go To Discount Management Console by ID";

		String productBasketID, productBasketURL, discountConsoleURL;
		
		
		try
		{
			productBasketURL = driver.getCurrentUrl();
			
			if(validateProductBasketScreenURL(logStream, driver, stepID))
			{
				productBasketID=TestCasesData.getIDByURL(productBasketURL);
				
				discountConsoleURL=ExcelDataFetch.searchDT(0, "DirectSalesDiscountConsoleByProductBasket")+productBasketID;
				
				BrowserActions.goToByURL(driver, discountConsoleURL);
			}
			else
			{
				ProductBasketAction.goToDiscountManagementConsole(logStream, driver, stepID);
			}
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void goToOrderEnrichmentByID(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Go To Order Enrichment Console by ID";

		String productBasketID, productBasketURL, orderEnrichmentURL;


		try
		{
			productBasketURL = driver.getCurrentUrl();
			
			if(validateProductBasketScreenURL(logStream, driver, stepID))
			{
				productBasketID=TestCasesData.getIDByURL(productBasketURL);
				
				orderEnrichmentURL=ExcelDataFetch.searchDT(0, "DirectSalesOrderEnrichmentByProductBasket")+productBasketID;
				
				BrowserActions.goToByURL(driver, orderEnrichmentURL);
			}
			else
			{
				ProductBasketAction.goToOrderEnrichmentConsole(logStream, driver, stepID);
			}
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	
	}
	

