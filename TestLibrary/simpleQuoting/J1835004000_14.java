package simpleQuoting;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketAction;
import productBasketDirectSales.ProductBasketStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class J1835004000_14 {

	public static void J1835004000_14_TC01_Quick_Sale_Opportunity_CreateProdBasket(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception
	{
		try
		{
			
			J1835004000_64.J1835004000_64_TC02_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
	}
	
	public static void J1835004000_14_TC02_QuickSaleOpportunity_CreateMoreThanOneProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception {
		
		try
		{
			int newStepCounter;
			
			J1835004000_64.J1835004000_64_TC02_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			String optyURL=driver.getCurrentUrl();
			
			newStepCounter++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, newStepCounter);
			
			newStepCounter++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			newStepCounter++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, newStepCounter);
			
			newStepCounter++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			newStepCounter++;
			
			OpportunityStep.relatedProductBasketsValidation(testExecStructure, logStream, driver, newStepCounter, testName);
			
			
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}
	
	public static void J1835004000_14_TC03_StandardOpportunity_CreateProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productFamily ="Fix Voice";
		
		try
		{
			stepsExecuted++;

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			stepsExecuted++;

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			stepsExecuted++;
			
			//22-03-2021 - Changes about opportunity creation.
			//CompanyStep.createStandardOpportunityForD02(testExecStructure, logStream, driver, stepsExecuted, testName);
			CompanyStep.createNewQuickOpportunity(testExecStructure, logStream, driver, testName, productFamily);
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			
			
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
		
	}

	public static void J1835004000_14_TC04_StandardOpportunity_CreateMoreThanOneProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productFamily ="Fix Voice";
		
		try
		{
			stepsExecuted++;

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			stepsExecuted++;

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			stepsExecuted++;
			
			//22-03-2021 - Changes about opportunity creation.
			//CompanyStep.createStandardOpportunityForD02(testExecStructure, logStream, driver, stepsExecuted, testName);
			CompanyStep.createNewQuickOpportunity(testExecStructure, logStream, driver, testName, productFamily);
			
			String optyURL=driver.getCurrentUrl();
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
				
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepsExecuted);
			
			stepsExecuted++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepsExecuted);
			
			stepsExecuted++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			stepsExecuted++;
			
			OpportunityStep.relatedProductBasketsValidation(testExecStructure, logStream, driver, stepsExecuted, testName);
		}
		catch(Exception e)
		{
			//System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
		
		
		
	}

	public static void J1835004000_14_TC05_QuickSaleOpportunity_EditOpportunity_NoProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			J1835004000_64.J1835004000_64_TC02_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			OpportunityStep.goToEditOpportunityScreen(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			OpportunityStep.editOpportunityNameNegVal(testExecStructure, logStream, driver, testName, stepsExecuted);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}

	public static void J1835004000_14_TC06_QuickSaleOpportunity_EditOpportunity_WithProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		String productName = "Voice Continuity";
		
		String configurationIndex="configurationByDefault";
		
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			String optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+": Test Case Failed");
		}
		
	}

	

	
	
}
