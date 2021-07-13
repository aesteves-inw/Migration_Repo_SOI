package delivery03;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementPartCom.AgreementPCStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import executionTools.TestExecutionReport;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import productBasketDirectSales.ProductBasketStep;
import testExecutionData.ProductConfigurationD02;
import testFrameworkLibrary.D02Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3925 {

	public static void SOI_3925_TC01_DS_OCK_ContractTerm_Professional_Internet(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "contractHigher24MonthsConfiguration";

		String userProfile = "salesUser";

		String provContactPerson = "First User";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				agreementDirectSales.AgreementStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure,
						logStream, driver, testName, lang);

				agreementDirectSales.AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver,
						testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementDirectSales.AgreementStep.validateProposalPDFContentByRegex(testExecStructure, logStream,
						driver, testName, legalClauseTxt, lang, listvalidRegexByLang, true);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC02_DS_OCK_ContractTerm_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String configurationIndex = "contractHigher24MonthsConfiguration";

		String userProfile = "salesUser";

		String provContactPerson = "First User";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);

			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				agreementDirectSales.AgreementStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure,
						logStream, driver, testName, lang);

				agreementDirectSales.AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver,
						testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementDirectSales.AgreementStep.validateProposalPDFContentByRegex(testExecStructure, logStream,
						driver, testName, legalClauseTxt, lang, listvalidRegexByLang, true);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC03_DS_OCK_ContractTerm_Professional_Internet_Negative_Part1(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String provContactPerson = "First User";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				agreementDirectSales.AgreementStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure,
						logStream, driver, testName, lang);

				agreementDirectSales.AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver,
						testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementDirectSales.AgreementStep.validateProposalPDFContentByRegex(testExecStructure, logStream,
						driver, testName, legalClauseTxt, lang, listvalidRegexByLang, false);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC04_DS_OCK_ContractTerm_Professional_Internet_Negative_Part2(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "contractEqual24MonthsConfiguration";

		String userProfile = "salesUser";

		String provContactPerson = "First User";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				agreementDirectSales.AgreementStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure,
						logStream, driver, testName, lang);

				agreementDirectSales.AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver,
						testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementDirectSales.AgreementStep.validateProposalPDFContentByRegex(testExecStructure, logStream,
						driver, testName, legalClauseTxt, lang, listvalidRegexByLang, false);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC05_DS_OCK_ContractTerm_EnterpriseVoice_Negative_Part1(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String provContactPerson = "First User";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);

			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				agreementDirectSales.AgreementStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure,
						logStream, driver, testName, lang);

				agreementDirectSales.AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver,
						testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementDirectSales.AgreementStep.validateProposalPDFContentByRegex(testExecStructure, logStream,
						driver, testName, legalClauseTxt, lang, listvalidRegexByLang, false);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC07_PC_OCK_ContractTerm_Professional_Internet(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "contractHigher24MonthsConfiguration";

		String userProfile = "farmerUser";

		String provContactPerson = "First User";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

//			String address ="Rue J Besme,20, Koekelberg, 1081, Belgium";

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

//				EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				Thread.sleep(3000);

				AgreementPCStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure, logStream, driver,
						testName, lang);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementPartCom.AgreementPCStep.validateProposalPDFContentByRegex(testExecStructure, logStream, driver,
						testName, legalClauseTxt, lang, listvalidRegexByLang, true);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC08_PC_OCK_ContractTerm_EnterpriseVoice(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String configurationIndex = "contractHigher24MonthsConfiguration";

		String userProfile = "farmerUser";

		String provContactPerson = "First User";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);

			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				AgreementPCStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure, logStream, driver,
						testName, lang);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementPartCom.AgreementPCStep.validateProposalPDFContentByRegex(testExecStructure, logStream, driver,
						testName, legalClauseTxt, lang, listvalidRegexByLang, true);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC09_PC_OCK_ContractTerm_Professional_Internet_Negative_Part1(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "configurationByDefault";

		String userProfile = "farmerUser";

		String provContactPerson = "First User";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				AgreementPCStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure, logStream, driver,
						testName, lang);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementPartCom.AgreementPCStep.validateProposalPDFContentByRegex(testExecStructure, logStream, driver,
						testName, legalClauseTxt, lang, listvalidRegexByLang, false);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC10_PC_OCK_ContractTerm_Professional_Internet_Negative_Part2(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Professional Internet";

		String configurationIndex = "contractEqual24MonthsConfiguration";

		String userProfile = "farmerUser";

		String provContactPerson = "First User";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.configureProfessionalInternet(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				AgreementPCStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure, logStream, driver,
						testName, lang);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementPartCom.AgreementPCStep.validateProposalPDFContentByRegex(testExecStructure, logStream, driver,
						testName, legalClauseTxt, lang, listvalidRegexByLang, false);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

	public static void SOI_3925_TC11_PC_OCK_ContractTerm_EnterpriseVoice_Negative_Part1(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Voice";

		String configurationIndex = "configurationByDefault";

		String userProfile = "farmerUser";

		String provContactPerson = "First User";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		List<String> languagesDocProposal = Arrays.asList("EN", "FR", "NL");

		String varLegalClause = null;

		String listvalidRegexByLang = null;

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

			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName,
					productName);

			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);

			EProdConfigStep.configureEnterpriseVoice(testExecStructure, logStream, driver, testName, productName,
					configurationIndex);

			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			for (String lang : languagesDocProposal) {
				switch (lang) {
				case ("EN"):
					varLegalClause = "telcoLegalClauseAgreeDoc_EN";
					listvalidRegexByLang = "By signing this order form, the Customer(.*)declares that he renounces it.";
					break;
				case ("FR"):
					varLegalClause = "telcoLegalClauseAgreeDoc_FR";
					listvalidRegexByLang = "En signant le présent bon de commande, le Client(.*)déclare y renoncer.";
					break;
				case ("NL"):
					varLegalClause = "telcoLegalClauseAgreeDoc_NL";
					listvalidRegexByLang = "Door ondertekening van deze bestelbon erkent de Klant(.*)verklaart hij daarvan af te zien.";
					break;
				default:
					System.out.println("Current language is not supported: " + lang);
				}

				AgreementPCStep.changeLanguageBeforeGeneratingDocumentProposal(testExecStructure, logStream, driver,
						testName, lang);

				AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

				String legalClauseTxt = testExecutionData.TestCasesData
						.getVariableValueFromExcelTestData("ProductConfigurationD02", varLegalClause);

				System.out.println("Telco Legal clause: " + legalClauseTxt);

				agreementPartCom.AgreementPCStep.validateProposalPDFContentByRegex(testExecStructure, logStream, driver,
						testName, legalClauseTxt, lang, listvalidRegexByLang, false);

			}
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

}
