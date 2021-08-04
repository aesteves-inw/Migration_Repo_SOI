package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementNavigation;
import agreementDirectSales.AgreementStep;
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
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCNavigation;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceNavigation;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCNavigation;
import servicePartCom.ServicePCStep;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4100 {

	public static void SOI_4100_DS_TC01_Service_ContractType_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf FullFiber Extended";

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;



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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber Extended");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetFiber");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Extended");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with FullFiber Extended / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "FullFiber Extended");


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_4100_DS_TC02_Service_ContractType_ECS_FullFiber(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf FullFiber";

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;



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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetFiber");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Normal");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with FullFiber Extended / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "FullFiber");


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_4100_DS_TC03_Service_ContractType_ECS_InternetProPlus(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf Pro+ with Enterprise Voice";

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;



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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Internet Pro+");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetCopper");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Extended");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro+ / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Internet Pro+");


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_4100_DS_TC04_Service_ContractType_ECS_InternetPro(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf Pro with Enterprise Voice";

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;



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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Internet Pro");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetCopper");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Normal");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Internet Pro");


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_4100_DS_TC05_Service_ContractType_StandAloneProducts(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productNamePhoneLine ="Phone Line";

		String productNameEnterpriseVoice ="Enterprise Voice";

		String productNameIntenet ="Professional Internet";

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;



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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productNameIntenet);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productNameIntenet);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productNameIntenet, "configurationByDefault");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productNameEnterpriseVoice);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productNameEnterpriseVoice);

			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productNameIntenet, "configurationByDefault");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productNamePhoneLine);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productNamePhoneLine);

			EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productNameIntenet, "configurationByDefault");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderStep.validateContractTypeColumn(testExecStructure, logStream, driver, testName, "Activation");


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_DS_TC06_Service_ContractType_NonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		
		String productName ="PABX";

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;



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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "PABX");
			
			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");
			
			ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			
			OrderStep.validateContractTypeColumn(testExecStructure, logStream, driver, testName, "Activation");



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_PC_TC07_Service_ContractType_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf FullFiber Extended";

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;



		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);


			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber Extended");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetFiber");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Extended");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with FullFiber Extended / Enterprise Voice (16)");
			
			ServicePCStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Activation");

			


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_PC_TC08_Service_ContractType_ECS_FullFiber(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf FullFiber";

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;



		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);


			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetFiber");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Normal");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with FullFiber / Enterprise Voice (16)");
			
			ServicePCStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Activation");

			


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_PC_TC09_Service_ContractType_ECS_InternetProPlus(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf Pro+ with Enterprise Voice";

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;



		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);


			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Internet Pro+");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetCopper");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Extended");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro+ / Enterprise Voice (16)");
			
			ServicePCStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Activation");

			


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_PC_TC10_Service_ContractType_ECS_InternetPro(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Enterprise Call & Surf Pro with Enterprise Voice";

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;



		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);


			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Internet Pro");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetCopper");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultBusinessContinuity_Normal");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)");
			
			ServicePCStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Activation");

			


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_PC_TC11_Service_ContractType_StandAloneProducts(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productNamePhoneLine ="Phone Line";

		String productNameEnterpriseVoice ="Enterprise Voice";

		String productNameIntenet ="Professional Internet";

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;



		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productNameIntenet);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productNameIntenet);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productNameIntenet, "configurationByDefault");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productNameEnterpriseVoice);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productNameEnterpriseVoice);

			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productNameIntenet, "configurationByDefault");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productNamePhoneLine);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productNamePhoneLine);

			EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productNameIntenet, "configurationByDefault");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.validateContractTypeColumnPC(testExecStructure, logStream, driver, testName, "Activation");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4100_PC_TC12_Service_ContractType_NonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		
		String productName ="PABX";

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;



		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToOpportunityScreenByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productName);
			
			ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, "New");
			
			ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			
			OrderPCStep.validateContractTypeColumnPC(testExecStructure, logStream, driver, testName, "Activation");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}


}
