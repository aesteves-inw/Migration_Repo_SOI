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
import testExecutionData.ProductConfigurationD03;
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

	
	public static boolean validateOrderToCaseMappingNonQuotable(List<TestLog> logStream, WebDriver driver,
			int stepID, String productName, String contractType) throws Exception
	{
		String actionName="validateOrderToCaseMappingNonQuotable";

		try
		{
			String extractedCategoryMapped=ProductConfigurationD03.getCategoryMappedOfOrderableProduct(productName);
			
			// Validation on Key Details section
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesCase.itemsKeyDetails)));

			String itemSubCategoryKeyDetailsVal=driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//span[contains(text(),'"+contractType+"')]")).getText();
			
			String itemDomainKeyDetailsVal = driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//span[contains(text(),'Fix')]")).getText();
			
			String itemTypeKeyDetailsVal = driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//span[contains(text(),'Order (Fix)')]")).getText();
			
			String itemCategoryKeyDetailsVal = driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//span[contains(text(),'"+extractedCategoryMapped+"')]")).getText();

			// Validation on Details Tab

			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesCase.caseMainTableDetailsTab)));
			
			
//			System.out.println(driver.findElement(By.xpath(DirSalesCase.caseMainTableDetailsTab)).isDisplayed());

			BrowserActions.jsClick(driver,(By.xpath(DirSalesCase.caseMainTableDetailsTab)));
			
//			System.out.println(driver.findElement(By.xpath(DirSalesCase.sectionCaseCategorizationDetailsTab)).isDisplayed());
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesCase.sectionCaseCategorizationDetailsTab)));
			
//			System.out.println(driver.findElement(By.xpath(DirSalesCase.sectionCaseCategorizationDetailsTab)).isDisplayed());
			
			String 	itemSubCategoryDetailsTabVal=driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//*[text()='"+contractType+"']")).getText();
			
			String itemDomainDetailsTabVal = driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//*[text()='Fix']")).getText();
			
			String itemTypeDetailsTabVal = driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//*[text()='Order (Fix)']")).getText();
			
			String itemCategoryDetailsTabVal = driver.findElement(By.xpath(DirSalesCase.itemsKeyDetails + "//*[text()='"+extractedCategoryMapped+"']")).getText();
			
			if((// Validation on Key Details section
				itemSubCategoryKeyDetailsVal.contains(contractType) || itemSubCategoryKeyDetailsVal.equalsIgnoreCase("new"))&&
					itemDomainKeyDetailsVal.equalsIgnoreCase("Fix") && itemTypeKeyDetailsVal.equalsIgnoreCase("Order (Fix)") &&
					itemCategoryKeyDetailsVal.equalsIgnoreCase(extractedCategoryMapped)&&
				// Validation on Details Tab
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

	public static boolean validateServiceRequestDateFromOrderToCaseAction(List<TestLog> logStream, WebDriver driver,
				int stepID, String SRD) throws Exception
		{
			String actionName="validateServiceRequestDateFromOrderToCaseAction";
	
			try
			{
				
				// Validation on Details Tab
	
				new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesCase.caseMainTableDetailsTab)));
				
				BrowserActions.jsClick(driver,(By.xpath(DirSalesCase.caseMainTableDetailsTab)));
				
				WebElement serviceRequestDate = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DirSalesCase.serviceRequestDate)));
				
				BrowserActions.ScrollByElement(driver, "xpath", DirSalesCase.sectionCaseCategorizationDetailsTab);
				
				Thread.sleep(2000);
				
				String 	serviceRequestDateValue = serviceRequestDate.getText();
				
				Boolean presenceOfSRDflag = driver.findElement(By.xpath(DirSalesCase.iconSRDflag)).isDisplayed();

				
				System.out.println("Debug of serviceRequestDateValue value: "+ serviceRequestDateValue);
				
				System.out.println("Debug of presenceOfSRDflag presence: "+ presenceOfSRDflag);

				TestLogger.logDebug(logStream, "Case", "Service Resquest Date value: " + serviceRequestDateValue);
				
				if(serviceRequestDateValue.contains(SRD)==true && presenceOfSRDflag==true)
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
