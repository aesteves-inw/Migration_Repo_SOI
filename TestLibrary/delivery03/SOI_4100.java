package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketStep;
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

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;



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
			
			//ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			//ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber Extended");
			
			//ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "Enterprise Voice - Converged");
			
			//ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, ECS_InternetConfigHeader);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, "configurationByDefaultInternetFiber");
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
			
			/*EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, "Rue J Besme,20, Koekelberg, 1081, Belgium");
			
			EProdConfigStep.selectTechnologyNOK(testExecStructure, logStream, driver, testName);*/
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
