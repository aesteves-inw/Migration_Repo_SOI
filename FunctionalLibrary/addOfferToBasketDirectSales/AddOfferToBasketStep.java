package addOfferToBasketDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import productBasketDirectSales.ProductBasketAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class AddOfferToBasketStep {
	
	public static void addProductToProductBasket(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName, String productName) throws Exception 
	{	
		String stepName="Add Offer to Basket: "+productName;

		String stepNameMin="addProductToProductBasket";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			AddOfferToBasketAction.pickProductOnAddOfferBasket(logStream, driver, stepID, productName);

			validation = ProductBasketAction.productOnProductBasketValidation(logStream, driver, stepID, productName);

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
