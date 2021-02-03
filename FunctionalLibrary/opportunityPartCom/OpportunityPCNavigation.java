package opportunityPartCom;

import java.util.List;

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

}
