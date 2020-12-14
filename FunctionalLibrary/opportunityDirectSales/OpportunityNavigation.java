package opportunityDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesOpportunity;
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
	
	

}
