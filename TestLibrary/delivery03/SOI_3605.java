package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import orderDirectSales.OrderStep;
import orderEnrichmentDirectSales.OrderEnrichmentAction;
import orderEnrichmentDirectSales.OrderEnrichmentStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceNavigation;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCNavigation;
import servicePartCom.ServicePCStep;
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

			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productPhoneLine, configurationIndex);

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productInternet, configurationIndex);

			Thread.sleep(3000);

			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, productInternet);

			//OrderEnrichmentStep.changeProduct(testExecStructure, logStream, driver, testName, productPhoneLine);

			OrderEnrichmentStep.changeProduct(testExecStructure, logStream, driver, testName, productEnterpriseVoice);

			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, productEnterpriseVoice, "12345");

			//OrderEnrichmentStep.fillContactsFormEV(testExecStructure, logStream, driver, testName, productEnterpriseVoice, "First User");

			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.submitOrderNegativeVal(testExecStructure, logStream, driver, testName);

			/*OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productPhoneLine);

			ServiceStep.fillBillingAccountID(testExecStructure, logStream, driver, testName, "12345");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");*/

			//ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productEnterpriseVoice);

			ServiceStep.fillBillingAccountID(testExecStructure, logStream, driver, testName, "12345");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");

			ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productInternet);

			ServiceStep.fillBillingAccountID(testExecStructure, logStream, driver, testName, "12345");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");

			ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3605_TC02_PC_OrderEnrichment_No_BillingAccount_ContactPerson(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String userProfile="farmerUser";

		String productPhoneLine = "Phone Line";

		String productEnterpriseVoice="Enterprise Voice";

		String productInternet="Professional Internet";

		String configurationIndex="configurationByDefault";


		String optyURL;

		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productEnterpriseVoice, configurationIndex);

			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productPhoneLine, configurationIndex);

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productInternet, configurationIndex);

			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productInternet, configurationIndex);

			Thread.sleep(3000);

			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, productInternet);

			//OrderEnrichmentStep.changeProduct(testExecStructure, logStream, driver, testName, productPhoneLine);

			OrderEnrichmentStep.changeProduct(testExecStructure, logStream, driver, testName, productEnterpriseVoice);

			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, productEnterpriseVoice, "12345");

			//OrderEnrichmentStep.fillContactsFormEV(testExecStructure, logStream, driver, testName, productEnterpriseVoice, "First User");

			OrderEnrichmentStep.backToProductBasketPC(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			//NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.submitOrderNegativeValPC(testExecStructure, logStream, driver, testName);

			/*OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productPhoneLine);

			ServiceStep.fillBillingAccountID(testExecStructure, logStream, driver, testName, "12345");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");*/

			//ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productEnterpriseVoice);

			//ServiceStep.fillBillingAccountID(testExecStructure, logStream, driver, testName, "12345");

			ServicePCStep.fillBillingAccountID(testExecStructure, logStream, driver, testName);

			//ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");

			ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productInternet);

			//OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productInternet);

			//ServiceStep.fillBillingAccountID(testExecStructure, logStream, driver, testName, "12345");

			ServicePCStep.fillBillingAccountID(testExecStructure, logStream, driver, testName);

			//ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "First User");

			ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
