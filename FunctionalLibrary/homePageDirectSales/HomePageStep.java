package homePageDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class HomePageStep {
	
	public static void navigateToCompanyPage(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, int stepID) throws Exception
	{
		
		String stepName="Navigate to Company Details Page (Direct Sales)";

		String stepNameMin="navigateToCompanyPage";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		String componentOfTheLog=stepNameMin+" - Step "+stepID;
		
		
		boolean validation;
		
				
		try
		{
			
			HomePageNavigation.goToDefaultCompanyDetailsPage(logStream, driver, stepID);
			
			validation=CompanyAction.companyPageValidation(logStream, driver, stepID);
			
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

