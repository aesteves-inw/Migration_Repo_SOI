package agreementPartCom;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;

import agreementDirectSales.AgreementAction;
import agreementDirectSales.AgreementNavigation;
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
			List<TestLog> logStream, WebDriver driver, String testName, String product,String language) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Agreement: validate Proposal For NonQuotable Products In PC";

		String stepNameMin="validateProposalForNonQuotableProductsInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String agreementID = TestCasesData.getIDByURL(driver.getCurrentUrl());
				
		try
		{
			if(language==null)language="EN";
			
			AgreementPCNavigation.goToFilesRelatedList(logStream, driver, stepID, agreementID);
			
			AgreementPCNavigation.downloadfile(logStream, driver, stepID, agreementID);

			validation = GeneratedProposalAction.validationOfNonQuotableProducts(logStream, driver, stepID, product, agreementID,language);

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
			WebDriver driver, String testName, String filePath, String fileName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Agreement: add File To Agreement (In PC)";

		String stepNameMin="addFileToAgreementPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			AgreementPCAction.addFileToAgreement(logStream, driver, stepID, filePath);
			
			validation = AgreementPCAction.addFileToAgreementValidation(logStream, driver, stepID, fileName);

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

	public static void addFileAndGenerateFileToAgreement(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String filePath, String fileName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Agreement: addFileAndGenerateFileToAgreement";

		String stepNameMin="addFileAndGenerateFileToAgreementInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	
		
		
		String agreementID=TestCasesData.getIDByURL(driver.getCurrentUrl());
		

		boolean validation;

		try
		{
			AgreementPCAction.generateDocumentOnly(logStream, driver, stepID);
			
			AgreementPCAction.addFileToAgreement(logStream, driver, stepID, filePath);
			
			BrowserActions.refreshPage(driver);
		
			validation = AgreementPCAction.addFileToAgreementValidation(logStream, driver, stepID, fileName) && AgreementPCAction.addFileToAgreementValidation(logStream, driver, stepID, agreementID);

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
		
		String stepName="Agreement: Change Language before Generating Document Proposal in Partners Community";
	
		String stepNameMin="changeLanguageBeforeGeneratingDocumentProposal";
	
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
	
	
		boolean validation;
	
		try
		{
			AgreementPCAction.changeLanguageOnDetailsForAgreementDocument(logStream, driver, stepID, language);
	
			validation = AgreementPCAction.validationOfLanguageOnDetailsForAgreementDocument(logStream, driver, stepID, language);
	
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
			
			String agreementPageURL=driver.getCurrentUrl();

			agreementID=TestCasesData.getIDByURL(agreementPageURL);
			
//			System.out.println(driver.getCurrentUrl());
			
			AgreementPCNavigation.downloadfile(logStream, driver, stepID, agreementID);
			
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
	
			BrowserActions.goToByURL(driver, agreementPageURL);

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
	
	

}
