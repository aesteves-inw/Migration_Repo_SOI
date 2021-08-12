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
import orderDirectSales.OrderStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4411 {

	public static void SOI_4411_TC01_DS_OCK_NoFiber_OKBUT_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC02_DS_OCK_NoFiber_NOK_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC03_DS_OCK_NoFiber_OKBUT_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC04_DS_OCK_NoFiber_NOK_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC05_DS_OCK_NoFiber_OKBUT_Internet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Professional Internet";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC06_DS_OCK_NoFiber_NOK_Internet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Professional Internet";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC07_DS_OCK_NoFiber_OKBUT_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC08_DS_OCK_NoFiber_NOK_EnterpriseVoice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Enterprise Voice";

		String userProfile = "salesUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC09_PC_OCK_NoFiber_OKBUT_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC10_PC_OCK_NoFiber_NOK_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC11_PC_OCK_NoFiber_OKBUT_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC12_PC_OCK_NoFiber_NOK_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC13_PC_OCK_NoFiber_OKBUT_Internet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Professional Internet";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC14_PC_OCK_NoFiber_NOK_Internet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Professional Internet";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC15_PC_OCK_NoFiber_OKBUT_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String userProfile = "farmerUser";

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Rue de Montigny,130, Charleroi, 6000, Belgium");

			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_4411_TC16_PC_OCK_NoFiber_NOK_EnterpriseVoice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
		String productName = "Enterprise Voice";
	
		String userProfile = "farmerUser";

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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);
	
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName,
					"Drabstraat,63, Mortsel, 2640, Belgium");
	
			EProdConfigStep.validateAccessTechnologyNotContainsOption(testExecStructure, logStream, driver, testName,
					"FIBER");
	
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	
	}

}
