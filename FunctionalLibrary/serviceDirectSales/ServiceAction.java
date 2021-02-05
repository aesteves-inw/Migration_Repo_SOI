package serviceDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesService;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ServiceAction {

	public static boolean validateServiceScreen(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="validateServiceScreen";
		
     	try
				{
					if(BrowserActions.isElementPresent(driver, DirSalesService.headerServicesPage) && 
							BrowserActions.isElementPresent(driver, DirSalesService.buttonDetails) && 
							BrowserActions.isElementPresent(driver, DirSalesService.buttonEditProvContact) && 
							BrowserActions.isElementPresent(driver, DirSalesService.buttonEditInternalComments) && 
							BrowserActions.isElementPresent(driver, DirSalesService.buttonEditBillingAccountID))
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
