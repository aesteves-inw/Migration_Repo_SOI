package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3600 {

	public static void SOI_3600_TC01_DS_NewBA_ProductBasket(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String product = "PABX";
		
		String userProfile="salesUser";
		
		String productName="Phone Line";
		
		String configurationIndex="configurationByDefault";
		

		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);
			
			//D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
		
			ProductBasketStep.fillNewAndExistingBillingDetails(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.cancelProductBasketEdition(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillNewBillingAccountAddress(testExecStructure, logStream, driver, testName, productName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

	public static void SOI_3600_TC02_PC_NewBA_ProductBasket(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String product = "PABX";
		
		String user="farmerUser";
		
		
		String productName="Phone Line";
		
		String configurationIndex="configurationByDefault";
		
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
            
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
            			
			ProductBasketStep.fillNewAndExistingBillingDetails(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.cancelProductBasketEdition(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillNewBillingAccountAddress(testExecStructure, logStream, driver, testName, productName);
            
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
		
	}

}
