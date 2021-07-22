package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementNavigation;
import agreementDirectSales.AgreementStep;
import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import orderDirectSales.OrderStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceNavigation;
import serviceDirectSales.ServiceStep;
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

}
