package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3603 
{

	public static void SOI_3603_TC01_DS_Existing_TechnicalContact_PBasketLevel(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		
		String userProfile="salesUser";
		
		String textExistingTechnicalContact="First User";
		
		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			//String optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);

			String pbURL=driver.getCurrentUrl();
			System.out.println("Validation of pbURL :"+pbURL);

			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, textExistingTechnicalContact);
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}


	}

	public static void SOI_3603_TC02_PC_Existing_TechnicalContact_PBasketLevel(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String userProfile="farmerUser";
		
		String textExistingTechnicalContact="First User";
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, userProfile);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			String pbURL=driver.getCurrentUrl();
			System.out.println("Validation of pbURL :"+pbURL);

			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, textExistingTechnicalContact);
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

}
