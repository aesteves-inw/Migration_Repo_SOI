package orderDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesOrder;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderAction 
{

	public static boolean orderScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		  String actionName="orderScreenValidation";
	     	try
					{
						if(BrowserActions.isElementPresent(driver, DirSalesOrder.orderDetails))
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
