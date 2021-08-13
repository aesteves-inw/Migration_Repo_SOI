package delivery03;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementStep;
import agreementPartCom.AgreementPCStep;
import caseDirectSales.CaseNavigation;
import caseDirectSales.CaseStep;
import casePartCom.CasePCNavigation;
import casePartCom.CasePCStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import executionTools.BrowserActions;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import orderDirectSales.OrderStep;
import orderEnrichmentDirectSales.OrderEnrichmentStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCStep;
import testFrameworkLibrary.GeneralTestingFramework;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4190 {

	public static void SOI_4190_TC01_DS_SRD_ProductConfiguration_D02(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> listProductsName = Arrays.asList("Professional Internet", "Enterprise Voice");

		List<String> listServiceName = Arrays.asList("Professional Internet - Internet Pro",
				"Enterprise Voice - Standard");

		String optyURL, productBasketName;

		String validSRDService = null;

		String requestInstallationDateService = null;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			// Dates for Professional Internet Product

			String requestInstallationDateOnProdConfig_PI = dates.get(7);

			String requestInstallationDateOnService_PI = dates.get(9);

			String serviceRequestDateOnService_PI = dates.get(8);

			// Dates for Enterprise Voice Product
			String requestInstallationDateOnProdConfig_EV = dates.get(6);

			String requestInstallationDateOnService_EV = dates.get(3);

			String serviceRequestDateOnService_EV = dates.get(4);

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

					EProdConfigStep.fillRequestInstallationDateField(testExecStructure, logStream, driver, testName,
							requestInstallationDateOnProdConfig_PI);
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

			Thread.sleep(5000);

			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");

			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice",
					"12345");

			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName : listServiceName) {

				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);

				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);

				switch (serviceName) {
				case "Professional Internet - Internet Pro":
					validSRDService = serviceRequestDateOnService_PI;
					requestInstallationDateService = requestInstallationDateOnService_PI;
					break;
				case "Enterprise Voice - Standard":
					validSRDService = serviceRequestDateOnService_EV;
					requestInstallationDateService = requestInstallationDateOnService_EV;
					break;
				default:
					break;
				}
