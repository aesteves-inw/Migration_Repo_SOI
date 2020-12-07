package loginPageDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import homePageDirectSales.HomePageAction;
import testLogBuilder.TestLog;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class LoginPageStep {
	
	public static TestStepReportStructure loginSFDS(List<TestLog> logStream, WebDriver driver, String testName, int stepID, String userProfile) throws Exception
	{
		TestStepReportStructure loginSFDS;

		String stepName="Login in Salesforce (Direct Sales)";

		String stepNameMin="loginSFDS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
			
		
		try
		{
			LoginPageAction.loginDirectSales(logStream, driver, stepID, userProfile);
			
			validation=HomePageAction.homePageValidation(logStream, driver);
			
			if (validation==true) 
			{
				BrowserActions.screenShotTaking(driver, testName, evidenceName);
				loginSFDS=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return loginSFDS;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			BrowserActions.screenShotTaking(driver, testName, evidenceName);
			loginSFDS=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return loginSFDS;
		}
	}

}
