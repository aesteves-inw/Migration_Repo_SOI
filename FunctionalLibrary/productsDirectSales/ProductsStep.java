package productsDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import executionTools.TestExecutionReport;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class ProductsStep 
{

	public static void opportunitySyncedWithBasket(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
				
			int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
			
			
			String stepName="Products: Opportunity Synced with Basket Validation Step";

			String stepNameMin="opportunitySyncedWithBasket";

			String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


			boolean validation;

			try
			{
				
				validation = ProductsAction.validateProductsinOPTY(logStream, driver, stepID, productName);

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
	
	public static void opportunitySyncedWithBasketMultiProd(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String[] productName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		
		String stepName="Products: Opportunity Synced with Basket Validation Step";

		String stepNameMin="opportunitySyncedWithBasket";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			
			validation = ProductsAction.validateMultipleProductsInOPTY(logStream, driver, stepID, productName);

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
	

