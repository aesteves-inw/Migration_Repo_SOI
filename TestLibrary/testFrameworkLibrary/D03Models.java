package testFrameworkLibrary;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import opportunityDirectSales.OpportunityStep;
import productBasketDirectSales.ProductBasketStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class D03Models 
{

	public static void E2FFlowForD03(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String product, String configurationProduct) throws Exception 
	{
		try
		{

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, product);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, product);
			
			EProdConfigStep.configureNonQuotableProduct(testExecStructure, logStream, driver, testName, configurationProduct);
			
			EProdConfigStep.finsihConfiguration(testExecStructure, logStream, driver, testName);	
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - E2FFlowForD03");
		}
		
	}

}
