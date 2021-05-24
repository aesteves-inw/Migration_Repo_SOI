package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import editProductConfigurationScreenDirectSales.EProdConfigStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import orderDirectSales.OrderStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceNavigation;
import serviceDirectSales.ServiceStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3825 {
	public static void SOI_3825_TC01_DS_OCK_Check_ECS_Pro_PhoneLine(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		String userProfile="salesUser";

		String productName="Enterprise Call & Surf Pro with Phone Line";


		String optyURL;

		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			D02Models.AddAnyProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.expandECSPackage(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreenECS(testExecStructure, logStream, driver, testName, "Professional Internet");
			
			EProdConfigStep.OCK_CheckInternetECS_Pro(testExecStructure, logStream, driver, testName, productName);



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
