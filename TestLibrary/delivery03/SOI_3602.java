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
import orderDirectSales.OrderAction;
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceAction;
import serviceDirectSales.ServiceNavigation;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCAction;
import servicePartCom.ServicePCStep;
import testDataFiles.TestDataFiles;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3602 {
	public static void SOI_3602_TC01_DS_NewBillingAccount_ServiceLevel_Positive(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="salesUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, product);

			ServiceStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productName);

			ServiceStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC02_DS_NewBillingAccount_ServiceLevel_Positive_FilledProductBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="salesUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			Thread.sleep(3000);

			ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, "SOI Execution");

			ProductBasketStep.fillNewBillingAccountAddress(testExecStructure, logStream, driver, testName, "Random Address");

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, product);

			ServiceStep.validateProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.validateNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productName);

			ServiceStep.validateProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.validateNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC03_DS_NewBillingAccount_ServiceLevel_Negative_NewExisting(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="salesUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, product);

			ServiceStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceStep.fillBillingAccountIDNegative(testExecStructure, logStream, driver, testName, "12345");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productName);

			ServiceStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceStep.fillBillingAccountIDNegative(testExecStructure, logStream, driver, testName, "12345");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.submitOrderNegativeVal(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC04_DS_NewBillingAccount_ServiceLevel_Negative_Empty(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="salesUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, product);

			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productName);

			ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			OrderStep.submitOrderNegativeVal(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC05_PC_NewBillingAccount_ServiceLevel_Positive(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="farmerUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, product);

			ServicePCStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productName);

			ServicePCStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC06_PC_NewBillingAccount_ServiceLevel_Positive_FilledProductBasket(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="farmerUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			//ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, "SOI Execution");

			ProductBasketStep.fillNewBillingAccountAddress(testExecStructure, logStream, driver, testName, "Random Address");

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, product);

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.validateProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.validateNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productName);

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.validateProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServiceStep.validateNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC07_PC_NewBillingAccount_ServiceLevel_Negative_NewExisting(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="farmerUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, product);

			ServicePCStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServicePCStep.fillBillingAccountIDNegativePC(testExecStructure, logStream, driver, testName, "12345");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productName);

			ServicePCStep.fillNewBillingAccount(testExecStructure, logStream, driver, testName, "Random Address");

			ServicePCStep.fillBillingAccountIDNegativePC(testExecStructure, logStream, driver, testName, "12345");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.submitOrderNegativeValPC(testExecStructure, logStream, driver, testName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3602_TC08_PC_NewBillingAccount_ServiceLevel_Negative_Empty(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String product = "PABX";

		String userProfile="farmerUser";

		String productName="Phone Line";

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

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, product);

			ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productName);

			ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, "SOI Execution");

			ServicePCAction.navigateToOrderPC(testExecStructure, logStream, driver, testName, productBasketName);

			OrderPCStep.submitOrderNegativeValPC(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}


}
