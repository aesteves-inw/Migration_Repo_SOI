package productBasketDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class ProductBasketStep 
{
	public static void goToAddOferToBasketScreen(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
	{
		
		String stepName="Go To Add Offer to Basket Screen";

		String stepNameMin="goToAddOferToBasketScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.openAddProductMenu(logStream, driver, stepID);

			validation = AddOfferToBasketAction.addProductMenuValidation(logStream, driver, stepID);

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
	
	public static void syncProductBasketNegVal(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, int newStepCounter, String testName) throws Exception 
	{
		String stepName="Sync Product Basket (Negative Validation)";

		String stepNameMin="syncProductBasketNegVal";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.syncProductBasket(logStream, driver, newStepCounter);

			validation = ProductBasketAction.syncProductBasketNegVal(logStream, driver, newStepCounter);

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
		}

		
	}

	
	public static void deletePBLineItem(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, int newStepCounter, String productName) throws Exception 
	{
		String stepName="Delete Product Basket Line Item";

		String stepNameMin="deletePBLineItem";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.selectLineItem(logStream, driver, newStepCounter, productName);
			
			ProductBasketAction.deleteLineItem(logStream, driver, newStepCounter);
			
			validation = ProductBasketAction.productOnProductBasketNegativeValidation(logStream, driver, newStepCounter, productName);

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
		}
		
	}
	
	

}
	



