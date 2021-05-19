package delivery02;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_2206 
{

	public static void SOI_2206_TC01_DS_ECS_Offerings_ECS_Pro_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Call & Surf Pro with Enterprise Voice";
		
		try
		{
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
						
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

	public static void SOI_2206_TC02_DS_ECS_Offerings_ECS_Pro_PhoneLine(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Call & Surf Pro with Phone Line";
		
		try
		{
			
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
					
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}
	
	public static void SOI_2206_TC03_DS_ECS_Offerings_ECS_ProPlus_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Call & Surf Pro+ with Enterprise Voice";
		
		try
		{
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
						
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

	public static void SOI_2206_TC04_DS_ECS_Offerings_ECS_ProPlus_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Call & Surf Pro+ with Phone Line";
		
		try
		{
			
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
						
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

	public static void SOI_2206_TC05_DS_ECS_Offerings_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Call & Surf FullFiber";
		
		try
		{
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
						
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}
	
	public static void SOI_2206_TC06_DS_ECS_Offerings_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productName="Enterprise Call & Surf FullFiber Extended";
		
		try
		{
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Failed");
		}
		
	}

	public static void SOI_2206_TC08_PC_ECS_PackageContent_ECS_Pro_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String productName="Enterprise Call & Surf Pro with Enterprise Voice";
		
		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	public static void SOI_2206_TC09_PC_ECS_PackageContent_ECS_Pro_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String productName="Enterprise Call & Surf Pro with Phone Line";
		
		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	public static void SOI_2206_TC10_PC_ECS_PackageContent_ECS_ProPlus_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String productName="Enterprise Call & Surf Pro+ with Enterprise Voice";
		
		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	public static void SOI_2206_TC11_PC_ECS_PackageContent_ECS_ProPlus_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String productName="Enterprise Call & Surf Pro+ with Phone Line";
		
		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	public static void SOI_2206_TC12_PC_ECS_PackageContent_ECS_FullFiber(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String productName="Enterprise Call & Surf FullFiber";
		
		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	public static void SOI_2206_TC13_PC_ECS_PackageContent_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String productName="Enterprise Call & Surf FullFiber Extended";
		
		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	
}
