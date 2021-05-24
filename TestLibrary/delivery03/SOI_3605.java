package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import orderDirectSales.OrderStep;
import orderEnrichmentDirectSales.OrderEnrichmentAction;
import orderEnrichmentDirectSales.OrderEnrichmentStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceNavigation;
import serviceDirectSales.ServiceStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3605 {
	public static void SOI_3605_TC01_DS_OrderEnrichment_No_BillingAccount_ContactPerson(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String userProfile="salesUser";
		
		String productPhoneLine = "Phone Line";

		String productEnterpriseVoice="Enterprise Voice";
		
		String productInternet="Professional Internet";

		String configurationIndex="configurationByDefault";


		String optyURL;

		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productEnterpriseVoice, configurationIndex);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productPhoneLine, configurationIndex);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productInternet, configurationIndex);
			
			

			Thread.sleep(3000);
			
			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, productInternet);
			
			OrderEnrichmentStep.changeProduct(testExecStructure, logStream, driver, testName, productPhoneLine);
			
			OrderEnrichmentStep.changeProduct(testExecStructure, logStream, driver, testName, productEnterpriseVoice);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
