package agreementPartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementPCNavigation 
{
	public static void goToFilesRelatedList(List<TestLog> logStream, WebDriver driver, int stepID, String agreementID) throws Exception
	{
		String actionName="goToFilesRelatedList";

		//PartnersCommunity+PartnersCommunityRelatedList+agreementID+PartnersCommunityRelatedListFiles
		
		try
		{
			
			String urlForFilesRelatedList=ExcelDataFetch.searchDT(0,"PartnersCommunity")+ExcelDataFetch.searchDT(0,"PartnersCommunityRelatedList")+agreementID+ExcelDataFetch.searchDT(0,"PartnersCommunityRelatedListFiles");

			BrowserActions.goToByURL(driver, urlForFilesRelatedList);
			
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void downloadfile(List<TestLog> logStream, WebDriver driver, int stepID, String agreementID) throws Exception 
	{
		String actionName="downloadfile";


		try
		{
			Thread.sleep(5000);
			
			BrowserActions.getElementByJSQuery(driver,"document.querySelector('a.slds-button.slds-button--icon-x-small.slds-button--icon-border-filled').click();");
			
			Thread.sleep(3000);
			
			BrowserActions.getElementByJSQuery(driver,"document.querySelectorAll('a')[17].click();");
			
			Thread.sleep(10000);
			

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
