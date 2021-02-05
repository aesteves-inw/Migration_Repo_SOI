package navigation;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import opportunityDirectSales.OpportunityAction;
import orderDirectSales.OrderAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class NavigationStep {

	public static void goToOpportunityByURL(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String optyURL) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);

		String stepName="Go To Opportunity By URL";

		String stepNameMin="goToOpportunityByURL";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			NavigationAction.goToOPTYByURL(logStream, driver, stepID, optyURL);

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

	public static void goToOrderByURL(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String orderURL) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Go To Order By URL";

		String stepNameMin="goToOrderByURL";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			NavigationAction.goToByURL(logStream, driver, stepID, orderURL);
			
			//04-02 - Added Thread Sleep workaround
			Thread.sleep(5000);

			validation = OrderAction.orderScreenValidation(logStream, driver, stepID);

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

