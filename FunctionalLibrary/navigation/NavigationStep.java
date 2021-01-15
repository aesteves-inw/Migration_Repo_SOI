package navigation;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import opportunityDirectSales.OpportunityAction;
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
}

