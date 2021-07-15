package agreementDirectSales;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;

import agreementPartCom.AgreementPCNavigation;
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

	public static void validateProposalPDFContentByRegex(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String text,String language, String validRegexPattern, boolean expectedPDFTextValidation) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Proposal: PDF Content Contains Text: " +expectedPDFTextValidation+ ".\r\n Expected text: " + text;
	
		String stepNameMin="validateProposalPDFContentByRegex";
	
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
	
	
		boolean validation = false;
		
		
		String agreementID;
	
		try
		{
			Thread.sleep(2000);
			
			if(language==null)language="EN";
			
			agreementID=TestCasesData.getIDByURL(driver.getCurrentUrl());
			
//			System.out.println(driver.getCurrentUrl());
			
			AgreementNavigation.downloadProposal(logStream, driver, stepID);
			
			String proposalFileName="AgreementSQ_"+language+" - "+agreementID+".pdf";
				
			String proposalFileLocation = TestDataFiles.externalFilesRepository+"\\"+proposalFileName;
	
			File file = new File(proposalFileLocation);
			
			System.out.println("File downloaded sucessfully: " + file.exists());
			
			validation=BrowserActions.pdfContentValidationByRegex(proposalFileLocation, validRegexPattern);
			
			System.out.println("BrowserActions.pdfContentValidationByRegex(proposalFileLocation, validRegexPattern): " + validation);

			if ((expectedPDFTextValidation==true && validation==true)|| (expectedPDFTextValidation==false && validation==false)) 
			{
				validation=true;
				System.out.println("I'm here on 1st validation");
				
			}else if ((expectedPDFTextValidation==true && validation==false) || (expectedPDFTextValidation==false && validation==true))
			{
				
				validation=false;
				System.out.println("I'm here on 2nd validation");
				
			}
			
			TestLogger.logDebug(logStream, "validateProposalForNonQuotableProducts", "The outcome '"+ expectedPDFTextValidation + "' expected  from the PDF Content  validation  is " + validation);

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
			AgreementAction.addFileToAgreement(logStream, driver, stepID, externalFileName);
			
			AgreementAction.generateDocumentProposalOnly(logStream, driver, stepID);
			
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
	
	
	public static void changeLanguageBeforeGeneratingDocumentProposal(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String language) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Agreement: Change Language before Generating Document Proposal";

		String stepNameMin="changeLanguageBeforeGeneratingDocumentProposal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			AgreementAction.changeLanguageOnDetailsForAgreementDocument(logStream, driver, stepID, language);

			validation = AgreementAction.validationOfLanguageOnDetailsForAgreementDocument(logStream, driver, stepID, language);

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
