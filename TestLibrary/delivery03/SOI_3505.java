package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import fetchDataFromExcelFiles.ExcelDataFetch;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketStep;
import productsDirectSales.ProductsStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3505 
{

	public static void SOI_3505_TC01_DS_SyncProcessForNonQuotableProducts(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String optyURL;
		
		String productName= ExcelDataFetch.searchDT(10, "productPABX");
		
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
						
			OpportunityStep.goToProductsRelatedView(testExecStructure, logStream, driver, testName, optyURL);
			
			ProductsStep.opportunitySyncedWithBasket(testExecStructure, logStream, driver, testName, productName);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

	public static void SOI_3505_TC02_DS_SyncProcessForNonQuotableProducts_NonQuotable_Quo_StandAlone(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";
		
		String[] productsList= {productName2, productName};
		
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			String optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			D02Models.SyncProductBasketWithSalesforceValidation(testExecStructure, logStream, driver, testName, optyURL, productsList);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

	public static void SOI_3505_TC04_DS_SyncProcessForNonQuotableProducts_BasketSynched_AddNonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";
		
		String[] productsList= {productName2, productName};
		
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			String optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			D02Models.SyncProductBasketWithSalesforceValidation(testExecStructure, logStream, driver, testName, optyURL, productsList);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

	public static void SOI_3505_TC05_DS_SyncProcessForNonQuotableProducts_BasketSynched_AddQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, String testName,
			WebDriver driver) throws Exception 
	{
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";
		
		String[] productsList= {productName2, productName};
		
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			String optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			D02Models.SyncProductBasketWithSalesforceValidation(testExecStructure, logStream, driver, testName, optyURL, productsList);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

	
	
	public static void SOI_3505_TC10_PC_SyncProcessForNonQuotableProducts_BasketSynched_AddQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, String testName,
			WebDriver driver) 
	{
		
		
	}

}
