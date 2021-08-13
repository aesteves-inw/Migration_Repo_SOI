package addOfferToBasketDirectSales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesProductBasket;
import productBasketDirectSales.ProductBasketAction;
import testFrameworkLibrary.GeneralTestingFramework;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class AddOfferToBasketStep {
	
	public static void addProductToProductBasket(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{	
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		
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
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
	public static void addAllProductsFromSectionToBasket(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, List<String> listProductsName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Select All Products From A Section or Categorie";

		String stepNameMin="selectAllProductsFromSection";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	
		
		String sectionXpath = null;
		
		boolean validation = false;

		try 
		{
	     
	        AddOfferToBasketAction.pickMultipleProductsFromSectionOnAddOfferBasket(logStream, driver, stepID, listProductsName);
	        
	        Thread.sleep(2000);
	        
	        for (String productName : listProductsName) {
	        	
				productName.trim();
				
				validation = ProductBasketAction.productOnProductBasketValidation(logStream, driver, stepID, productName);
				
				if (validation==false)
				{
					break;
				}
			}
	        
			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}
}
