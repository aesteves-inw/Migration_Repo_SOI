package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3504 {

	public static void SOI_3504_TC01_DS_NonQuotableOffer_Standalone(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{

		String productName ="PABX";

		try
		{
			D02Models.ProductInProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenForD03(testExecStructure, logStream, driver, testName, productName);

			EProdConfigStep.validateD03ProductConfiguration(testExecStructure, logStream, driver, testName, productName);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}

	}

	public static void SOI_3504_TC02_DS_NonQuotableOffer_NonQuotableQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";

		try
		{
			
			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			//D02Models.ProductInProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}

	}
	
	public static void SOI_3504_TC03_PC_NonQuotableOffer_Standalone(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{

		String productName ="PABX";
		
		//String configurationIndex="productPABX";

		try
		{
			
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
            
			ProductBasketStep.goToEditProductConfigurationScreenForD03(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.validateD03ProductConfiguration(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.finsihConfigurationInPC(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}

	}
	
	public static void SOI_3504_TC04_PC_NonQuotableOffer_NonQuotableQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";

		try
		{
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}

	}

	
}
