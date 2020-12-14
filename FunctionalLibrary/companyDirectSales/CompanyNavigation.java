package companyDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import executionTools.TestObjectTools;
import fetchDataFromExcelFiles.ExcelDataFetch;
import testExecutionData.CompaniesTestData;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyNavigation {
	
	//07-12-2020 - To be taken as Improvement - Introducing Switch loop instead of specific function.

	static String logInfo="Executed with success";
	static String logError="Executed with errors";

	static String companyID;

	//Objects
	public static void goToOpportunityPage(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{

		String optyURL, optyRecordID;
		
		String optyName=TestCasesData.getOPTYName(testName);

		try
		{

			goToOpportunityRelatedMenuOnCompany(logStream, driver, testName);

			optyRecordID= TestObjectTools.getDataRecordID(driver, optyName);

			optyURL="https://proximus--prxitt.lightning.force.com/lightning/r/Opportunity/"+optyRecordID+"/view";

			BrowserActions.goToByURL(driver, optyURL);

			TestLogger.logInfo(logStream, "goToOpportunityPage", logInfo);

		}

		catch (Exception e)
		{
			TestLogger.logError(logStream, "goToOpportunityPage", logError, e.toString());
			throw new Exception("goToOpportunityPage - "+logError);
		}

	}

	public void goToOrderPage(List<TestLog> logStream, WebDriver driver, String testName, String orderName) throws Exception
	{
		
		String orderURL, orderRecordID;
		
		try
		{
			goToOrderRelatedMenuOnCompany(logStream, driver, testName);
			
			orderRecordID=TestObjectTools.getDataRecordID(driver, orderName);
			
			orderURL="https://proximus--prxitt.lightning.force.com/lightning/r/csord__Orders__r/"+orderRecordID+"/view";
			
			BrowserActions.goToByURL(driver, orderURL);

			TestLogger.logInfo(logStream, "goToOrderPage", logInfo);
			
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "goToOrderPage", logError, e.toString());
			throw new Exception("goToOrderPage - "+logError);
		}
	}
	
	
	
	//Related Menu
	public static void goToOpportunityRelatedMenuOnCompany(List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String companyOpportunityRelatedListLink;

		try
		{
			//companyID=CompaniesTestData.tdCompanyID(testName);
			
			companyID=ExcelDataFetch.searchDT(2, "idCompanyD02Functional");

			companyOpportunityRelatedListLink="https://proximus--prxitt.lightning.force.com/lightning/r/"+companyID+"/related/Opportunities/view";

			BrowserActions.goToByURL(driver, companyOpportunityRelatedListLink);

			TestLogger.logInfo(logStream, "goToOpportunityRelatedMenuonCompany", logInfo);

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "goToOpportunityRelatedMenuonCompany", logError, e.toString());
			throw new Exception("goToOpportunityRelatedMenuonCompany - "+logError);
		}


	}

	public void goToCaseRelatedMenuOnCompany(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String caseRelatedListLink;

		try
		{
			companyID=CompaniesTestData.tdCompanyID(testName);
			
			caseRelatedListLink="https://proximus--prxitt.lightning.force.com/lightning/r/"+companyID+"/related/Cases/view";
			
			BrowserActions.goToByURL(driver, caseRelatedListLink);
			
			TestLogger.logInfo(logStream, "goToCaseRelatedMenuOnCompany", logInfo);
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "goToCaseRelatedMenuOnCompany", logError, e.toString());
			throw new Exception("goToCaseRelatedMenuOnCompany - "+logError);
		}
	}
	
	public void goToOrderRelatedMenuOnCompany(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String orderRelatedListLink;

		try
		{
			companyID=CompaniesTestData.tdCompanyID(testName);
			
			orderRelatedListLink="https://proximus--prxitt.lightning.force.com/lightning/r/"+companyID+"/related/csord__Orders__r/view";
			
			BrowserActions.goToByURL(driver, orderRelatedListLink);
			
			TestLogger.logInfo(logStream, "goToOrderRelatedMenuOnCompany", logInfo);
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "goToOrderRelatedMenuOnCompany", logError, e.toString());
			throw new Exception("goToOrderRelatedMenuOnCompany - "+logError);
		}
	}
	
	public void goToCompanyContactPersonRelatedMenuOnCompany(List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String companyContactPersonRelatedListLink;

		try
		{
			companyID=CompaniesTestData.tdCompanyID(testName);
			
			companyContactPersonRelatedListLink="https://proximus--prxitt.lightning.force.com/lightning/r/"+companyID+"/related/Contacts/view";
			
			BrowserActions.goToByURL(driver, companyContactPersonRelatedListLink);
			
			TestLogger.logInfo(logStream, "goToCompanyContactPersonRelatedMenuOnCompany", logInfo);
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, "goToCompanyContactPersonRelatedMenuOnCompany", logError, e.toString());
			throw new Exception("goToCompanyContactPersonRelatedMenuOnCompany - "+logError);
		}
	}
	
	
	
	

}
