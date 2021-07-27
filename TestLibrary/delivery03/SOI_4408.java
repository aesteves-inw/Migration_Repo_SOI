package delivery03;

import java.util.Arrays;
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
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4408 {
	
	public static void SOI_4408_TC01_DS_OCK_NewColumns_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

		String configurationIndex = "configurationByDefaultInternetFiber";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber Extended");
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC02_DS_OCK_NewColumns_ECS_FullFiber(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber";

		String configurationIndex = "configurationByDefaultInternetFiber";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber");
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC03_DS_OCK_NewColumns_ECS_InternetProPlus(
				List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
				throws Exception {
			String productName = "Enterprise Call & Surf Pro+ with Enterprise Voice";
	
			String configurationIndex = "configurationByDefaultInternetCopper";
	
			String userProfile = "salesUser";
	
			String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
			String optyURL;
	
			String productBasketName;
	
			try {
				LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);
	
				HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);
	
				CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
	
				optyURL = driver.getCurrentUrl();
	
				OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
	
				// variable storage
				productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
						.getAttribute("value");
	
				TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
				// end of variable storage
	
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
				
				ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
				
				AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
				
				ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
				
				EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
				
				EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
				
				EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
				
				EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
				
			} catch (Exception e) {
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName + " - Test Case Failed");
			}
		}

	
	public static void SOI_4408_TC04_DS_OCK_NewColumns_ECS_InternetPro(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf Pro with Enterprise Voice";

		String configurationIndex = "configurationByDefaultInternetCopper";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	
	public static void SOI_4408_TC05_DS_OCK_NewColumns_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}
	
	public static void SOI_4408_TC06_DS_OCK_NewColumns_Internet(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
//			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC07_DS_OCK_NewColumns_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Phone Line";

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
//			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC08_PC_OCK_NewColumns_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

		String configurationIndex = "configurationByDefaultInternetFiber";

		String userProfile = "farmerUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber Extended");
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	
	public static void SOI_4408_TC09_PC_OCK_NewColumns_ECS_FullFiber(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber";

		String configurationIndex = "configurationByDefaultInternetFiber";

		String userProfile = "farmerUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, productName, "FullFiber");
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC10_PC_OCK_NewColumns_ECS_InternetProPlus(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf Pro+ with Enterprise Voice";

		String configurationIndex = "configurationByDefaultInternetCopper";

		String userProfile = "farmerUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC11_PC_OCK_NewColumns_ECS_InternetPro(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf Pro with Enterprise Voice";

		String configurationIndex = "configurationByDefaultInternetCopper";

		String userProfile = "farmerUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL;

		String productBasketName;

		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
	
	public static void SOI_4408_TC12_PC_OCK_NewColumns_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";
	
		String configurationIndex = "configurationByDefault";
	
		String userProfile = "farmerUser";

	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL;
	
		String productBasketName;
	
		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
	
			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");
	
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	
	}

	public static void SOI_4408_TC13_PC_OCK_NewColumns_Internet(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";
	
		String configurationIndex = "configurationByDefault";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL;
	
		String productBasketName;
	
		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
	
			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");
	
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4408_TC14_PC_OCK_NewColumns_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Phone Line";
	
		String configurationIndex = "configurationByDefault";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL;
	
		String productBasketName;
	
		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
	
			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");
	
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyOptions(testExecStructure, logStream, driver, testName);
			
			EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

}
