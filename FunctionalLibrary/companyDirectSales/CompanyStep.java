package companyDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectMap.sfDirectSales.DirSalesOpportunity;
import opportunityDirectSales.OpportunityAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class CompanyStep {
	
	public static void createQuickSaleOpportunity(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, int stepID) throws Exception
	{
		
		
		
		String stepName="Company: Create Quick Sale Opportunity";

		String stepNameMin="createQuickSaleOpportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		String componentOfTheLog=stepNameMin+" - Step "+stepID;
		
		
		boolean validation;
		
		
		try
		{
			
			CompanyAction.createQuickSaleOpty(logStream, driver, testName);
			
			CompanyNavigation.goToOpportunityPage(logStream, driver, testName);
			
			validation=OpportunityAction.opportunityScreenValidation(logStream, driver, stepID);
			
			if (validation==true) 
			{
				TestLogger.logInfo(logStream, componentOfTheLog, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentOfTheLog, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}

	public static void startQuickSaleOPTY(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		
		String stepName="Start Quick Sale Opportunity";

		String stepNameMin="startQuickSaleOPTY";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			CompanyAction.openQuickSaleOPTYScreen(logStream, driver, testName);
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOpportunity.quickSaleOptyForm)));

			validation = CompanyAction.quickSaleFormValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
	public static void validateQuickSalePreFilledFields(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception {
		
		String stepName="Validate the pre filled fields";

		String stepNameMin="validateQuickSalePreFilledFields";

		String evidenceName=ReportStructure.evidenceName(stepsExecuted, stepNameMin);		


		boolean validation;

		try
		{
			
			validation = CompanyAction.validateQuickSaleFilledFields(logStream, driver, stepsExecuted);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepsExecuted, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepsExecuted);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepsExecuted, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepsExecuted);
		}
		
	}

	public static void finishQuickSaleOPTYCreation(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		
		String stepName="Fill Mandatory Fields and Press Save Button";

		String stepNameMin="finishQuickSaleOPTYCreation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			CompanyAction.fillQSOpportunityFields(logStream, driver, testName);
			
			CompanyAction.saveOpportunity(logStream, driver);
			

			validation = !(CompanyAction.quickSaleFormValidation(logStream, driver, stepID));

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}

	public static void navigateToOpportunityPage(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		String stepName="Navigate to Opportunity Page";

		String stepNameMin="navigateToOpportunityPage";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			CompanyNavigation.goToOpportunityPage(logStream, driver, testName);

			validation = OpportunityAction.opportunityScreenValidation(logStream,driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}

	public static void createStandardOpportunityForD02(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		
		String stepName="Create Standard Opportunity";

		String stepNameMin="createStandardOpportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			CompanyAction.createStandardOpportunity(logStream, driver, testName, stepID);
			
			CompanyAction.fillStandardOpportunityFields(logStream, driver, testName, stepID);
			
			CompanyAction.saveStandardOpportunity(logStream, driver, testName, stepID);
			
			CompanyAction.standardOpportunityForD02(logStream, driver, testName, stepID);
			
			CompanyNavigation.goToOpportunityPage(logStream, driver, testName);

			validation = OpportunityAction.opportunityScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
}
