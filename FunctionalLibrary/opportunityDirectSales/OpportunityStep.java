package opportunityDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import fetchDataFromExcelFiles.ExcelDataFetch;
import navigation.NavigationAction;
import objectMap.sfDirectSales.DirSalesOrder;
import orderDirectSales.OrderAction;
import productBasketDirectSales.ProductBasketAction;
import productsDirectSales.ProductsAction;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class OpportunityStep 
{
	
	public static void createProductBasket(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Create Product Basket";

		String stepNameMin="createProductBasket";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OpportunityAction.createProductBasket(logStream, driver, stepID);

			validation = ProductBasketAction.productBasketScreenValidation(logStream, driver, stepID);
//			validation = ProductBasketAction.validateProductBasketScreen(logStream, driver, stepID);

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

	public static void closeWinOPTY(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Opportunity: Close Won Opportunity";

		String stepNameMin="closeWinOPTY";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OpportunityAction.closeWonOpportunity(logStream, driver, stepID, testName);
			
			validation = OpportunityAction.closeWonOpportunityValidation(logStream, driver, stepID, testName);

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

	public static void goToOrderScreen(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productBasketName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Opportunity: Go to Order Screen";

		String stepNameMin="goToOrderScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			BrowserActions.refreshPage(driver);
			
			OpportunityNavigation.goToOrdersRelatedViewMenu(logStream, driver, stepID);
			
			OpportunityNavigation.pickOrderFromListD02(logStream, driver, stepID, productBasketName);			
			
			validation = OrderAction.orderScreenValidation(logStream, driver, stepID);

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

	public static void goToProductsRelatedView(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String optyURL) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		
		String stepName="Opportunity: Go To Products Related View";

		String stepNameMin="goToProductsRelatedView";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			String optyID=TestCasesData.getIDByURL(optyURL);
			
			String productsRelatedView=ExcelDataFetch.searchDT(0, "DirectSales")+ExcelDataFetch.searchDT(0, "DirectSalesProductsOpportunity")+optyID+ExcelDataFetch.searchDT(0, "DirectSalesProductsRelatedView");
			
			NavigationAction.goToByURL(logStream, driver, stepID, productsRelatedView);

			validation = ProductsAction.validationOfProductsRelatedMenu(logStream, driver, stepID);

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

	
