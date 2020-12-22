package delivery02;

import java.util.List;

import org.openqa.selenium.WebDriver;

import productBasketDirectSales.ProductBasketStep;
import simpleQuoting.J1835004000_14;
import simpleQuoting.J1835004000_18;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_1013 {

	public static void SOI_1013_TC03_DS_Sync_ProductBasket_EmptyProduct_NegativeTest(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			int stepsExecuted, String testName) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			J1835004000_14.J1835004000_14_TC01_Quick_Sale_Opportunity_CreateProdBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.syncProductBasketNegVal(testExecStructure, logStream, driver, newStepCounter, testName);
			
			
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
	}

	
	public static void SOI_1013_TC02_DS_Sync_ProductBasket_ProductNotValid_NegativeTest(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			int stepsExecuted, String testName) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			J1835004000_18.J1835004000_18_TC01_Add_EnterpriseVoice_To_ProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.syncProductBasketNegVal(testExecStructure, logStream, driver, newStepCounter, testName);
			
			
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}
}


