package simpleQuoting;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import productBasketDirectSales.ProductBasketStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class J1835004000_18 {

	public static void J1835004000_18_TC02_Add_EnterpriseVoice_To_ProductBasket_DeleteProduct_InvalidConfig(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Voice";
		
		try
		{
			int newStepCounter;
			
			J1835004000_18_TC01_Add_EnterpriseVoice_To_ProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.deletePBLineItem(testExecStructure, logStream, driver, testName, newStepCounter, productName);
            
            
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

	public static void J1835004000_18_TC01_Add_EnterpriseVoice_To_ProductBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			
			
			J1835004000_14.J1835004000_14_TC01_Quick_Sale_Opportunity_CreateProdBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
						
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, "Enterprise Voice");
            
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

}
