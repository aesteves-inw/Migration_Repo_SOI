package servicePartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import serviceDirectSales.ServiceAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class 
ServicePCStep {

	public static void fillProvisioningContactPerson(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill Provisioning Contact Person: "+provContactPerson;

		String stepNameMin="fillProvisioningContactPerson";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServicePCAction.fillProvisioningContactPersonInPC(logStream, driver, stepID, provContactPerson);

			ServicePCAction.saveChangesOnServiceDetails(logStream, driver, stepID);

			validation = BrowserActions.isElementPresent(driver, "//input[@placeholder='"+provContactPerson+"']");

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

	public static void serviceCaseValidationAfterOrderSubmit(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Case Validation After Order Submit";

		String stepNameMin="serviceCaseValidationAfterOrderSubmit";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{

			validation = ServicePCAction.caseValidationAfterOrderSubmit(logStream, driver, stepID);

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

	public static void fillBillingAccountID(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service fillBillingAccountID (in PC)";

		String stepNameMin="fillBillingAccountID";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;


		String billingAccountID ="04121986";

		try
		{
			ServicePCAction.fillBillingAccountID(logStream, driver, stepID, billingAccountID);

			ServicePCAction.saveChangesOnServiceDetails(logStream, driver, stepID);

			validation = ServicePCAction.validateBillingAccountID(logStream, driver, stepID, billingAccountID);

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

	public static void fillWithNewProvisioningContactPerson(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill With New Provisioning Contact Person (in PC)";

		String stepNameMin="fillWithNewProvisioningContactPerson";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;


		try
		{
			ServicePCAction.createNewProvisioningContactPerson(logStream, driver, stepID);

			validation = ServicePCAction.validateNewProvisioningContactPersonAfterSaving(logStream, driver, stepID);

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

	public static void validateProvisioningContactPerson(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Service: validate Provisioning Contact Person (In PC)";

		String stepNameMin="validateProvisioningContactPerson";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{

			validation = ServicePCAction.validateProvisioningContactPersonAfterSaving(logStream, driver, stepID, provContactPerson);

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

	public static void fillContractType(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String contractType) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Service in PC: fill Contract Type";

		String stepNameMin="fillContractTypeInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.fillContractTypeServiceLevel(logStream, driver, stepID, contractType);
			
			validation = ServiceAction.valContractType(logStream, driver, stepID, contractType);

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
