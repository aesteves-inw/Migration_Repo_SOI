package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import fetchDataFromExcelFiles.ExcelDataFetch;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3566 {

	public static void SOI_3566_TC01_DS_ProductModellingSingleProducts(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, String testName, WebDriver driver) throws Exception 
	{
		String productName= ExcelDataFetch.searchDT(10, "productPABX");
		
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
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

	public static void SOI_3566_TC02_PC_ProductModellingSingleProducts(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, String testName, WebDriver driver) throws Exception 
	{
		String productName= ExcelDataFetch.searchDT(10, "productPABX");
		
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
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

}
