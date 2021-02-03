package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import fetchDataFromExcelFiles.ExcelDataFetch;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import productBasketDirectSales.ProductBasketStep;
import productBasketPartCom.ProductBasketPCStep;
import productsDirectSales.ProductsStep;
import productsPartCom.ProductsPCStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
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

	public static void SOI_3505_TC06_PC_SyncProcessForNonQuotableProducts(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String product="PABX";
		
		String user = "farmerUser";
		
		String[] productList= {product};
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);
			
			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			String optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);
            
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketPCStep.goToOPTYSreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.goToProductsRelatedViewList(testExecStructure, logStream, driver, testName, optyURL);
			
			ProductsPCStep.productValidationAfterSyncProcess(testExecStructure, logStream, driver, testName, productList);
            
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}
	
	public static void SOI_3505_TC07_PC_SyncProcessForNonQuotableProducts_NonQuotable_Quo_StandAlone(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String user = "farmerUser";
		
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";
		
		String[] productsList= {productName2, productName};
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);
			
			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			String optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketPCStep.goToOPTYSreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.goToProductsRelatedViewList(testExecStructure, logStream, driver, testName, optyURL);
			
			ProductsPCStep.productValidationAfterSyncProcess(testExecStructure, logStream, driver, testName, productsList);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}
	
	public static void SOI_3505_TC09_PC_SyncProcessForNonQuotableProducts_BasketSynched_AddNonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String user = "farmerUser";
		
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";
		
		String[] productsList= {productName2, productName};
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);
			
			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			String optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketPCStep.goToOPTYSreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.goToProductsRelatedViewList(testExecStructure, logStream, driver, testName, optyURL);
			
			ProductsPCStep.productValidationAfterSyncProcess(testExecStructure, logStream, driver, testName, productsList);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}	
	}
	
	
	public static void SOI_3505_TC10_PC_SyncProcessForNonQuotableProducts_BasketSynched_AddQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
String user = "farmerUser";
		
		String productName ="PABX";

		String configurationIndex2="configurationByDefault";

		String productName2 ="Voice Continuity";
		
		String[] productsList= {productName2, productName};
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);
			
			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			String optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName2, configurationIndex2);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketPCStep.goToOPTYSreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.goToProductsRelatedViewList(testExecStructure, logStream, driver, testName, optyURL);
			
			ProductsPCStep.productValidationAfterSyncProcess(testExecStructure, logStream, driver, testName, productsList);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": - Test Case Failed");
		}
		
	}

	

	
	



}
