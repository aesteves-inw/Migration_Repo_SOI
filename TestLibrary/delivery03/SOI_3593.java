package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import agreementDirectSales.AgreementStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import productBasketDirectSales.ProductBasketStep;
import testDataFiles.TestDataFiles;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3593 {
	public static void SOI_3593_TC01_DS_D03_OfferGeneration_General(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName, String product) throws Exception 
	{
			
			String userProfile="salesUser";
			
			
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

				D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}
	}
	
	public static void SOI_3593_TC01_PC_D03_OfferGeneration_General(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName, String product) throws Exception 
	{
			
			String userProfile="farmerUser";
			
			
			String optyURL;

			try
			{
				LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

				HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

				CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);
				
				optyURL=driver.getCurrentUrl();
				
				OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
				
				//variable storage
				String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
				TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
				//end of variable storage

				D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}
	}

}
