package delivery02;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketStep;
import productsDirectSales.ProductsStep;
import simpleQuoting.J1835004000_14;
import simpleQuoting.J1835004000_18;
import testFrameworkLibrary.D02Models;
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
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}


	public static void SOI_1013_TC01_DS_Sync_ProductBasket_CloudSense(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, int stepsExecuted, String testName) throws Exception 
	{
		String configurationIndex="configurationByDefault";
		
		String productName ="Voice Continuity";
		
		try
		{
			
			
			D02Models.ConfigureStandAloneProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}


	public static void SOI_1013_TC06_DS_Sync_ProductBasket_SalesForce(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String configurationIndex="configurationByDefault";
		
		String productName1 ="Voice Continuity";
		
		String optyURL;
		
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName1, configurationIndex);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.goToProductsRelatedView(testExecStructure, logStream, driver, testName, optyURL);
			
			ProductsStep.opportunitySyncedWithBasket(testExecStructure, logStream, driver, testName, productName1);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}
}


