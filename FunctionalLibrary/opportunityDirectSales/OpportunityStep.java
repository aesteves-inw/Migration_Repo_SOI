package opportunityDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import productBasketDirectSales.ProductBasketAction;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class OpportunityStep {
	
	public static void createProductBasket(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		
		String stepName="Create Product Basket";

		String stepNameMin="createProductBasket";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OpportunityAction.createProductBasket(logStream, driver, stepID);

			validation = ProductBasketAction.productBasketScreenValidation(logStream, driver, stepID);

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

	public static void relatedProductBasketsValidation(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int newStepCounter, String testName) throws Exception {
		
		String stepName="Related Product Baskets Validation";

		String stepNameMin="relatedProductBasketsValidation";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			OpportunityAction.goToProductBasketRelatedMenu(logStream, driver, newStepCounter);

			validation = OpportunityAction.validateMoreThanOneRelatedProductBasket(logStream, driver, newStepCounter);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
		}
		
	}

	public static void goToEditOpportunityScreen(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception 
	{
		String stepName="Go To Edit Opportunity Screen";

		String stepNameMin="goToEditOpportunityScreen";

		String evidenceName=ReportStructure.evidenceName(stepsExecuted, stepNameMin);		

		String opportunityID;
		
		boolean validation;

		try
		{			
			opportunityID=BrowserActions.getRecordIDByURL(driver);
			
			OpportunityNavigation.goToEditScreen(logStream, driver, stepsExecuted, opportunityID);

			validation = OpportunityAction.validateEditOpportunityScreen(logStream, driver, stepsExecuted);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepsExecuted, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepsExecuted);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepsExecuted, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepsExecuted);
		}
		
	}


	public static void editOpportunityNameNegVal(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception 
	{
		String stepName="Edit Opportunity with Negative Validation";

		String stepNameMin="editOpportunityNameNegVal";

		String evidenceName=ReportStructure.evidenceName(stepsExecuted, stepNameMin);		


		boolean validation;

		try
		{
			String editOPTYName="EditName_"+TestCasesData.getOPTYName(testName);
			
			OpportunityAction.changeOPTYName(logStream, driver, stepsExecuted, editOPTYName);

			validation = OpportunityAction.editOPTYNegativeValidation(logStream, driver, stepsExecuted);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepsExecuted, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepsExecuted);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepsExecuted, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepsExecuted);
		}
		
	}

	
}

	
