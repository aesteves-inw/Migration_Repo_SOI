package testFrameworkLibrary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import companyPartCom.CompanyPCStep;
import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import homePagePartCom.HomePagePCStep;
import loginPagePartCom.LoginPagePCStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityPartCom.OpportunityPCStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class GeneralTestingFramework {
	public static void E2EPartnersCommunity(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception {
		String user = "farmerUser";

		try {
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName + ": Test Case Failed on Test Model - PartnersCommunity");
		}
	}

	// Method to be used only on 'Add Offer To Basket' Screen
	public static List<String> generateListWithAllProductsFromGivenSection(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName,
			String section) throws Exception {
		int stepID = TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName = "Auxiliar Method: Generate a List with All Product From a Given Section";

		String stepNameMin = "generateListWithAllProductsFromGivenSection";

		String evidenceName = ReportStructure.evidenceName(stepID, stepNameMin);

		String sectionXpath = null;

		String actionName = "generateListWithAllProductsFromGivenSection";

		try {

			switch (section) {
			case "Adv Telco Sol":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_AdvTelcoSol;
				break;

			case "Advanced Workplace":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_AdvancedWorkplace;
				break;

			case "Compute & Storage":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_ComputeStorage;
				break;

			case "DNS/Webhosting":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_DNSWebhosting;
				break;

			case "Enterprise Pack Together":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_EnterprisePackTogether;
				break;

			case "IOT & Analytics":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_IOTAnalytics;
				break;

			case "Mass Market":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_MassMarket;
				break;

			case "Mobile":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_Mobile;
				break;

			case "Netw Conn & Serv":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_NetwConnServ;
				break;

			case "Next Gen Comm":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_NextGenComm;
				break;

			case "Voice":

				sectionXpath = DirSalesProductBasket.categoryExternallyQuotedProducts_Voice;
				break;

			default:
				break;
			}

			WebElement webSection = driver.findElement(By.xpath(sectionXpath));

			BrowserActions.verticalscrollByVisibleElement(driver, sectionXpath);

			String sectionLineItems = webSection.getText();

//				System.out.println(sectionLineItems);

			String[] elements = sectionLineItems.split("\\r?\\n");

			List<String> listProductsName = new ArrayList<String>(Arrays.asList(elements));

			// Removes 1st element String which is the name of the section
			listProductsName.remove(new String(section));

//		        System.out.println("Comma separated List: "+ listProductsName);

			TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
//				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);

			return listProductsName;

		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
//				TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception(stepName + " - Failed in Step: " + stepID);
		}
	}

	public static List<String> generateListOfDatesMultipleFormats() throws Exception {

		List<String> datesSRD = new ArrayList<>();

		try {

			LocalDateTime todayDate = LocalDateTime.now();
			
			LocalDateTime tenDaysFromTodayDate = todayDate.plusDays(10);
			
			LocalDateTime tomorrowDate = todayDate.plusDays(4);

			LocalDateTime yesterdayDate = todayDate.minusDays(1);

			DateTimeFormatter dateFormatterDefault = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			DateTimeFormatter dateFormatterSRDService = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			
			DateTimeFormatter dateFormatterReqInstallationDateService = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			//Dates for Product Basket
			String todayDateProdBasketFormat = dateFormatterDefault.format(todayDate);

			System.out.println("todayDateProdBasketFormat:" + todayDateProdBasketFormat);
			
			String yesterdayDateProdBasketFormat = dateFormatterDefault.format(yesterdayDate);

			System.out.println("yesterdayDateProdBasketFormat:" + yesterdayDateProdBasketFormat);
			
			String tomorrowDateProdBasketFormat = dateFormatterDefault.format(tomorrowDate);

			System.out.println("tomorrowDateProdBasketFormat:" + tomorrowDateProdBasketFormat);
			
			String tenDaysFromTodayDateProdBasketFormat = dateFormatterDefault.format(tenDaysFromTodayDate);

			System.out.println("tenDaysFromTodayDateProdBasketFormat:" + tenDaysFromTodayDateProdBasketFormat);
			
			
			//Dates on Service Level
			
			String todayDateSRDFormatService = dateFormatterSRDService.format(todayDate);

			System.out.println("todayDateSRDFormatService:" + todayDateSRDFormatService);
			
			String tomorrowDateReqInstallationDateFormatService = dateFormatterReqInstallationDateService.format(tomorrowDate);

			System.out.println("tomorrowDateReqInstallationDateFormatService:" + tomorrowDateReqInstallationDateFormatService);
			
			String tomorrowDateSRDFormatService = dateFormatterSRDService.format(tomorrowDate);

			System.out.println("tomorrowDateSRDFormatService:" + tomorrowDateSRDFormatService);
			
			String yesterdayDateSRDFormatService = dateFormatterSRDService.format(yesterdayDate);

			System.out.println("yesterdayDateSRDFormatService:" + yesterdayDateSRDFormatService);
			
			String tenDaysFromTodayDateSRDFormatService = dateFormatterSRDService.format(tenDaysFromTodayDate);

			System.out.println("tenDaysFromTodayDateSRDFormatService:" + tenDaysFromTodayDateSRDFormatService);
			
			
			String tenDaysFromTodayDatReqInstallationDateFormatService = dateFormatterReqInstallationDateService.format(tenDaysFromTodayDate);

			System.out.println("tenDaysFromTodayDatReqInstallationDateFormatService:" + tenDaysFromTodayDatReqInstallationDateFormatService);
			
			
			datesSRD.add(yesterdayDateProdBasketFormat);

			datesSRD.add(todayDateProdBasketFormat);
			
			datesSRD.add(todayDateSRDFormatService);
			
			datesSRD.add(tomorrowDateReqInstallationDateFormatService);
			
			datesSRD.add(tomorrowDateSRDFormatService);
			
			datesSRD.add(yesterdayDateSRDFormatService);
			
			datesSRD.add(tomorrowDateProdBasketFormat);
			
			datesSRD.add(tenDaysFromTodayDateProdBasketFormat);
			
			datesSRD.add(tenDaysFromTodayDateSRDFormatService);
			
			datesSRD.add(tenDaysFromTodayDatReqInstallationDateFormatService);


		} catch (Exception e) {
			System.out.println(e);
			throw new Exception(
					"Test Failed to generate yesterday and today's date. See method GeneralTestingFramework.generateYesterdayTodayDateFormatter."
							+ e.toString());
		}
		
		return datesSRD;

	}
}
