package orderEnrichmentDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesOrderEnrichment;
import productBasketDirectSales.ProductBasketAction;
import productBasketDirectSales.ProductBasketNavigation;
import productBasketPartCom.ProductBasketPCAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class OrderEnrichmentStep {

	public static void changeProduct(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Order Enrichment: Change Product";

		String stepNameMin="changeProduct";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			driver.switchTo().defaultContent();

			String OE_URL = driver.getCurrentUrl();

			if(OE_URL.contains("one")) {
				OrderEnrichmentAction.changeToOrderEnrichmentiFrame(logStream, driver, stepID);
			}
			
			OrderEnrichmentAction.selectProductForOEConfig(logStream, driver, stepID, productName);

			OrderEnrichmentAction.tabsforOEValidation(logStream, driver, stepID);

			validation=OrderEnrichmentAction.tabsforOEValidation(logStream, driver, stepID);

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
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}

	public static void fillDataCapFormEV(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String dataCapValue) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Order Enrichment: Fill Data Capture Form - EV";

		String stepNameMin="fillDataCapFormEV";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			driver.switchTo().defaultContent();

			String OE_URL = driver.getCurrentUrl();

			if(OE_URL.contains("one")) {
				OrderEnrichmentAction.changeToOrderEnrichmentiFrame(logStream, driver, stepID);
			}
			OrderEnrichmentAction.selectProductForOEConfig(logStream, driver, stepID, productName);

			OrderEnrichmentAction.fillDataCapFormEV(logStream, driver, stepID, productName, dataCapValue);

			validation=OrderEnrichmentAction.dataCaptureValidation(logStream, driver, stepID, productName, dataCapValue);

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
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}

	public static void fillContactsFormEV(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String dataCapValue) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Order Enrichment: Contacts Form - EV";

		String stepNameMin="fillContactsFormEV";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			driver.switchTo().defaultContent();

			String OE_URL = driver.getCurrentUrl();

			if(OE_URL.contains("one")) {
				OrderEnrichmentAction.changeToOrderEnrichmentiFrame(logStream, driver, stepID);
			}
			OrderEnrichmentAction.selectProductForOEConfig(logStream, driver, stepID, productName);

			OrderEnrichmentAction.fillContactEV(logStream, driver, stepID, productName, dataCapValue);

			validation=OrderEnrichmentAction.contactValidation(logStream, driver, stepID, productName, dataCapValue);

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
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
	public static void backToProductBasket(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Order Enrichment: Navigate back to Product Basket";

		String stepNameMin="backToProductBasket";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			driver.switchTo().defaultContent();

			String OE_URL = driver.getCurrentUrl();

			if(OE_URL.contains("one")) {
				OrderEnrichmentAction.changeToOrderEnrichmentiFrame(logStream, driver, stepID);
			}
			
			driver.findElement(By.xpath("//button[text()='Back']")).click();

			Thread.sleep(7000);

			validation=ProductBasketAction.validateProductBasketScreen(logStream, driver, stepID);

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
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
	public static void backToProductBasketPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Order Enrichment: Navigate back to Product Basket";

		String stepNameMin="backToProductBasket";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			driver.switchTo().defaultContent();

			String OE_URL = driver.getCurrentUrl();

			if(OE_URL.contains("one")) {
				OrderEnrichmentAction.changeToOrderEnrichmentiFrame(logStream, driver, stepID);
			}
			
			driver.findElement(By.xpath("//button[text()='Back']")).click();

			Thread.sleep(7000);
			
			driver.switchTo().defaultContent();
			
			ProductBasketPCAction.changeToProductBasketiframePC(logStream, stepID, driver);

			validation=ProductBasketPCAction.validateProductBasketScreen(logStream, stepID, driver);

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
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
}