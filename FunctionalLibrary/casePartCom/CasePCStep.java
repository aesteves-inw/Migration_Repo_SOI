package casePartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import caseDirectSales.CaseAction;
import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesCase;
import objectMap.sfPartnersCommunity.PartComCase;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class CasePCStep {

	public static void validateSubCategoryNonQuotableStandalone(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Case: validate SubCategory Non-Quotable Standalone (In PC)";

		String stepNameMin="validateSubCategoryNonQuotableStandalone";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = CasePCAction.validateSubCategoryNonQuotableStandalone(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}


	public static void validateSubCategoryQuotableStandalone(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Case: validate SubCategory Quotable Standalone (In PC)";

		String stepNameMin="validateSubCategoryQuotableStandaloneInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = CasePCAction.validateSubCategoryQuotableStandalone(logStream, driver, stepID, productName, configurationIndex);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}



	public static void validateSubCategoryNonQuotableAndQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Case: validate SubCategory Non-Quotable And Quotable Products(In PC)";

		String stepNameMin="validateSubCategoryNonQuotableAndQuotableInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = CasePCAction.validateSubCategoryNonQuotableAndQuotable(logStream, driver, stepID, productName, configurationIndex);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}

	public static void validateOrderToCaseMAppingNonQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName,String contractType ) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Case: validate Order to Case Mapping of Non Quotable Products";

		String stepNameMin="validateOrderToCaseMAppingNonQuotable";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = CasePCAction.validateOrderToCaseMappingNonQuotable(logStream, driver, stepID, productName, contractType);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
//				BrowserActions.verticalscrollByVisibleElement(driver, PartComCase.caseCategorization);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
				
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}
	
	public static void validateServiceRequestDateFromOrderToCase(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String SRD ) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Case: validate Service Request Date Copied from Order to Case";
	
		String stepNameMin="validateServiceRequestDateFromOrderToCase";
	
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
	
	
		boolean validation;
	
		try
		{
			validation = CasePCAction.validateServiceRequestDateFromOrderToCaseAction(logStream, driver, stepID, SRD);
	
			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
				
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
	
	
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}

}
