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
import navigation.NavigationStep;
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

public class SOI_4025 {

	public static void SOI_4025_TC01_DS_SRD_Field_StandaloneProducts(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> listProductsName = Arrays.asList("Professional Internet", "Phone Line", "Voice Continuity",
				"Enterprise Voice");

		List<String> listServiceName = Arrays.asList("Professional Internet - Internet Pro", "Phone Line",
				"Voice Continuity 1", "Enterprise Voice - Standard");

		String optyURL, productBasketName;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			String validSRDProdBasketFormat = dates.get(1);

			String validSRDServiceFormat = dates.get(2);

			// The Request Installation Date to the product configuration is stored on excel
			// testData.xlsx and the default value
			// for all configurations is currently the today date + 1 day (tomorrow). The
			// String requestInstallationDateServiceFormat is currently set for tomorrow
			// date on this test.
			String requestInstallationDateServiceFormat = dates.get(3);

			String validSRDServiceFromProdConfig = dates.get(4);

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

			for (String productName : listProductsName) {

				ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

				Thread.sleep(2000);

				AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName,
						productName);

				ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
						productName);

				// EProdConfigStep.selectAddress(testExecStructure, logStream, driver,
				// testName,address);

				switch (productName) {
				case "Professional Internet":

					EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				case "Phone Line":

					EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName,
							configurationIndex);
					break;

				case "Voice Continuity":

					EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				case "Enterprise Voice":

					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				default:
					break;
				}

				EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			}

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			Thread.sleep(3000);

			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName : listServiceName) {

				serviceName.trim();

				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);

				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);

				ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver,
						testName, validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);

				String serviceURL = driver.getCurrentUrl();

				driver.navigate().to(serviceURL);

				Thread.sleep(3000);

				ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
						validSRDServiceFormat);

			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC02_DS_SRD_Field_ECS_FullFiberExtended(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String productName = "Enterprise Call & Surf FullFiber Extended";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL, productBasketName;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			String validSRDProdBasketFormat = dates.get(1);

			String validSRDServiceFormat = dates.get(2);

			String requestInstallationDateServiceFormat = dates.get(3);

			String validSRDServiceFromProdConfig = dates.get(4);

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			Thread.sleep(2000);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber Extended");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultInternetFiber");

			// EProdConfigStep.selectAddress(testExecStructure, logStream,
			// driver,testName,address);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultBusinessContinuity_Extended");
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName,
					"Pack Enterprise Call & Surf with FullFiber Extended / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "FullFiber Extended");

			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);

			String serviceURL = driver.getCurrentUrl();

			driver.navigate().to(serviceURL);

			Thread.sleep(3000);

			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);

		} catch (

		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC03_DS_SRD_Field_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String productName = "Enterprise Call & Surf FullFiber";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL, productBasketName;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			String validSRDProdBasketFormat = dates.get(1);

			String validSRDServiceFormat = dates.get(2);

			String requestInstallationDateServiceFormat = dates.get(3);

			String validSRDServiceFromProdConfig = dates.get(4);

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			Thread.sleep(2000);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");

			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultInternetFiber");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Enterprise Voice - Converged");

			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultEnterpriseVoice");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Business Continuity");

			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultBusinessContinuity_Normal");

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			Thread.sleep(3000);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName,
					"Pack Enterprise Call & Surf with FullFiber / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "FullFiber");

			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);

			String serviceURL = driver.getCurrentUrl();

			driver.navigate().to(serviceURL);

			Thread.sleep(3000);

			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);

		} catch (

		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC04_DS_SRD_Field_ECS_ProPlus(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName ="Enterprise Call & Surf Pro+ with Enterprise Voice";
	
		String userProfile = "salesUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			String validSRDProdBasketFormat = dates.get(1);
	
			String validSRDServiceFormat = dates.get(2);
	
			String requestInstallationDateServiceFormat = dates.get(3);
	
			String validSRDServiceFromProdConfig = dates.get(4);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
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
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
	
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
	
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
	
			Thread.sleep(3000);
	
			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro+ / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Internet Pro+");
	
			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(3000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC05_DS_SRD_Field_ECS_Pro(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName ="Enterprise Call & Surf Pro with Enterprise Voice";
	
		String userProfile = "salesUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			String validSRDProdBasketFormat = dates.get(1);
	
			String validSRDServiceFormat = dates.get(2);

			String requestInstallationDateServiceFormat = dates.get(3);
	
			String validSRDServiceFromProdConfig = dates.get(4);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			Thread.sleep(4000);

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
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
	
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
	
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
	
			Thread.sleep(3000);
	
			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)");

			ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Internet Pro");
	
			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(3000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC06_DS_SRD_Field_NonQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName ="PABX";
	
		String userProfile = "salesUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
	
			String validSRDServiceFormat = dates.get(2);
	
			String validSRDServiceFromProdConfig = dates.get(4);
			
			String validReqInstallationDateProdBasket = dates.get(6);

	
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);
			
			Thread.sleep(3000);
	
			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);
	
			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
	
			optyURL = driver.getCurrentUrl();
	
			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
	
			// variable storage
			productBasketName = driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName))
					.getAttribute("value");
	
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: " + productBasketName);
			// end of variable storage
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
			
			Thread.sleep(3000);
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validReqInstallationDateProdBasket);
			
			Thread.sleep(3000);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
	
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
	
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
	
			Thread.sleep(3000);
	
			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, "PABX");
	
			Thread.sleep(5000);

			ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName, validSRDServiceFromProdConfig);
			
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(5000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC07_DS_SRD_Field_LessDate(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String productName = "Professional Internet";

		String serviceName = "Professional Internet - Internet Pro";

		String optyURL, productBasketName;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			String invalidSRDProdBasketFormat = dates.get(0);

			String requestInstallationDateServiceFormat = dates.get(3);

			String validSRDServiceFromProdConfig = dates.get(4);

			String invalidSRDService = dates.get(5);

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

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			Thread.sleep(2000);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			// EProdConfigStep.selectAddress(testExecStructure, logStream, driver,
			// testName,address);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			ProductBasketStep.fillServiceRequestDateNegVal(testExecStructure, logStream, driver, testName,
					invalidSRDProdBasketFormat);

			Thread.sleep(3000);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);

			Thread.sleep(2000);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);

			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);

			Thread.sleep(2000);

			ServiceStep.fillServiceRequestDateNegative(testExecStructure, logStream, driver, testName,
					invalidSRDService);

			Thread.sleep(2000);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC08_PC_SRD_Field_StandaloneProducts(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String configurationIndex = "configurationByDefault";

		String userProfile = "farmerUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> listProductsName = Arrays.asList("Professional Internet", "Phone Line", "Voice Continuity",
				"Enterprise Voice");

		List<String> listServiceName = Arrays.asList("Professional Internet - Internet Pro", "Phone Line",
				"Voice Continuity 1", "Enterprise Voice - Standard");

		String optyURL, productBasketName;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			String validSRDProdBasketFormat = dates.get(1);

			String validSRDServiceFormat = dates.get(2);

			String requestInstallationDateServiceFormat = dates.get(3);

			String validSRDServiceFromProdConfig = dates.get(4);

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

			for (String productName : listProductsName) {

				ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

				Thread.sleep(2000);

				AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName,
						productName);

				ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
						productName);

				// EProdConfigStep.selectAddress(testExecStructure, logStream, driver,
				// testName,address);

				switch (productName) {
				case "Professional Internet":

					EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				case "Phone Line":

					EProdConfigStep.configurePhoneLine(testExecStructure, logStream, driver, testName, productName,
							configurationIndex);
					break;

				case "Voice Continuity":

					EProdConfigStep.configureVoiceContinuity(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				case "Enterprise Voice":

					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				default:
					break;
				}

				EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			}

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName : listServiceName) {
				

				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);

				Thread.sleep(2000);

				OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);

				Thread.sleep(2000);

				ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver,
						testName, validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
				
				String serviceURL = driver.getCurrentUrl();

				driver.navigate().to(serviceURL);

				Thread.sleep(3000);

				ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
						validSRDServiceFormat);

				ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);

			}

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC09_PC_SRD_Field_ECS_FullFiberExtended(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName = "Enterprise Call & Surf FullFiber Extended";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			String validSRDProdBasketFormat = dates.get(1);
	
			String validSRDServiceFormat = dates.get(2);
	
			String requestInstallationDateServiceFormat = dates.get(3);
	
			String validSRDServiceFromProdConfig = dates.get(4);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber Extended");
	
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultInternetFiber");
	
			// EProdConfigStep.selectAddress(testExecStructure, logStream,
			// driver,testName,address);
	
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Enterprise Voice - Converged");
	
			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultEnterpriseVoice");
	
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Business Continuity");
	
			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultBusinessContinuity_Extended");
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName,
					"Pack Enterprise Call & Surf with FullFiber Extended / Enterprise Voice (16)");
	
			ServiceStep.navigateToInternetECS_PC(testExecStructure, logStream, driver, testName, "FullFiber Extended");
	
			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(3000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC10_PC_SRD_Field_ECS_FullFiber(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName = "Enterprise Call & Surf FullFiber";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			String validSRDProdBasketFormat = dates.get(1);
	
			String validSRDServiceFormat = dates.get(2);

			String requestInstallationDateServiceFormat = dates.get(3);
	
			String validSRDServiceFromProdConfig = dates.get(4);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "FullFiber");
	
			EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultInternetFiber");
	
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Enterprise Voice - Converged");
	
			EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultEnterpriseVoice");
	
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName,
					productName, "Business Continuity");
	
			EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName, productName,
					"configurationByDefaultBusinessContinuity_Normal");
	
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
			Thread.sleep(3000);
	
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName,
					"Pack Enterprise Call & Surf with FullFiber / Enterprise Voice (16)");
	
			ServiceStep.navigateToInternetECS_PC(testExecStructure, logStream, driver, testName, "FullFiber");
	
			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(3000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC11_PC_SRD_Field_ECS_ProPlus(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName ="Enterprise Call & Surf Pro+ with Enterprise Voice";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			String validSRDProdBasketFormat = dates.get(1);
	
			String validSRDServiceFormat = dates.get(2);
	
			String requestInstallationDateServiceFormat = dates.get(3);
	
			String validSRDServiceFromProdConfig = dates.get(4);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
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
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
	
			Thread.sleep(3000);
	
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro+ / Enterprise Voice (16)");
	
			ServiceStep.navigateToInternetECS_PC(testExecStructure, logStream, driver, testName, "Internet Pro+");
	
			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(3000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC12_PC_SRD_Field_ECS_Pro(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName ="Enterprise Call & Surf Pro with Enterprise Voice";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			String validSRDProdBasketFormat = dates.get(1);
	
			String validSRDServiceFormat = dates.get(2);
	
			String requestInstallationDateServiceFormat = dates.get(3);
	
			String validSRDServiceFromProdConfig = dates.get(4);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			Thread.sleep(4000);
	
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
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validSRDProdBasketFormat);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
			Thread.sleep(3000);
	
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)");
	
			ServiceStep.navigateToInternetECS_PC(testExecStructure, logStream, driver, testName, "Internet Pro");
	
			ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
					validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(3000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC13_PC_SRD_Field_NonQuotable(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String productName ="PABX";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
	
			String validSRDServiceFormat = dates.get(2);
	
			String validSRDServiceFromProdConfig = dates.get(4);
			
			String validReqInstallationDateProdBasket = dates.get(6);
	
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
	
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
			Thread.sleep(2000);
	
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
			
			Thread.sleep(3000);
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					validReqInstallationDateProdBasket);
			
			Thread.sleep(3000);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			Thread.sleep(3000);
	
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, "PABX");
	
			Thread.sleep(5000);
	
			ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName, validSRDServiceFromProdConfig);
			
			String serviceURL = driver.getCurrentUrl();
	
			driver.navigate().to(serviceURL);
	
			Thread.sleep(5000);
	
			ServiceStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, validSRDServiceFormat);
	
		} catch (
	
		Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4025_TC14_PC_SRD_Field_LessDate(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
			String configurationIndex = "configurationByDefault";
	
			String userProfile = "farmerUser";
	
			String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
			String productName = "Professional Internet";
	
			String serviceName = "Professional Internet - Internet Pro";
	
			String optyURL, productBasketName;
	
			try {
	
				List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
				String invalidSRDProdBasketFormat = dates.get(0);
	
				String requestInstallationDateServiceFormat = dates.get(3);
	
				String validSRDServiceFromProdConfig = dates.get(4);
	
				String invalidSRDService = dates.get(5);
				
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
	
				ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
	
				Thread.sleep(2000);
	
				AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
	
				ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
						productName);
	
				// EProdConfigStep.selectAddress(testExecStructure, logStream, driver,
				// testName,address);
	
				EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
						configurationIndex);
				
				EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
						"First User");
	
				ProductBasketStep.fillServiceRequestDateNegVal(testExecStructure, logStream, driver, testName,
						invalidSRDProdBasketFormat);
	
				Thread.sleep(3000);
	
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
				
				Thread.sleep(3000);
		
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);
	
				OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
	
				ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver, testName,
						validSRDServiceFromProdConfig, requestInstallationDateServiceFormat);
	
				Thread.sleep(2000);
	
				ServiceStep.fillServiceRequestDateNegative(testExecStructure, logStream, driver, testName,
						invalidSRDService);
	
				Thread.sleep(2000);
	
			} catch (Exception e) {
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName + " - Test Case Failed");
			}
		}
}
