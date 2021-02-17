package agreementPartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import agreementDirectSales.AgreementAction;
import executionTools.TestExecutionReport;
import generatedProposal.GeneratedProposalAction;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class AgreementPCStep {

	public static void generateDocumentProposal(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Agreement: Generate Document Proposal in PartCom";

		String stepNameMin="generateDocumentProposal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			AgreementPCAction.generateDocument(logStream, driver, stepID);

			validation = AgreementAction.generateDocumentProposalValidation(logStream, driver, stepID);

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

	public static void validateProposalForNonQuotableProductsInPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String product) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Agreement: validate Proposal For NonQuotable Products In PC";

		String stepNameMin="validateProposalForNonQuotableProductsInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String agreementID = TestCasesData.getIDByURL(driver.getCurrentUrl());
				
		try
		{
			AgreementPCNavigation.goToFilesRelatedList(logStream, driver, stepID, agreementID);
			
			AgreementPCNavigation.downloadfile(logStream, driver, stepID, agreementID);

			validation = GeneratedProposalAction.validationOfNonQuotableProducts(logStream, driver, stepID, product, agreementID);

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

	public static void addFileToAgreement(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) 
	{
				
	}

	public static void addFileAndGenerateFileToAgreement(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) 
	{
		
		
	}
	
	

}
