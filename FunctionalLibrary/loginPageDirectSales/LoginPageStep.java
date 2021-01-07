package loginPageDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import homePageDirectSales.HomePageAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class LoginPageStep {
	
	public static void loginSFDS(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String userProfile) throws Exception
	{	
		
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Login in Salesforce (Direct Sales)";

		String stepNameMin="loginSFDS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		String componentOfTheLog=stepNameMin+" - Step "+stepID;
		
		
		boolean validation;
			
		
		try
		{
			LoginPageAction.loginDirectSales(logStream, driver, stepID, userProfile);
			
			validation=HomePageAction.homePageValidation(logStream, driver);
			
			System.out.println("validation result on Login: "+validation);
			
			if (validation==true) 
			{
				TestLogger.logInfo(logStream, componentOfTheLog, TestLogger.logInfo);
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
			TestLogger.logError(logStream, componentOfTheLog, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID, e);
		}
	}
	
	
}
