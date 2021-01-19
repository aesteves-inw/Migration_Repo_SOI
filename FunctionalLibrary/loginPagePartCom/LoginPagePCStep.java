package loginPagePartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import homePagePartCom.HomePagePCAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class LoginPagePCStep 
{
	public static void LoginPartnersCommunity(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String user) throws Exception
	{
	
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		
		String stepName="Login in Partners Community with User: "+user;

		String stepNameMin="LoginPartnersCommunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			LoginPagePCAction.loginPartnersCommunity(logStream, driver, stepID, user);

			validation = HomePagePCAction.HomePageValidation(logStream, stepID, driver);

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
