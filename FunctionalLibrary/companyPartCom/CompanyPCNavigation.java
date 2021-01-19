package companyPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.TestObjectTools;
import fetchDataFromExcelFiles.ExcelDataFetch;
import navigation.NavigationAction;
import objectMap.sfPartnersCommunity.PartComOpportunity;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyPCNavigation 
{

	public static void goToOpportunityPage(List<TestLog> logStream, String testName, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="goToOpportunityPage";
		
		String opportunityRelatedViewOnCompanyURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+ExcelDataFetch.searchDT(0, "PartnersCommunityOpportunityRelated")+"/"+TestCasesData.getIDByURL(driver.getCurrentUrl())+ExcelDataFetch.searchDT(0, "PartnersCommunityOpportunitesSufix");

		String optyName=TestCasesData.getOPTYName(testName);
		
		String optyURL;

		try
		{
			NavigationAction.goToByURL(logStream, driver, stepID, opportunityRelatedViewOnCompanyURL);
			
			String optyRecordID= TestObjectTools.getDataRecordID(driver, optyName);
			
			optyURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+"/"+optyRecordID;
			
			NavigationAction.goToByURL(logStream, driver, stepID, optyURL);
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PartComOpportunity.optyDetails)));

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
