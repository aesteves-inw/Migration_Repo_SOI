package delivery03;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.GeneralTestingFramework;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4025 {
	

	public static void SOI_4025_TC01_DS_SRD_Field_StandaloneProducts(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception {

//		List<String> listProductsName = Arrays.asList("Professional Internet", "Phone Line", "Voice Continuity",
//				"Enterprise Voice");

		List<String> listProductsName = Arrays.asList("Professional Internet", "Voice Continuity", "Enterprise Voice");

		String configurationIndex = "configurationByDefault";

		String userProfile = "salesUser";

		String address = "Rue J Besme,20, Koekelberg, 1081, Belgium";

		String optyURL, productBasketName;

		try {

//			LocalDateTime todayDate = LocalDateTime.now();
//
//			LocalDateTime yesterdayDate = todayDate.minusDays(1);
//
//			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//			String validSRD = dateFormatter.format(todayDate);
//
//			System.out.println("validSRD:" + validSRD);
//
//			String invalidSRD = dateFormatter.format(yesterdayDate);
//
//			System.out.println("invalidSRD:" + invalidSRD);
			
			 List <String> datesSRD = GeneralTestingFramework.generateYesterdayTodayDateFormatter();

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

				ProductBasketStep.fillNewBillingAccountAddress(testExecStructure, logStream, driver, testName, "12345");

				ProductBasketStep.fillProvisoningContactPersonDetails(testExecStructure, logStream, driver, testName,
						"First User");

				ProductBasketStep.fillServiceRequestDateNegVal(testExecStructure, logStream, driver, testName,
						datesSRD.get(0));

				ProductBasketStep.fillServiceRequestDate(testExecStructure, logStream, driver, testName, datesSRD.get(1));


		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}
	}
}
