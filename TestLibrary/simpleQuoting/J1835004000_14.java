package simpleQuoting;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketAction;
import testLogBuilder.TestLog;
import testReportComposition.TestStepReportStructure;

public class J1835004000_14 {

	public static void SQ_J1835004000_14_Quick_Sale_Opportunity_CreateProdBasket(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, int stepsExecuted) throws Exception
	{
		try
		{
			int newStepCounter;
			
			J1835004000_64.SQ_J1835004000_64_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			newStepCounter++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, newStepCounter, testName);
			
			
		}
		catch(Exception e)
		{
			throw new Exception("SQ_J1835004000_14_Quick_Sale_Opportunity_CreateProdBasket - Test Case Failed");
		}
	}
	
	public static void SQ_J1835004000_14_QuickSaleOpportunity_CreateMoreThanOneProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception {
		
		try
		{
			int newStepCounter;
			
			J1835004000_64.SQ_J1835004000_64_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			newStepCounter = testExecStructure.size();
			
			String optyURL=driver.getCurrentUrl();
			
			newStepCounter++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, newStepCounter, testName);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, newStepCounter);
			
			newStepCounter++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, newStepCounter, testName, optyURL);
			
			newStepCounter++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, newStepCounter, testName);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, newStepCounter);
			
			newStepCounter++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, newStepCounter, testName, optyURL);
			
			newStepCounter++;
			
			OpportunityStep.relatedProductBasketsValidation(testExecStructure, logStream, driver, newStepCounter, testName);
			
			
		}
		catch(Exception e)
		{
			throw new Exception("SQ_J1835004000_14_QuickSaleOpportunity_CreateMoreThanOneProdBasket - Test Case Failed");
		}
		
	}
	
	public static void J1835004000_14_TC03_StandardOpportunity_CreateProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			stepsExecuted++;

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, stepsExecuted, userProfile);

			stepsExecuted++;

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName, stepsExecuted);

			stepsExecuted++;
			
			CompanyStep.createStandardOpportunityForD02(testExecStructure, logStream, driver, stepsExecuted, testName);
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, stepsExecuted, testName);
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("J1835004000_14_TC03_StandardOpportunity_CreateProdBasket - Test Case Failed");
		}
		
		
	}

	public static void J1835004000_14_TC04_StandardOpportunity_CreateMoreThanOneProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			stepsExecuted++;

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, stepsExecuted, userProfile);

			stepsExecuted++;

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName, stepsExecuted);

			stepsExecuted++;
			
			CompanyStep.createStandardOpportunityForD02(testExecStructure, logStream, driver, stepsExecuted, testName);
			
			String optyURL=driver.getCurrentUrl();
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, stepsExecuted, testName);
				
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepsExecuted);
			
			stepsExecuted++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, stepsExecuted, testName, optyURL);
			
			stepsExecuted++;
			
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, stepsExecuted, testName);
			
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepsExecuted);
			
			stepsExecuted++;
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, stepsExecuted, testName, optyURL);
			
			stepsExecuted++;
			
			OpportunityStep.relatedProductBasketsValidation(testExecStructure, logStream, driver, stepsExecuted, testName);
		}
		catch(Exception e)
		{
			throw new Exception("J1835004000_14_TC04_StandardOpportunity_CreateMoreThanOneProdBasket - Test Case Failed");
		}
		
		
		
		
	}

	
	public static void J1835004000_14_TC05_QuickSaleOpportunity_EditOpportunity_NoProdBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			int stepsExecuted) throws Exception 
	{
		try
		{
			J1835004000_64.SQ_J1835004000_64_QuickSaleOpportunity_OpportunityCreation(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			OpportunityStep.goToEditOpportunityScreen(testExecStructure, logStream, driver, testName, stepsExecuted);
			
			OpportunityStep.editOpportunityNameNegVal(testExecStructure, logStream, driver, testName, stepsExecuted);
			
		}
		catch(Exception e)
		{
			throw new Exception("J1835004000_14_TC05_QuickSaleOpportunity_EditOpportunity_NoProdBasket - Test Failed");
		}
		
	}

	
	
}
