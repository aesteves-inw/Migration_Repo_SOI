package homePagePartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyPartCom.CompanyPCAction;
import executionTools.TestExecutionReport;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class HomePagePCStep 
{
	public static void NavigateToCompanyPage(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
	
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		
		String stepName="Home Page: Navigate To Company Page";

		String stepNameMin="NavigateToCompanyPage";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			HomePagePCNavigation.goToCompanyPageByURL(logStream, stepID, driver, testName);

			validation = CompanyPCAction.CompanyPageValidation(logStream, stepID, driver);

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
