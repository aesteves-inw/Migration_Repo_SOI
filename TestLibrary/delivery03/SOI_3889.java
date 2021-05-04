package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3889 {
	public static void SOI_3889_TC01_DS_OCK_Refactor_MaxVoiceChannels_EV(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Voice";

		String userProfile="salesUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidation(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC02_DS_OCK_Refactor_MaxVoiceChannels_ECS_Pro(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf Pro with Enterprise Voice";

		String userProfile="salesUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidation(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC03_DS_OCK_Refactor_MaxVoiceChannels_ECS_Pro_Plus(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf Pro+ with Enterprise Voice";

		String userProfile="salesUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidation(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC04_DS_OCK_Refactor_MaxVoiceChannels_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile="salesUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidation(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC05_DS_OCK_Refactor_MaxVoiceChannels_ECS_FullFiberExtended(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile="salesUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidation(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC06_PC_OCK_Refactor_MaxVoiceChannels_EV(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Voice";

		String userProfile="farmerUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidationPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC07_PC_OCK_Refactor_MaxVoiceChannels_ECS_Pro(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf Pro with Enterprise Voice";

		String userProfile="farmerUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidationPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC08_PC_OCK_Refactor_MaxVoiceChannels_ECS_Pro_Plus(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf Pro+ with Enterprise Voice";

		String userProfile="farmerUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidationPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC09_PC_OCK_Refactor_MaxVoiceChannels_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile="farmerUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidationPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3889_TC10_PC_OCK_Refactor_MaxVoiceChannels_ECS_FullFiberExtended(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile="farmerUser";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;
		
		String configurationIndex="configurationByDefault";


		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.maxVoiceChannelsOCKValidationPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
