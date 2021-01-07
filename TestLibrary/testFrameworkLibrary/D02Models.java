package testFrameworkLibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class D02Models 
{
	// Product Basket Level	
	public static void ToHaveAProductBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName
			) throws Exception {

		try
		{

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - ToHaveAProductBasket");
		}
	}

	public static void ProductInProductBasket(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		try
		{
			ToHaveAProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - ProductConfiguration with "+productName);
		}
	}

	
	// Stand-Alone Products: Product Configuration - PI/PL/EV/VC
	public static void ConfigureVoiceContinuity(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
		
		try
		{
			ProductInProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - ProductConfiguration with "+productName);
		}
	}
	
	public static void ConfigurePhoneLine(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
		
		try
		{
			ProductInProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - ProductConfiguration with "+productName);
		}
	}


	
	// ECS Products: Product Configuration

}
