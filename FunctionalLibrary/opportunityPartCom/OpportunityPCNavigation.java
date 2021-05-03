package opportunityPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OpportunityPCNavigation {

	public static void goToProductsRelatedViewList(List<TestLog> logStream, WebDriver driver, int stepID,
			String optyURL) throws Exception 
	{
		String actionName="goToProductsRelatedViewList";

		String optyID=TestCasesData.getIDByURL(optyURL);

		String optyLineItemsListViewURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+ExcelDataFetch.searchDT(0, "PartnersCommunityRelatedList")+optyID+ExcelDataFetch.searchDT(0, "PartnersCommunityRelatedListLineItems");
		
		try
		{
			BrowserActions.goToByURL(driver, optyLineItemsListViewURL);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void goToOrderRelatedViewList(List<TestLog> logStream, WebDriver driver, int stepID, String optyURL) throws Exception 
	{
		String actionName="goToOrderRelatedViewList";
		
		String opportunityID=TestCasesData.getIDByURL(optyURL);
		
		String orderRelatedListURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+ExcelDataFetch.searchDT(0, "PartnersCommunityOrderRelatedList")+opportunityID+ExcelDataFetch.searchDT(0, "PartnersCommunityOrderRelatedListView");
		
		try
		{
			BrowserActions.goToByURL(driver, orderRelatedListURL);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	public static void goToOrderScreenByOrderName(List<TestLog> logStream, WebDriver driver, int stepID,
			String productBasketName) throws Exception 
	{
		String actionName="goToOrderScreenByOrderName";


		try
		{
			String orderURL=driver.findElement(By.linkText(productBasketName)).getAttribute("href");
			
			BrowserActions.goToByURL(driver, orderURL);

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
