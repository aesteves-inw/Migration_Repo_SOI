package companyPartCom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import opportunityPartCom.OpportunityPCAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class CompanyPCStep {

	public static void createQuickSaleOPTY(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		
		
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		
		String stepName="Company: Create Quick Sale OPTY (Partners Community)";

		String stepNameMin="createQuickSaleOPTY";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			CompanyPCAction.createQuickSaleOPTY(logStream, testName, stepID, driver);
			
			CompanyPCNavigation.goToOpportunityPage(logStream, testName, stepID, driver);

			validation = OpportunityPCAction.opportunityPageValidation(logStream, testName, stepID, driver);

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