//				System.out.println("validSRDService: " + validSRDService);
//				System.out.println("requestInstallationDateService: " + requestInstallationDateService);

				ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver,
						testName, validSRDService, requestInstallationDateService);

				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);

			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName,
					"Professional Internet - Internet Pro");

			CaseStep.validateServiceRequestDateFromOrderToCase(testExecStructure, logStream, driver, testName,
					requestInstallationDateOnProdConfig_EV);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4190_TC02_DS_SRD_ProductBasket_D02(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> listProductsName = Arrays.asList("Professional Internet", "Enterprise Voice");

		List<String> listServiceName = Arrays.asList("Professional Internet - Internet Pro",
				"Enterprise Voice - Standard");

		String optyURL, productBasketName;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			// Dates forSRD on Product Basket Level

			String serviceRequestDateOnProdBasket = dates.get(7);

			String requestInstallationDateOnService = dates.get(9);

			String serviceRequestDateOnService = dates.get(8);

			// ---------------------------

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

				case "Enterprise Voice":

					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;

				default:
					break;
				}

				EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
						"Requested Installation Date");

				EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			}

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);

			Thread.sleep(5000);

			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");

			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice",
					"12345");

			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			for (String serviceName : listServiceName) {

				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);

				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);

				ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
						serviceRequestDateOnService);

				ServiceStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);

			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName,
					"Professional Internet - Internet Pro");

			CaseStep.validateServiceRequestDateFromOrderToCase(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4190_TC03_DS_SRD_ProductBasket_ProductConfiguration_D02_D03(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> listProductsName = Arrays.asList("Enterprise Call & Surf Pro with Enterprise Voice",
				"Enterprise Voice", "PABX", "M2M KORE");

		List<String> listServiceName = Arrays.asList("Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)",
				"Enterprise Voice - Standard", "PABX", "M2M KORE");

		String optyURL, productBasketName, orderURL;

		try {

			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();

			// Dates for ECS Pro Pack
			String requestInstallationDateOnProdConfig_ECS = dates.get(7);

			String requestInstallationDateOnService_ECS = dates.get(9);

			String serviceRequestDateOnService_ECS = dates.get(8);

			// Dates for SRD on Product Basket Level

			String serviceRequestDateOnProdBasket = dates.get(6);

			String requestInstallationDateOnService = dates.get(3);

			String serviceRequestDateOnService = dates.get(4);
			// ---------------------------

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

				// EProdConfigStep.selectAddress(testExecStructure, logStream,
				// driver,testName,address);

				switch (productName) {
				case "Enterprise Call & Surf Pro with Enterprise Voice":

					ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);

					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Internet Pro");

					EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
							"configurationByDefaultInternetCopper");

					EProdConfigStep.fillRequestInstallationDateField(testExecStructure, logStream, driver, testName,
							requestInstallationDateOnProdConfig_ECS);

					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Enterprise Voice - Converged");

					EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, "configurationByDefaultEnterpriseVoice");

					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Business Continuity");

					EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName,
							productName, "configurationByDefaultBusinessContinuity_Normal");

					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
					break;

				case "Enterprise Voice":
					Thread.sleep(10000);

					ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
							productName);

					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);

					EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
							"Requested Installation Date");

					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
					break;

				default:
					break;
				}

			}

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");

			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);

			Thread.sleep(5000);

			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");

			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Converged",
					"12345");
			
			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Standard",
					"12345");

			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			orderURL = driver.getCurrentUrl();

			for (String serviceName : listServiceName) {

				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);

				Thread.sleep(2000);

				OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);

				if (serviceName.contains("Pack") == true) {

					ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
							serviceRequestDateOnService_ECS);

					ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Internet Pro");

					ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver,
							testName, serviceRequestDateOnService_ECS, requestInstallationDateOnService_ECS);

				} else if (serviceName.contains("PABX") || serviceName.contains("M2M KORE")) {

					ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
							serviceRequestDateOnService);

					ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");

				} else {

					ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
							serviceRequestDateOnService);
				}

				NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);
			}
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);

			CaseNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "PABX");

			CaseStep.validateServiceRequestDateFromOrderToCase(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4190_TC04_DS_SRD_NotFilled_D02(
				List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
				throws Exception {
	
			String configurationIndex = "configurationByDefault";
	
			String userProfile = "salesUser";
	
			String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
			List<String> listProductsName = Arrays.asList("Enterprise Call & Surf Pro with Enterprise Voice",
					"Enterprise Voice", "PABX", "M2M KORE");
	
			List<String> listServiceName = Arrays.asList("Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)",
					"Enterprise Voice - Standard", "PABX", "M2M KORE");
	
			String optyURL, productBasketName, orderURL;
	
	
			try {
	
				List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
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
	
					// EProdConfigStep.selectAddress(testExecStructure, logStream,
					// driver,testName,address);
	
					switch (productName) {
					case "Enterprise Call & Surf Pro with Enterprise Voice":
	
						ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
	
						ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
								testName, productName, "Internet Pro");
	
						EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
								"configurationByDefaultInternetCopper");
	
						EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
								"Requested Installation Date");
						
						EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
						ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
								testName, productName, "Enterprise Voice - Converged");
	
						EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName,
								productName, "configurationByDefaultEnterpriseVoice");
	
						EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
						ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
								testName, productName, "Business Continuity");
	
						EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName,
								productName, "configurationByDefaultBusinessContinuity_Normal");
	
						EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
						break;
	
					case "Enterprise Voice":
						Thread.sleep(10000);
	
						ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
								productName);
	
						EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
								productName, configurationIndex);
	
						EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
								"Requested Installation Date");
	
						EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
						break;
	
					default:
						break;
					}
	
				}
	
				ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
						"First User");
	
				Thread.sleep(5000);
	
				ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");
				
				OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Converged","12345");
				
				OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Standard","12345");
	
				OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
	
				AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);
	
				NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
	
				OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
	
				OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
	
				orderURL = driver.getCurrentUrl();
	
				for (String serviceName : listServiceName) {
	
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);
	
					Thread.sleep(2000);
	
					OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, serviceName);
	
					if (serviceName.contains("Pack") == true) {
	
						ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
						ServiceStep.navigateToInternetECS(testExecStructure, logStream, driver, testName, "Internet Pro");
	
						ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
					} else if (serviceName.contains("PABX") || serviceName.contains("M2M KORE")) {
	
						ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
						ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");
	
					} else {
	
						ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);

					}
	
					NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);
				}
				OrderStep.submitOrderNegativeVal(testExecStructure, logStream, driver, testName);
	
	
			} catch (Exception e) {
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName + " - Test Case Failed");
			}
		}

	public static void SOI_4190_TC05_PC_SRD_ProductConfiguration_D02(List<TestStepReportStructure> testExecStructure,
				List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
			String configurationIndex = "configurationByDefault";
	
			String userProfile = "farmerUser";
	
			String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
			List<String> listProductsName = Arrays.asList("Professional Internet", "Enterprise Voice");
	
			List<String> listServiceName = Arrays.asList("Professional Internet - Internet Pro",
					"Enterprise Voice - Standard");
	
			String optyURL, productBasketName;
	
			String validSRDService = null;
	
			String requestInstallationDateService = null;
	
			try {
	
				List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
				// Dates for Professional Internet Product
	
				String requestInstallationDateOnProdConfig_PI = dates.get(7);
	
				String requestInstallationDateOnService_PI = dates.get(9);
	
				String serviceRequestDateOnService_PI = dates.get(8);
	
				// Dates for Enterprise Voice Product
				String requestInstallationDateOnProdConfig_EV = dates.get(6);
	
				String requestInstallationDateOnService_EV = dates.get(3);
	
				String serviceRequestDateOnService_EV = dates.get(4);
	
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
	
						EProdConfigStep.fillRequestInstallationDateField(testExecStructure, logStream, driver, testName,
								requestInstallationDateOnProdConfig_PI);
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
	
				Thread.sleep(5000);
	
				ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");
	
				OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice",
						"12345");
	
				OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
	
				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);
	
				NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
				
				for (String serviceName : listServiceName) {
	
					TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);
	
					Thread.sleep(2000);
	
					OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
	
					switch (serviceName) {
					case "Professional Internet - Internet Pro":
						validSRDService = serviceRequestDateOnService_PI;
						requestInstallationDateService = requestInstallationDateOnService_PI;
						break;
					case "Enterprise Voice - Standard":
						validSRDService = serviceRequestDateOnService_EV;
						requestInstallationDateService = requestInstallationDateOnService_EV;
						break;
					default:
						break;
					}
	//				System.out.println("validSRDService: " + validSRDService);
	//				System.out.println("requestInstallationDateService: " + requestInstallationDateService);
	
					ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver,
							testName, validSRDService, requestInstallationDateService);
	
					ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
				}
	
				OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
				
				CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Professional Internet - Internet Pro");
	
				CasePCStep.validateServiceRequestDateFromOrderToCase(testExecStructure, logStream, driver, testName,
						requestInstallationDateOnProdConfig_EV);
	
			} catch (Exception e) {
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName + " - Test Case Failed");
			}
		}

	public static void SOI_4190_TC06_PC_SRD_ProductBasket_D02(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {
	
		String configurationIndex = "configurationByDefault";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		List<String> listProductsName = Arrays.asList("Professional Internet", "Enterprise Voice");
	
		List<String> listServiceName = Arrays.asList("Professional Internet - Internet Pro",
				"Enterprise Voice - Standard");
	
		String optyURL, productBasketName;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			// Dates forSRD on Product Basket Level
	
			String serviceRequestDateOnProdBasket = dates.get(7);
	
			String requestInstallationDateOnService = dates.get(9);
	
			String serviceRequestDateOnService = dates.get(8);
	
			// ---------------------------
	
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
	
				case "Enterprise Voice":
	
					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
					break;
	
				default:
					break;
				}
	
				EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
						"Requested Installation Date");
	
				EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
			}
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);
	
			Thread.sleep(5000);
	
			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");
	
			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice",
					"12345");
	
			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
			
			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
			for (String serviceName : listServiceName) {
	
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);
	
				Thread.sleep(2000);
	
				OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
	
				ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
						serviceRequestDateOnService);
	
				ServicePCStep.navigateToOrder(testExecStructure, logStream, driver, testName);
			}
			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "Professional Internet - Internet Pro");

			CasePCStep.validateServiceRequestDateFromOrderToCase(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);
	
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4190_TC07_DS_SRD_ProductBasket_ProductConfiguration_D02_D03(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
	
		String configurationIndex = "configurationByDefault";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		List<String> listProductsName = Arrays.asList("Enterprise Call & Surf Pro with Enterprise Voice",
				"Enterprise Voice", "PABX", "M2M KORE");
	
		List<String> listServiceName = Arrays.asList("Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)",
				"Enterprise Voice - Standard", "PABX", "M2M KORE");
	
		String optyURL, productBasketName, orderURL;
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
			// Dates for ECS Pro Pack
			String requestInstallationDateOnProdConfig_ECS = dates.get(7);
	
			String requestInstallationDateOnService_ECS = dates.get(9);
	
			String serviceRequestDateOnService_ECS = dates.get(8);
	
			// Dates for SRD on Product Basket Level
	
			String serviceRequestDateOnProdBasket = dates.get(6);
	
			String requestInstallationDateOnService = dates.get(3);
	
			String serviceRequestDateOnService = dates.get(4);
			// ---------------------------
	
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
	
				// EProdConfigStep.selectAddress(testExecStructure, logStream,
				// driver,testName,address);
	
				switch (productName) {
				case "Enterprise Call & Surf Pro with Enterprise Voice":
	
					ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
	
					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Internet Pro");
	
					EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
							"configurationByDefaultInternetCopper");
	
					EProdConfigStep.fillRequestInstallationDateField(testExecStructure, logStream, driver, testName,
							requestInstallationDateOnProdConfig_ECS);
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Enterprise Voice - Converged");
	
					EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, "configurationByDefaultEnterpriseVoice");
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Business Continuity");
	
					EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName,
							productName, "configurationByDefaultBusinessContinuity_Normal");
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
					break;
	
				case "Enterprise Voice":
					Thread.sleep(10000);
	
					ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
							productName);
	
					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
	
					EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
							"Requested Installation Date");
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
					break;
	
				default:
					break;
				}
	
			}
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);
	
			Thread.sleep(5000);
	
			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");
	
			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Converged",
					"12345");
			
			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Standard",
					"12345");
	
			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
			
			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
			orderURL = driver.getCurrentUrl();
	
			for (String serviceName : listServiceName) {
	
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);
	
				Thread.sleep(2000);
	
				OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
	
				if (serviceName.contains("Pack") == true) {
	
					ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
							serviceRequestDateOnService_ECS);
	
					ServiceStep.navigateToInternetECS_PC(testExecStructure, logStream, driver, testName, "Internet Pro");
	
					ServiceStep.validateServiceRequestDateFromProdConfiguration(testExecStructure, logStream, driver,
							testName, serviceRequestDateOnService_ECS, requestInstallationDateOnService_ECS);
	
				} else if (serviceName.contains("PABX") || serviceName.contains("M2M KORE")) {
	
					ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
							serviceRequestDateOnService);
	
					ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");
	
				} else {
	
					ServiceStep.validateServiceRequestDateFromProdBasket(testExecStructure, logStream, driver, testName,
							serviceRequestDateOnService);
				}
	
				NavigationStep.goToOrderByURLInPC(testExecStructure, logStream, driver, testName, orderURL);
			}

			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			CasePCNavigation.goToCaseScreenByServiceName(testExecStructure, logStream, driver, testName, "PABX");

			CasePCStep.validateServiceRequestDateFromOrderToCase(testExecStructure, logStream, driver, testName,
					serviceRequestDateOnProdBasket);
	
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}

	public static void SOI_4190_TC08_PC_SRD_NotFilled_D02(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
	
		String configurationIndex = "configurationByDefault";
	
		String userProfile = "farmerUser";
	
		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";
	
		List<String> listProductsName = Arrays.asList("Enterprise Call & Surf Pro with Enterprise Voice",
				"Enterprise Voice", "PABX", "M2M KORE");
	
		List<String> listServiceName = Arrays.asList("Pack Enterprise Call & Surf with Pro / Enterprise Voice (16)",
				"Enterprise Voice - Standard", "PABX", "M2M KORE");
	
		String optyURL, productBasketName, orderURL;
	
	
		try {
	
			List<String> dates = GeneralTestingFramework.generateListOfDatesMultipleFormats();
	
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
	
				// EProdConfigStep.selectAddress(testExecStructure, logStream,
				// driver,testName,address);
	
				switch (productName) {
				case "Enterprise Call & Surf Pro with Enterprise Voice":
	
					ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
	
					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Internet Pro");
	
					EProdConfigStep.configureECSInternet(testExecStructure, logStream, driver, testName, productName,
							"configurationByDefaultInternetCopper");
	
					EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
							"Requested Installation Date");
					
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Enterprise Voice - Converged");
	
					EProdConfigStep.configureECSEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, "configurationByDefaultEnterpriseVoice");
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
	
					ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver,
							testName, productName, "Business Continuity");
	
					EProdConfigStep.configureECSBusinessContinuity(testExecStructure, logStream, driver, testName,
							productName, "configurationByDefaultBusinessContinuity_Normal");
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
					break;
	
				case "Enterprise Voice":
					Thread.sleep(10000);
	
					ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
							productName);
	
					EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName,
							productName, configurationIndex);
	
					EProdConfigStep.clearFieldValue(testExecStructure, logStream, driver, testName,
							"Requested Installation Date");
	
					EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);
					break;
	
				default:
					break;
				}
	
			}
	
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
					"First User");
	
			Thread.sleep(5000);
	
			ProductBasketStep.goToOrderEnrichment(testExecStructure, logStream, driver, testName, "Enterprise Voice");
			
			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Converged","12345");
			
			OrderEnrichmentStep.fillDataCapFormEV(testExecStructure, logStream, driver, testName, "Enterprise Voice - Standard","12345");
	
			OrderEnrichmentStep.backToProductBasket(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
	
			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
	
			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
	
			orderURL = driver.getCurrentUrl();
	
			for (String serviceName : listServiceName) {
	
				TestLogger.logDebug(logStream, "goToServiceScreen", "Service name: " + serviceName);
	
				Thread.sleep(2000);
	
				OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, serviceName);
	
				if (serviceName.contains("Pack") == true) {
	
					ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
					ServiceStep.navigateToInternetECS_PC(testExecStructure, logStream, driver, testName, "Internet Pro");
	
					ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
				} else if (serviceName.contains("PABX") || serviceName.contains("M2M KORE")) {
	
					ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
					ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, "New");
	
				} else {
	
					ServiceStep.validateServiceRequestDateNegative(testExecStructure, logStream, driver, testName);
	
				}
				NavigationStep.goToOrderByURLInPC(testExecStructure, logStream, driver, testName, orderURL);
			}

			OrderPCStep.submitOrderNegativeValPC(testExecStructure, logStream, driver, testName);
	
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
}
