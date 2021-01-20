package homePagePartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import objectMap.sfPartnersCommunity.PartComHomePage;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class HomePagePCAction 
{


	// Operational Actions
	
	
	
	
	// Validation Actions
	
	public static boolean HomePageValidation(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
	      String actionName="HomePageValidation";
	      
	     	try
					{
						if(BrowserActions.isElementPresent(driver, PartComHomePage.headerNavigationBar) &&
							BrowserActions.isElementPresent(driver, PartComHomePage.quickCreateButton) &&
							BrowserActions.isElementPresent(driver, PartComHomePage.inputSearchBar) &&
							BrowserActions.isElementPresent(driver, PartComHomePage.dashboard))
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
