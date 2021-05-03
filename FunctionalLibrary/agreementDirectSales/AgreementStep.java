package agreementDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import generatedProposal.GeneratedProposalAction;
import testDataFiles.TestDataFiles;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class AgreementStep 
{
	
	public static void generateDocumentProposal(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Agreement: Generate Document Proposal";

		String stepNameMin="generateDocumentProposal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			AgreementAction.generateDocumentProposal(logStream, driver, stepID);

			validation = AgreementAction.generateDocumentProposalValidation(logStream, driver, stepID);

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

	public static void addFileToAgreement(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		
		String stepName="Agreement: Add File to Agreement";

		String stepNameMin="addFileToAgreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;
		
		String fileName = TestDataFiles.fileNameD01;

		try
		{
			AgreementAction.addFileToAgreement(logStream, driver, stepID, fileName);

			validation = AgreementAction.validationOfFileAddedToAgreement(logStream, driver, stepID, fileName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
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
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}

	public static void goToFilesRelatedListView(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		
		String stepName="step";

		String stepNameMin="step";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			String agreementID = TestCasesData.getIDByURL(driver.getCurrentUrl());
			
			AgreementNavigation.goToFilesRelatedListView(logStream, driver, stepID, agreementID);

			validation = AgreementAction.validationOfFilesRelatedListView(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
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
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}

	public static void validateProposalForNonQuotableProducts(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Proposal: Validate Proposal ForNonQuotable Product: "+productName;

		String stepNameMin="validateProposalForNonQuotableProducts";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;
		
		
		String agreementID;

		try
		{
			agreementID=TestCasesData.getIDByURL(driver.getCurrentUrl());
			
			AgreementNavigation.downloadProposal(logStream, driver, stepID);

			validation = GeneratedProposalAction.validationOfNonQuotableProducts(logStream, driver, stepID, productName, agreementID);
			
			

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
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
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
		
	}

	public static void addFileAndGenerateFileToAgreement(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Agreement: add File And Generate File To Agreement";

		String stepNameMin="addFileAndGenerateFileToAgreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
		
	
		
		String externalFileName=TestDataFiles.fileNameD01;
		
		



		boolean validation;

		try
		{
			AgreementAction.generateDocumentProposalOnly(logStream, driver, stepID);
			
			AgreementAction.addFileToAgreement(logStream, driver, stepID, externalFileName);
			
			Thread.sleep(10000);
			
			BrowserActions.refreshPage(driver);

			validation = AgreementAction.validationOfFileAddedToAgreement(logStream, driver, stepID, externalFileName) && AgreementAction.generateDocumentProposalValidation(logStream, driver, stepID);

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
