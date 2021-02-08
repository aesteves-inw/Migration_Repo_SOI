package productBasketPartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import navigation.NavigationAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketPCNavigation 
{
	   public static void goToOptyByURL(List<TestLog> logStream, WebDriver driver, int stepID, String optyURL) throws Exception
	    {
	        String actionName="goToOptyByURL";


					try
					{
						NavigationAction.goToByURL(logStream, driver, stepID, optyURL);

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

