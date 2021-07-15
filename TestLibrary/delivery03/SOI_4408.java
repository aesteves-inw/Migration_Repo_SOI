package delivery03;

import java.util.Arrays;
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
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4408 {
	public static void SOI_4408_TC01_DS_OCK_NewColumns_ECS_FullFiberExtended(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName)
			throws Exception {
		String productName = "Enterprise Call & Surf FullFiber Extended";

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
			
			ProductBasketStep.selectInternetECSPackage(testExecStructure, logStream, driver, testName, productName);

			
		} catch (Exception e) {
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName + " - Test Case Failed");
		}

	}

}
