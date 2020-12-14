package opportunityDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import productBasketDirectSales.ProductBasketAction;
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
		}

	}

}
