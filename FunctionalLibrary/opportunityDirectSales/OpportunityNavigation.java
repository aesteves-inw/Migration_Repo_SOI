package opportunityDirectSales;

import java.util.List;
import org.openqa.selenium.WebDriver;
import executionTools.BrowserActions;
import executionTools.TestObjectTools;
import fetchDataFromExcelFiles.ExcelDataFetch;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OpportunityNavigation {

	public static void goToEditScreen(List<TestLog> logStream, WebDriver driver, int stepsExecuted,
			String opportunityID) throws Exception 
	{
		String actionName="goToEditScreen";


		try
		{
			String editScreenURL="https://proximus--prxitt.lightning.force.com/lightning/r/Opportunity/"+opportunityID+"/edit?navigationLocation=DETAIL&backgroundContext=%2Flightning%2Fr%2FOpportunity%2F"+opportunityID+"%2Fview&count=1";

			BrowserActions.goToByURL(driver, editScreenURL);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepsExecuted);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepsExecuted, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepsExecuted,e);
		}

	}

	public static void goToOrdersRelatedViewMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="goToOrdersRelatedViewMenu";


		try
		{
			String optyURL=driver.getCurrentUrl();
			
			String optyID=TestCasesData.getIDByURL(optyURL);
					
			String urlOrdersRelatedViewMenu=ExcelDataFetch.searchDT(0, "DirectSalesOrdersURLString1")+optyID+ExcelDataFetch.searchDT(0, "DirectSalesOrdersURLString2");
			
			
			BrowserActions.goToByURL(driver, urlOrdersRelatedViewMenu);
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void pickOrderFromListD02(List<TestLog> logStream, WebDriver driver, int stepID, String prodBasketName) throws Exception
	{
		 String actionName="pickOrderFromOrderListView";


			try
			{
				String orderRecordID= TestObjectTools.getDataRecordID(driver, prodBasketName);

				String orderURL="https://proximus--prxitt.lightning.force.com/lightning/r/csord__Order__c/"+orderRecordID+"/view";

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
