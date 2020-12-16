package delivery02;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_2205 
{

	public static void SOI_2205_TC01_DS_ECS_Offerings_ECS_Pro_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, newStepCounter, testName, "Enterprise Call & Surf Pro with Enterprise Voice");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

	public static void SOI_2205_TC02_DS_ECS_Offerings_ECS_Pro_PhoneLine(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, newStepCounter, testName, "Enterprise Call & Surf Pro with Phone Line");
            
           
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
	}

	
	public static void SOI_2205_TC03_DS_ECS_Offerings_ECS_ProPlus_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, newStepCounter, testName, "Enterprise Call & Surf Pro+ with Enterprise Voice");
            
           
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
	}


	public static void SOI_2205_TC04_DS_ECS_Offerings_ECS_ProPlus_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, newStepCounter, testName, "Enterprise Call & Surf Pro+ with Phone Line");
            
           
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
	}


	public static void SOI_2205_TC05_DS_ECS_Offerings_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, newStepCounter, testName, "Enterprise Call & Surf FullFiber");
            
           
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
	}

	
	public static void SOI_2205_TC06_DS_ECS_Offerings_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			int newStepCounter;
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, newStepCounter, testName);
			
			newStepCounter++;
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, newStepCounter, testName, "Enterprise Call & Surf FullFiber Extended");
            
           
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}
	
}
