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
import productBasketDirectSales.ProductBasketStep;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_4196 {
	public static void SOI_4196_TC01_DS_OCK_Filtering_API_Response_EnterpriseVoice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="salesUser";

		String optyURL;

		String productBasketName;
		
		String productName = "Enterprise Voice";
		
		String address ="P Fredericqstr,18, Gent, 9000, Belgium";
		

		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyNoDuplicatesOptions(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}
	
	public static void SOI_4196_TC02_PC_OCK_Filtering_API_Response_EnterpriseVoice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String userProfile="farmerUser";

		String optyURL;

		String productBasketName;
		
		String productName = "Enterprise Voice";
		
		String address ="P Fredericqstr,18, Gent, 9000, Belgium";
		

		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage


			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productName);
			
			ProductBasketStep.goToEditProductConfigurationScreen(testExecStructure, logStream, driver, testName, productName);
			
			EProdConfigStep.selectAddress(testExecStructure, logStream, driver, testName, address);
			
			EProdConfigStep.validateAccessTechnologyNoDuplicatesOptions(testExecStructure, logStream, driver, testName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
