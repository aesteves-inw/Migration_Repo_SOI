package companyPartCom;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesOpportunity;
import objectMap.sfPartnersCommunity.PartComCompany;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyPCAction 
{
	//Operational Actions
	public static void createQuickSaleOPTY(List<TestLog> logStream, String testName, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="createQuickSaleOPTY";


		try
		{
			goToQuickSaleOpportunityScreen(logStream, stepID, driver);
			
			fillFieldsForQuickSale(logStream, testName, stepID, driver);
			
			saveQuickSaleOPTY(logStream, stepID, driver);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}
	
	private static void goToQuickSaleOpportunityScreen(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="goToQuickSaleOpportunityScreen";


		try
		{
			driver.findElement(By.xpath(PartComCompany.buttonQuickButton)).click();
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComCompany.headerQuickSale)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fillFieldsForQuickSale(List<TestLog> logStream, String testName, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="fillFieldsForQuickSale";


		String optyName;

		optyName=TestCasesData.getOPTYName(testName);

		try
		{			
			driver.findElement(By.xpath(DirSalesOpportunity.optyNameinput)).sendKeys(optyName);		

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void saveQuickSaleOPTY(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="saveQuickSaleOPTY";


		try
		{
			WebElement buttonSaveQuickSale = driver.findElement(By.xpath(PartComCompany.buttonSaveQuickSale));
			
			buttonSaveQuickSale.click();
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(buttonSaveQuickSale));

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
	public static boolean CompanyPageValidation(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="CompanyPageValidation";
		
		try
		{
			String companyPageTitle=driver.getTitle();
			
			String companyName=ExcelDataFetch.searchDT(2, "testingCompanyD02Functional");
			
			System.out.println("companyPageTitle: "+companyPageTitle);
			
			System.out.println("companyName: "+companyName);
			
			if(companyPageTitle.contains(companyName))
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
