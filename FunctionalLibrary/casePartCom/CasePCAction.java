package casePartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesCase;
import objectMap.sfPartnersCommunity.PartComCase;
import testExecutionData.ProductConfigurationD02;
import testExecutionData.ProductConfigurationD03;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CasePCAction {


	// Operational Actions



	// Validation Actions
	public static boolean validateCaseScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="validateCaseScreen";

		try
		{
			if(BrowserActions.isElementPresent(driver, PartComCase.headerCase) &&
					BrowserActions.isElementPresent(driver, PartComCase.detailsCase) &&
					BrowserActions.isElementPresent(driver, PartComCase.caseInformation)&&
					BrowserActions.isElementPresent(driver, PartComCase.caseCategorization))
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


	public static boolean validateSubCategoryNonQuotableStandalone(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception
	{
		String actionName="validateSubCategoryNonQuotableStandalone";

		try
		{
			String itemSubCategoryKeyDetailsVal=driver.findElement(By.xpath(PartComCase.detailsCase)).getText();

			if(itemSubCategoryKeyDetailsVal.contains("New"))
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



	public static boolean validateSubCategoryQuotableStandalone(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName, String configurationIndex) throws Exception
	{
		String actionName="validateSubCategoryQuotableStandalone";

		try
		{
			String[] extractedConfiguration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

			String contactType=extractedConfiguration[0];

			String itemSubCategoryKeyDetailsVal=driver.findElement(By.xpath(PartComCase.detailsCase)).getText();

			if(itemSubCategoryKeyDetailsVal.contains(contactType))
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

	public static boolean validateSubCategoryNonQuotableAndQuotable(List<TestLog> logStream, WebDriver driver,
			int stepID, String productName, String configurationIndex) throws Exception 
	{
		String actionName="validateSubCategoryNonQuotableAndQuotable";

		try
		{
			String[] extractedConfiguration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

			String contactType=extractedConfiguration[0];

			String itemSubCategoryKeyDetailsVal=driver.findElement(By.xpath(PartComCase.detailsCase)).getText();

			if(itemSubCategoryKeyDetailsVal.contains(contactType) || itemSubCategoryKeyDetailsVal.equalsIgnoreCase("new"))
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
	
	public static boolean validateOrderToCaseMappingNonQuotable(List<TestLog> logStream, WebDriver driver,
			int stepID, String productName, String contractType) throws Exception
	{
		String actionName="validateOrderToCaseMappingNonQuotable";

		try
		{
			String extractedCategoryMapped=ProductConfigurationD03.getCategoryMappedOfOrderableProduct(productName);
			
			// Validation on Details Tab

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PartComCase.detailsCase)));
			
//			System.out.println(driver.findElement(By.xpath(DirSalesCase.caseMainTableDetailsTab)).isDisplayed());

			String 	itemSubCategoryDetailsTabVal=driver.findElement(By.xpath(PartComCase.detailsCase + "//*[text()='"+contractType+"']")).getText();
			
			String itemDomainDetailsTabVal = driver.findElement(By.xpath(PartComCase.detailsCase + "//*[text()='Fix']")).getText();
			
			String itemTypeDetailsTabVal = driver.findElement(By.xpath(PartComCase.detailsCase + "//*[text()='Order (Fix)']")).getText();
			
			String itemCategoryDetailsTabVal = driver.findElement(By.xpath(PartComCase.detailsCase + "//*[text()='"+extractedCategoryMapped+"']")).getText();
			
			if(// Validation on Details Tab
				(itemSubCategoryDetailsTabVal.contains(contractType) || itemSubCategoryDetailsTabVal.equalsIgnoreCase("new"))&&
				itemDomainDetailsTabVal.equalsIgnoreCase("Fix") && itemTypeDetailsTabVal.equalsIgnoreCase("Order (Fix)") &&
				itemCategoryDetailsTabVal.equalsIgnoreCase(extractedCategoryMapped))
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
