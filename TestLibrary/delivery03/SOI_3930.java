package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementStep;
import agreementPartCom.AgreementPCStep;
import caseDirectSales.CaseNavigation;
import caseDirectSales.CaseStep;
import casePartCom.CasePCNavigation;
import casePartCom.CasePCStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import executionTools.BrowserActions;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesOrder;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCStep;
import testFrameworkLibrary.GeneralTestingFramework;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3930 {
	
	public static void SOI_3930_TC01_DS_D03PlaceHolders_ProductsToBeRemoved(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

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
			//end of variable storage

			ProductBasketStep.categorieValidatationStep(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3930_TC02_DS_D03PlaceHolders_Section_AdvTelcoSol(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Adv Telco Sol";
		
		List<String> listProductsName;
		
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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
			
			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "M2M KORE");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "M2M KORE", "Not applicable");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3930_TC03_DS_D03PlaceHolders_Section_AdvancedWorkplace(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Advanced Workplace";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Call Connect");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "PABX", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC04_DS_D03PlaceHolders_Section_ComputeStorage(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Compute & Storage";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Cloud vContainer");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Hosting (Shared)", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_3930_TC05_DS_D03PlaceHolders_Section_DNSWebhosting(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="DNS/Webhosting";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "DNS");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "DNS", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC06_DS_D03PlaceHolders_Section_ECS(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Enterprise Pack Together";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Enterprise Pack Together");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Enterprise Pack Together", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC07_DS_D03PlaceHolders_Section_IOT(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="IOT & Analytics";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Internet of Things");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Internet of Things", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC08_DS_D03PlaceHolders_Section_MassMarket(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Mass Market";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Bizz Call Connect");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Bizz Call Connect", "Not applicable");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC09_DS_D03PlaceHolders_Section_Mobile(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Mobile";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Mobile Prepaid");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Mobile Prepaid", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC10_DS_D03PlaceHolders_Section_NetwConnServ(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Netw Conn & Serv";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Explore");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Explore", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC11_DS_D03PlaceHolders_Section_NextGenComm(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Next Gen Comm";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Conversational Chatbot");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Conversational Chatbot", "New");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	
	
	public static void SOI_3930_TC12_DS_D03PlaceHolders_Section_Voice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String section="Voice";
		
		List<String> listProductsName;

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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
		
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
				
				ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "PRA over IAD30");
			
			CaseStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "PRA over IAD30", "Not applicable");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC13_PC_D03PlaceHolders_ProductsToBeRemoved(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;
		

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

			ProductBasketStep.categorieValidatationStep(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	
	public static void SOI_3930_TC14_PC_D03PlaceHolders_Section_AdvTelcoSol(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;
		
		String section="Adv Telco Sol";
		
		List<String> listProductsName;
		
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
			
			listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
			
			AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
			
			Thread.sleep(2000);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			for (String serviceName: listProductsName)
			{
				serviceName.trim();
				
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
				
				Thread.sleep(2000);

				OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
				
				ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
				
				ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			
			Thread.sleep(2000);
			
			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "M2M KORE");
			
			CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "M2M KORE", "Not applicable");

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
		
		public static void SOI_3930_TC15_PC_D03PlaceHolders_Section_AdvancedWorkplace(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Advanced Workplace";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Call Connect");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "PABX", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		public static void SOI_3930_TC16_PC_D03PlaceHolders_Section_ComputeStorage(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Compute & Storage";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Cloud vContainer");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Hosting (Shared)", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		public static void SOI_3930_TC17_PC_D03PlaceHolders_Section_DNSWebhosting(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="DNS/Webhosting";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "DNS");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "DNS", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		public static void SOI_3930_TC18_PC_D03PlaceHolders_Section_ECS(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Enterprise Pack Together";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Enterprise Pack Together");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Enterprise Pack Together", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		public static void SOI_3930_TC19_PC_D03PlaceHolders_Section_IOT(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="IOT & Analytics";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Internet of Things");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Internet of Things", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		public static void SOI_3930_TC20_PC_D03PlaceHolders_Section_MassMarket(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Mass Market";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Bizz Call Connect");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Bizz Call Connect", "Not applicable");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		public static void SOI_3930_TC21_PC_D03PlaceHolders_Section_Mobile(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Mobile";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Mobile Prepaid");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Mobile Prepaid", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		public static void SOI_3930_TC22_PC_D03PlaceHolders_Section_NetwConnServ(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Netw Conn & Serv";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Explore");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Explore", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}

		}
		
		
		
		
		public static void SOI_3930_TC23_PC_D03PlaceHolders_Section_NextGenComm(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
		{

			String userProfile="farmerUser";

			String optyURL;

			String productBasketName;
			
			String section="Next Gen Comm";
			
			List<String> listProductsName;

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
				
				listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
				
				AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
				
				Thread.sleep(2000);
				
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
				
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

				for (String serviceName: listProductsName)
				{
					serviceName.trim();
					
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
					
					Thread.sleep(2000);

					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
					
					ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
					
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
				
				Thread.sleep(2000);
				
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Conversational Chatbot");
				
				CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "Conversational Chatbot", "New");

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}
		}
			
			public static void SOI_3930_TC24_PC_D03PlaceHolders_Section_Voice(List<TestStepReportStructure> testExecStructure,
					List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
			{

				String userProfile="farmerUser";

				String optyURL;

				String productBasketName;
				
				String section="Voice";
				
				List<String> listProductsName;

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
					
					listProductsName = GeneralTestingFramework.generateListWithAllProductsFromGivenSection(testExecStructure, logStream, driver, testName, section);
					
					AddOfferToBasketStep.addAllProductsFromSectionToBasket(testExecStructure, logStream, driver, testName, listProductsName);
					
					Thread.sleep(2000);
					
					ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
					
					ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName, "First User");
					
					ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

					ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

					AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

					NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);
					
					OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

					OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

					for (String serviceName: listProductsName)
					{
						serviceName.trim();
						
						TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: "+serviceName);
						
						Thread.sleep(2000);

						OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
						
						ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, null);
						
						ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
					}
					
					Thread.sleep(2000);
					
					OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
					
					CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Temporary ISDN");
					
					CasePCStep.validateOrderToCaseMAppingNonQuotable(testExecStructure, logStream, driver, testName, "PRA over IAD30", "Not applicable");

				}
				catch(Exception e)
				{
					System.out.println(e);
					TestLogger.logError(logStream, testName, "Test Failed", e.toString());
					throw new Exception(testName+" - Test Case Failed");
				}

		}

}
