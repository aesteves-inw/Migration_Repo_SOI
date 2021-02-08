package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3601 {
	
	public static void SOI_3601_TC01_DS_CopyBA_ProductBasket2Service(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{

		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Enterprise Voice";

		try
		{
			
			
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

}
