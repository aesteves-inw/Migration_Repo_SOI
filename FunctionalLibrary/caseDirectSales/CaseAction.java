package caseDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesCase;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CaseAction {

	//Operational Actions




	//Validation Actions

	public static boolean caseScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="caseScreenValidation";
		
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, DirSalesCase.filesContainer))
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
