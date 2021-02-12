package orderPartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import servicePartCom.ServicePCAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class OrderPCStep {

	public static void goToServiceScreenByURL(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String sURL) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: go To Service Screen By URL";

		String stepNameMin="goToServiceScreenByURL";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			BrowserActions.goToByURL(driver, sURL);

			validation = ServicePCAction.serviceScreenValidation(logStream, driver, stepID);

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

	public static void submitOrderPositiveValidation(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: Submit Order (Positive) Validation";

		String stepNameMin="submitOrderPositiveValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderPCAction.orderSubmissionPositiveValidation(logStream, driver, stepID);

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

	public static void submitOrderNegativeValBillingAddress(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: submit Order - Negative Val BillingAddress";

		String stepNameMin="submitOrderNegativeValBillingAddress";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderPCAction.orderSubmissionNegativeValBillingAddress(logStream, driver, stepID);

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

	public static void submitOrderNegativeValProvisioningContact(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: submit Order (Negative Val - ProvisioningContact)";

		String stepNameMin="submitOrderNegativeValProvisioningContact";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderPCAction.negativeValProvisioningContact(logStream, driver, stepID);

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
