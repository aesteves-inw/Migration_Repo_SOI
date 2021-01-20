package testFrameworkLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
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

	public static void ToHaveAProductBasketInPC(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String user="farmerUser";
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);
			
			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - PartnersCommunity");
		}
	}

	
	// Stand-Alone Products: Product Configuration - PI/PL/EV/VC
	public static void ConfigureVoiceContinuity(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String configurationIndex) throws Exception
	{
		String productName="Voice Continuity";
		
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
	
	public static void ConfigurePhoneLine(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String configurationIndex) throws Exception
	{
		String productName="Phone Line";
		
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
	
	public static void ConfigureProfessionalInternet(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String configurationIndex) throws Exception
	{
		String productName="Professional Internet";
		
		try
		{
			ProductInProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
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
	
	
	
	//General Product Adding and Configuration to Product Basket
	public static void ConfigureStandAloneProduct(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
				
		try
		{
			ProductInProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			switch(productName)
			{
			case "Voice Continuity":
				EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				break;
			case "Phone Line":
				EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				break;
			case "Professional Internet":
				EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				break;
			default:
				throw new Exception("Product Invalid in Test Data File");
			}
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - ProductConfiguration with "+productName);
		}
	}

	public static void AddAndConfigureNewProduct(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
		try
		{			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			switch(productName)
			{
			case "Voice Continuity":
				EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				break;
			case "Phone Line":
				EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				break;
			case "Professional Internet":
				EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				break;
			default:
				throw new Exception("Product Invalid in Test Data File");
			}
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - AddAndConfigureNewProduct with "+productName);
		}
	}
	
	
	
	//Generic E2E Flow in D02
	public static void E2FFlowForD02(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception
	{
		try
		{
			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			String optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			String pbURL=driver.getCurrentUrl();
			System.out.println("Validation of pbURL :"+pbURL);
			
			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
			
			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			
			// 14/01 - Workaround for Opportunity Page Refresh after Close Won and before going to OrderScreen
			
			Thread.sleep(10000);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			// 14/01 - End Of Workaround for Opportunity Page Refresh after Close Won and before going to OrderScreen 
			
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - E2E Flow in D02 with "+productName);
		}
	}

	public static void ToDebugE2EFlow(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String userProfile="salesUser";
		
		String optyURL="https://proximus--prxitt.lightning.force.com/lightning/r/Opportunity/0063M000002XE5uQAG/view";
		
		String productBasketName="New Basket 2021-01-13 15:36:34";

		LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);
		
		NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
		
		OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
	}

}
