package navigation;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class NavigationAction {

	public static void goToOPTYByURL(List<TestLog> logStream, WebDriver driver, int stepID, String optyURL) throws Exception 
	{
		String actionName="goToOPTYByURL";


		try
		{
			BrowserActions.goToByURL(driver, optyURL);

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
