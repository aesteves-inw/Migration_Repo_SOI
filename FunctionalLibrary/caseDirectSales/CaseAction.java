package caseDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesCase;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CaseAction {

	//Operational Actions




	//Validation Actions

	public static boolean caseScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="caseScreenValidation";

		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, DirSalesCase.filesContainer))
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
			
			WebElement itemsKeyDetails = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesCase.itemsKeyDetails)));

			String itemSubCategoryKeyDetailsVal=itemsKeyDetails.getText();
			
					
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
			String product, String productConfiguration) throws Exception 
	{
		String actionName="validateSubCategoryQuotableStandalone";

		try
		{
			String[] extractedConfiguration=ProductConfigurationD02.getD02ConfigurationToApply(product, productConfiguration);

			String contactType=extractedConfiguration[0];

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesCase.itemsKeyDetails)));

			String itemSubCategoryKeyDetailsVal=driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails)).getText();

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
			int stepID, String productName, String productConfiguration) throws Exception
	{
		String actionName="validateSubCategoryQuotableStandalone";

		try
		{
			String[] extractedConfiguration=ProductConfigurationD02.getD02ConfigurationToApply(productName, productConfiguration);

			String contactType=extractedConfiguration[0];

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesCase.itemsKeyDetails)));

			String itemSubCategoryKeyDetailsVal=driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails)).getText();

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

}
